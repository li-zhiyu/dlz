package com.dlz.web.controller.scheme;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.dlz.common.config.Global;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import com.dlz.scheme.domain.TBptComponentnode;
import com.dlz.web.controller.system.SysProfileController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.dlz.common.annotation.Log;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.service.ITBptComponentService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 构件库管理Controller
 * 
 * @author lizhiyu
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/scheme/component")
public class TBptComponentController extends BaseController
{
    private String prefix = "scheme/component";
    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    @Autowired
    private ITBptComponentService tBptComponentService;

    @RequiresPermissions("scheme:component:view")
    @GetMapping()
    public String component()
    {
        return prefix + "/component";
    }

    /**
     * 查询构件库管理列表
     */
    @RequiresPermissions("scheme:component:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptComponent tBptComponent)
    {
        startPage();
        List<TBptComponent> list = tBptComponentService.selectTBptComponentList(tBptComponent);
        return getDataTable(list);
    }

    /**
     * 查询项目未绑定的构件列表
     */
    @RequiresPermissions("scheme:component:list")
    @PostMapping("/unbindlist")
    @ResponseBody
    public TableDataInfo unbindlist(TBptComponent tBptComponent)
    {
        startPage();
        List<TBptComponent> list = tBptComponentService.selectTBptComponentUnbindList(tBptComponent);
        return getDataTable(list);
    }

    /**
     * 通过项目ID查询构件库管理列表
     */
    @RequiresPermissions("scheme:component:list")
    @PostMapping("/listBypjtid")
    @ResponseBody
    public TableDataInfo listBypjtid( TBptComponent tBptComponent)
    {
        startPage();
        List<TBptComponent> list = tBptComponentService.selectTBptComponentListBypjtid(tBptComponent);
        return getDataTable(list);
    }

    /**
     * 取消构件绑定
     */
    @RequiresPermissions("scheme:component:list")
    @PostMapping("/cancel")
    @ResponseBody
    public AjaxResult cancel(String pjtid, String cpid)
    {
        return toAjax(tBptComponentService.cancel(pjtid, cpid));
    }

    /**
     * 导出构件库管理列表
     */
    @RequiresPermissions("scheme:component:export")
    @Log(title = "构件库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptComponent tBptComponent)
    {
        List<TBptComponent> list = tBptComponentService.selectTBptComponentList(tBptComponent);
        ExcelUtil<TBptComponent> util = new ExcelUtil<TBptComponent>(TBptComponent.class);
        return util.exportExcel(list, "component");
    }

    /**
     * 新增构件库管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 构件与项目绑定页面
     */
    @GetMapping("/select/{id}")
    public String select(@PathVariable("id") Long pjtid, ModelMap mmap)
    {
        mmap.put("pjtid",pjtid);
        return "scheme/info"+"/selectComponent";
    }

    /**
     * 新增构件到项目中
     */
    @RequiresPermissions("scheme:component:list")
    @Log(title = "构件库管理", businessType = BusinessType.INSERT)
    @PostMapping("/bindAll")
    @ResponseBody
    public AjaxResult bindAll(String pjtid, String cpids)
    {
        return toAjax(tBptComponentService.batchBindComponent(pjtid , cpids));
    }

    /**
     * 新增保存构件库管理
     */
    @RequiresPermissions("scheme:component:add")
    @Log(title = "构件库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file, @RequestParam("formData") String formData)
    {
        try {
            if (!file.isEmpty()) {
                String path = FileUploadUtils.upload(Global.getComponentPath(), file);
                String fileName=file.getOriginalFilename();
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);
                TBptComponent tBptComponent = JSONObject.toJavaObject(formParam, TBptComponent.class);
                tBptComponent.setFileNm(fileName);
                tBptComponent.setPath(path);
                if (formParam.containsKey("memo")) {
                    tBptComponent.setMemo(formParam.getString("memo").toString());
                }
                return toAjax(tBptComponentService.insertTBptComponent(tBptComponent));
            }
            return error();
        } catch (Exception e) {
            log.error("文件上传失败！", e);
            return error(e.getMessage());
        }
    }

    /**
     * 修改构件库管理
     */
    @GetMapping("/edit/{cpid}")
    public String edit(@PathVariable("cpid") Long cpid, ModelMap mmap)
    {
        TBptComponent tBptComponent = tBptComponentService.selectTBptComponentById(cpid);
        mmap.put("tBptComponent", tBptComponent);
        return prefix + "/edit";
    }

    /**
     * 修改保存构件库管理
     */
    @RequiresPermissions("scheme:component:edit")
    @Log(title = "构件库管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBptComponent tBptComponent)
    {
        return toAjax(tBptComponentService.updateTBptComponent(tBptComponent));
    }

    /**
     * 删除构件库管理
     */
    @RequiresPermissions("scheme:component:remove")
    @Log(title = "构件库管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptComponentService.deleteTBptComponentByIds(ids));
    }
}
