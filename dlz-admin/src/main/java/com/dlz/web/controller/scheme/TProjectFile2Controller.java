package com.dlz.web.controller.scheme;

import com.dlz.common.annotation.Log;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.core.page.TableDataInfo;
import com.dlz.common.enums.BusinessType;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.scheme.domain.TProjectFile;
import com.dlz.scheme.domain.TProjectFile2;
import com.dlz.scheme.service.ITProjectFile2Service;
import com.dlz.scheme.service.ITProjectInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 项目文件2管理Controller
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
@Controller
@RequestMapping("/scheme/file2")
public class TProjectFile2Controller extends BaseController
{
    private String prefix = "scheme/file2";

    @Autowired
    private ITProjectFile2Service tProjectFile2Service;

    @Autowired
    private ITProjectInfoService tProjectInfoService;



    /**
     * 查询项目文件管理列表
     */
    @RequiresPermissions("scheme:file2:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectFile2 tProjectFile2)
    {
        startPage();
        List<TProjectFile2> list = tProjectFile2Service.selectTProjectFileList(tProjectFile2);
        return getDataTable(list);
    }

    /**
     * 导出项目文件管理列表
     */
    @RequiresPermissions("scheme:file2:export")
    @Log(title = "项目文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectFile2 tProjectFile2)
    {
        List<TProjectFile2> list = tProjectFile2Service.selectTProjectFileList(tProjectFile2);
        ExcelUtil<TProjectFile2> util = new ExcelUtil<TProjectFile2>(TProjectFile2.class);
        return util.exportExcel(list, "file2");
    }

    /**
     * 上传文件
     */
    @RequiresPermissions("scheme:file2:add")
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("selectProject",tProjectInfoService.selectTProjectInfoById(id));
        return prefix + "/add";
    }

    /**
     * 上传文件
     */
    @RequiresPermissions("scheme:file2:add")
    @Log(title = "项目文件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("project-file2") MultipartFile file, @RequestParam("formData") String formData)
    {
        return tProjectFile2Service.insertTProjectFile(file,formData);
    }



    /**
     * 修改项目文件管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectFile2 tProjectFile2 = tProjectFile2Service.selectTProjectFileById(id);
        mmap.put("tProjectFile", tProjectFile2);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目文件管理
     */
    @RequiresPermissions("scheme:file2:edit")
    @Log(title = "项目文件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectFile2 tProjectFile2)
    {
        return toAjax(tProjectFile2Service.updateTProjectFile(tProjectFile2));
    }

    /**
     * 删除项目文件管理
     */
    @RequiresPermissions("scheme:file2:remove")
    @Log(title = "项目文件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectFile2Service.deleteTProjectFileByIds(ids));
    }

    /**
     *
     * 项目信息查询
     * @return
     */
    @RequiresPermissions("scheme:file2:view")
    @GetMapping("/detail/{id}")
    public String fileDetail(@PathVariable("id") String id,ModelMap mmap)
    {
        mmap.put("selectProject",tProjectInfoService.selectTProjectInfoById(id));
        mmap.put("ProjectList",tProjectInfoService.selectTProjectInfoList(null));
        return prefix + "/file2";
    }
}
