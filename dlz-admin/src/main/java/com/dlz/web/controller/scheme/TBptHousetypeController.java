package com.dlz.web.controller.scheme;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.dlz.common.annotation.Log;
import com.dlz.common.config.Global;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TBptHousetype;
import com.dlz.scheme.service.ITBptHousetypeService;
import com.dlz.web.controller.system.SysProfileController;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 户型Controller
 * 
 * @author lizhiyu
 * @date 2019-12-16
 */
@Controller
@RequestMapping("/scheme/housetype")
public class TBptHousetypeController extends BaseController
{
	private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);
    private String prefix = "scheme/housetype";

    @Autowired
    private ITBptHousetypeService tBptHousetypeService;

    @RequiresPermissions("scheme:housetype:view")
    @GetMapping()
    public String housetype()
    {
        return prefix + "/housetype";
    }

    /**
     * 查询户型列表
     */
    @RequiresPermissions("scheme:housetype:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptHousetype tBptHousetype)
    {
        startPage();
        List<TBptHousetype> list = tBptHousetypeService.selectTBptHousetypeList(tBptHousetype);
        return getDataTable(list);
    }

    /**
     * 导出户型列表
     */
    @RequiresPermissions("scheme:housetype:export")
    @Log(title = "户型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptHousetype tBptHousetype)
    {
        List<TBptHousetype> list = tBptHousetypeService.selectTBptHousetypeList(tBptHousetype);
        ExcelUtil<TBptHousetype> util = new ExcelUtil<TBptHousetype>(TBptHousetype.class);
        return util.exportExcel(list, "housetype");
    }

    /**
     * 新增户型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存户型
     */
    @RequiresPermissions("scheme:housetype:add")
    @Log(title = "户型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("houseType-file") MultipartFile file,@RequestParam("formData") String formData)
    {
    	try {
			if (!file.isEmpty()) {
				String path = FileUploadUtils.upload(Global.getHouseTypePath(), file);
				String fileName=file.getOriginalFilename();
				JSONObject formParam=URLStringToJsonUtil.convertJson(formData);
                TBptHousetype tBptHousetype = JSONObject.toJavaObject(formParam, TBptHousetype.class);
				tBptHousetype.setFileNm(fileName);
				tBptHousetype.setPath(path);
				if (formParam.containsKey("memo")) {
					tBptHousetype.setMemo(formParam.getString("memo").toString());
				}
				return toAjax(tBptHousetypeService.insertTBptHousetype(tBptHousetype));
			}
			return error();
		} catch (Exception e) {
			log.error("文件上传失败！", e);
            return error(e.getMessage());
		}
    	
    }

    /**
     * 修改户型
     */
    @GetMapping("/edit/{htid}")
    public String edit(@PathVariable("htid") Long htid, ModelMap mmap)
    {
        TBptHousetype tBptHousetype = tBptHousetypeService.selectTBptHousetypeById(htid);
        mmap.put("tBptHousetype", tBptHousetype);
        return prefix + "/edit";
    }

    /**
     * 修改保存户型
     */
    @RequiresPermissions("scheme:housetype:edit")
    @Log(title = "户型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBptHousetype tBptHousetype)
    {
        return toAjax(tBptHousetypeService.updateTBptHousetype(tBptHousetype));
    }

    /**
     * 删除户型
     */
    @RequiresPermissions("scheme:housetype:remove")
    @Log(title = "户型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptHousetypeService.deleteTBptHousetypeByIds(ids));
    }
}
