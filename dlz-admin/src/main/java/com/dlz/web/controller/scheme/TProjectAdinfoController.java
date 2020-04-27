package com.dlz.web.controller.scheme;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.dlz.common.annotation.Log;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TProjectAdinfo;
import com.dlz.scheme.service.ITProjectAdinfoService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 方案对比数据Controller
 * 
 * @author lizhiyu
 * @date 2020-04-03
 */
@Controller
@RequestMapping("/scheme/adinfo")
public class TProjectAdinfoController extends BaseController
{
    private String prefix = "scheme/adinfo";

    @Autowired
    private ITProjectAdinfoService tProjectAdinfoService;

    @RequiresPermissions("scheme:adinfo:view")
    @GetMapping()
    public String adinfo()
    {
        return prefix + "/adinfo";
    }

    /**
     * 查询方案对比数据列表
     */
    @RequiresPermissions("scheme:adinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectAdinfo tProjectAdinfo)
    {
        startPage();
        List<TProjectAdinfo> list = tProjectAdinfoService.selectTProjectAdinfoList(tProjectAdinfo);
        return getDataTable(list);
    }

    /**
     * 导出方案对比数据列表
     */
    @RequiresPermissions("scheme:adinfo:export")
    @Log(title = "方案对比数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectAdinfo tProjectAdinfo)
    {
        List<TProjectAdinfo> list = tProjectAdinfoService.selectTProjectAdinfoList(tProjectAdinfo);
        ExcelUtil<TProjectAdinfo> util = new ExcelUtil<TProjectAdinfo>(TProjectAdinfo.class);
        return util.exportExcel(list, "adinfo");
    }

    /**
     * 新增方案对比数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存方案对比数据
     */
    @RequiresPermissions("scheme:adinfo:add")
    @Log(title = "方案对比数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectAdinfo tProjectAdinfo)
    {
        return toAjax(tProjectAdinfoService.insertTProjectAdinfo(tProjectAdinfo));
    }

    /**
     * 修改方案对比数据
     */
    @GetMapping("/edit/{padid}")
    public String edit(@PathVariable("padid") Long padid, ModelMap mmap)
    {
        TProjectAdinfo tProjectAdinfo = tProjectAdinfoService.selectTProjectAdinfoById(padid);
        mmap.put("tProjectAdinfo", tProjectAdinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存方案对比数据
     */
    @RequiresPermissions("scheme:adinfo:edit")
    @Log(title = "方案对比数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectAdinfo tProjectAdinfo)
    {
        return toAjax(tProjectAdinfoService.updateTProjectAdinfo(tProjectAdinfo));
    }

    /**
     * 删除方案对比数据
     */
    @RequiresPermissions("scheme:adinfo:remove")
    @Log(title = "方案对比数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectAdinfoService.deleteTProjectAdinfoByIds(ids));
    }

    /**
     * 导入Excel数据主界面
     */
    @GetMapping("/importScheme/{faid}")
    public String importScheme(@PathVariable("faid") Long faid,ModelMap mmap)
    {

        mmap.put("faid", faid);
        return prefix + "/importScheme";
    }

    /**
     * 导入Excel数据
     */
    @RequiresPermissions("scheme:adinfo:edit")
    @Log(title = "方案对比数据", businessType = BusinessType.INSERT)
    @PostMapping("/importSchemeData")
    @ResponseBody
    public AjaxResult importSchemeData(@RequestParam("file") MultipartFile file, @RequestParam("faid") Long faid) throws IOException {

        return toAjax(tProjectAdinfoService.importExcelData(file,faid));
    }

}
