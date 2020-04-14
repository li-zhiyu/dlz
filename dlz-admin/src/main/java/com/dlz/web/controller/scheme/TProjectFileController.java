package com.dlz.web.controller.scheme;

import java.util.List;

import com.bimface.exception.BimfaceException;
import com.dlz.scheme.bimface.BimfaceComponent;
import com.dlz.scheme.service.ITProjectInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.dlz.common.annotation.Log;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TProjectFile;
import com.dlz.scheme.service.ITProjectFileService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目文件管理Controller
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
@Controller
@RequestMapping("/scheme/file")
public class TProjectFileController extends BaseController
{
    private String prefix = "scheme/file";

    @Autowired
    private ITProjectFileService tProjectFileService;

    @Autowired
    private ITProjectInfoService tProjectInfoService;

    @Autowired
    private BimfaceComponent bimfaceComponent;


    /**
     * 查询项目文件管理列表
     */
    @RequiresPermissions("scheme:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectFile tProjectFile)
    {
        startPage();
        List<TProjectFile> list = tProjectFileService.selectTProjectFileList(tProjectFile);
        return getDataTable(list);
    }

    /**
     * 导出项目文件管理列表
     */
    @RequiresPermissions("scheme:file:export")
    @Log(title = "项目文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectFile tProjectFile)
    {
        List<TProjectFile> list = tProjectFileService.selectTProjectFileList(tProjectFile);
        ExcelUtil<TProjectFile> util = new ExcelUtil<TProjectFile>(TProjectFile.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 上传文件到云存储
     */
    @RequiresPermissions("scheme:file:add")
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("selectProject",tProjectInfoService.selectTProjectInfoById(id));
        return prefix + "/add";
    }

    /**
     * 上传文件到云存储
     */
    @RequiresPermissions("scheme:file:add")
    @Log(title = "项目文件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("project-file") MultipartFile file, @RequestParam("formData") String formData)
    {
        return tProjectFileService.insertTProjectFile(file,formData);
    }

    /**
     * 文件转换
     */
    @RequiresPermissions("scheme:file:edit")
    @Log(title = "项目文件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/convert/{id}/{fileId}")
    @ResponseBody
    public AjaxResult convert(@PathVariable("id") String id,@PathVariable("fileId") String fileId) throws BimfaceException {
        return toAjax(tProjectFileService.updateTProjectFileAfterConvert(Long.valueOf(id),Long.valueOf(fileId)));
    }

    /**
     * 文件预览
     */
    @GetMapping("/preview/{fileType}/{fileId}")
    public String preview(@PathVariable("fileType") String fileType,@PathVariable("fileId") String fileId,ModelMap mmap) throws BimfaceException {

        String viewtoken = bimfaceComponent.getViewtoken(Long.valueOf(fileId));
        mmap.put("viewtoken", viewtoken);
        mmap.put("fileType", fileType);
        return prefix + "/preview";
    }

    /**
     * 修改项目文件管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectFile tProjectFile = tProjectFileService.selectTProjectFileById(id);
        mmap.put("tProjectFile", tProjectFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目文件管理
     */
    @RequiresPermissions("scheme:file:edit")
    @Log(title = "项目文件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectFile tProjectFile)
    {
        return toAjax(tProjectFileService.updateTProjectFile(tProjectFile));
    }

    /**
     * 删除项目文件管理
     */
    @RequiresPermissions("scheme:file:remove")
    @Log(title = "项目文件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectFileService.deleteTProjectFileByIds(ids));
    }

    /**
     *
     * 项目信息查询
     * @return
     */
    @RequiresPermissions("scheme:file:view")
    @GetMapping("/detail/{id}")
    public String fileDetail(@PathVariable("id") String id,ModelMap mmap)
    {
        mmap.put("selectProject",tProjectInfoService.selectTProjectInfoById(id));
        mmap.put("ProjectList",tProjectInfoService.selectTProjectInfoList(null));
        return prefix + "/file";
    }
}
