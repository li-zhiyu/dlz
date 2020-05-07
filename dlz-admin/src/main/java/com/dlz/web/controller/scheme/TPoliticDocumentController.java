package com.dlz.web.controller.scheme;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.dlz.common.config.Global;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import com.dlz.framework.util.ShiroUtils;
import com.dlz.scheme.domain.TBptComponent;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.dlz.common.annotation.Log;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TPoliticDocument;
import com.dlz.scheme.service.ITPoliticDocumentService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 政策文件Controller
 * 
 * @author lizhiyu
 * @date 2020-05-05
 */
@Controller
@RequestMapping("/scheme/document")
public class TPoliticDocumentController extends BaseController
{
    private String prefix = "scheme/document";

    @Autowired
    private ITPoliticDocumentService tPoliticDocumentService;

    @RequiresPermissions("scheme:document:view")
    @GetMapping()
    public String document()
    {
        return prefix + "/document";
    }

    /**
     * 查询政策文件列表
     */
    @RequiresPermissions("scheme:document:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPoliticDocument tPoliticDocument)
    {
        startPage();
        List<TPoliticDocument> list = tPoliticDocumentService.selectTPoliticDocumentList(tPoliticDocument);
        return getDataTable(list);
    }

    /**
     * 导出政策文件列表
     */
    @RequiresPermissions("scheme:document:export")
    @Log(title = "政策文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TPoliticDocument tPoliticDocument)
    {
        List<TPoliticDocument> list = tPoliticDocumentService.selectTPoliticDocumentList(tPoliticDocument);
        ExcelUtil<TPoliticDocument> util = new ExcelUtil<TPoliticDocument>(TPoliticDocument.class);
        return util.exportExcel(list, "document");
    }

    /**
     * 新增政策文件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存政策文件
     */
    @RequiresPermissions("scheme:document:add")
    @Log(title = "政策文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("document-file") MultipartFile file, @RequestParam("formData") String formData)
    {
        try {
            if (!file.isEmpty()) {
                String path = FileUploadUtils.upload(Global.getDocumentPath(), file);
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);
                String fileName=file.getOriginalFilename();
                TPoliticDocument tPoliticDocument = JSONObject.toJavaObject(formParam, TPoliticDocument.class);
                tPoliticDocument.setPath(path);
                tPoliticDocument.setPdNm(fileName);
                tPoliticDocument.setCreator(ShiroUtils.getLoginName());
                return toAjax(tPoliticDocumentService.insertTPoliticDocument(tPoliticDocument));
            }
            return error();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 修改政策文件
     */
    @GetMapping("/edit/{pdid}")
    public String edit(@PathVariable("pdid") Long pdid, ModelMap mmap)
    {
        TPoliticDocument tPoliticDocument = tPoliticDocumentService.selectTPoliticDocumentById(pdid);
        mmap.put("tPoliticDocument", tPoliticDocument);
        return prefix + "/edit";
    }

    /**
     * 修改保存政策文件
     */
    @RequiresPermissions("scheme:document:edit")
    @Log(title = "政策文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPoliticDocument tPoliticDocument)
    {
        return toAjax(tPoliticDocumentService.updateTPoliticDocument(tPoliticDocument));
    }

    /**
     * 删除政策文件
     */
    @RequiresPermissions("scheme:document:remove")
    @Log(title = "政策文件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPoliticDocumentService.deleteTPoliticDocumentByIds(ids));
    }
}
