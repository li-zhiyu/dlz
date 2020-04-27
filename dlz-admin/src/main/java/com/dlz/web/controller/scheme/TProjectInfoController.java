package com.dlz.web.controller.scheme;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.dlz.common.config.Global;
import com.dlz.common.core.domain.Ztree;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import com.dlz.system.domain.SysDept;
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
import com.dlz.scheme.domain.TProjectInfo;
import com.dlz.scheme.service.ITProjectInfoService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【项目信息】Controller
 * 
 * @author lizhiyu
 * @date 2020-03-23
 */
@Controller
@RequestMapping("/scheme/info")
public class TProjectInfoController extends BaseController
{
    private String prefix = "scheme/info";
    private static final Logger log = LoggerFactory.getLogger(TProjectInfoController.class);

    @Autowired
    private ITProjectInfoService tProjectInfoService;

    @RequiresPermissions("scheme:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询【项目信息】列表
     */
    @RequiresPermissions("scheme:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectInfo tProjectInfo)
    {
        startPage();
        List<TProjectInfo> list = tProjectInfoService.selectTProjectInfoList(tProjectInfo);
        return getDataTable(list);
    }

    /**
     * 导出【项目信息】列表
     */
    @RequiresPermissions("scheme:info:export")
    @Log(title = "【项目信息】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectInfo tProjectInfo)
    {
        List<TProjectInfo> list = tProjectInfoService.selectTProjectInfoList(tProjectInfo);
        ExcelUtil<TProjectInfo> util = new ExcelUtil<TProjectInfo>(TProjectInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增【项目信息】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 绑定构件
     */
    @GetMapping("/bindingComponent/{pjtid}")
    public String bindingComponent(@PathVariable("pjtid") String pjtid ,ModelMap mmap)
    {
        mmap.put("pjtid",pjtid);
        return prefix + "/bindingComponent";
    }

    /**
     * 绑定节点
     */
    @GetMapping("/bindingComponentNode/{pjtid}")
    public String bindingComponentNode(@PathVariable("pjtid") String pjtid ,ModelMap mmap)
    {
        mmap.put("pjtid",pjtid);
        return prefix + "/bindingComponentNode";
    }

    /**
     * 修改图片
     */
    @GetMapping("/updateImage/{pjtid}")
    public String updateImage(@PathVariable("pjtid") String pjtid ,ModelMap mmap)
    {
        TProjectInfo tProjectInfo = tProjectInfoService.selectTProjectInfoById(pjtid);
        mmap.put("tProjectInfo", tProjectInfo);
        return prefix + "/updateImage";
    }

    /**
     * 修改图片
     */
    @RequiresPermissions("scheme:info:edit")
    @PostMapping("/updateImage/{pjtid}")
    @ResponseBody
    public AjaxResult updateImage(@RequestParam("file") MultipartFile file,@PathVariable("pjtid") String pjtid)
    {
        try {
            if (!file.isEmpty()){
                String path = FileUploadUtils.upload(Global.getProjectPath(), file);
                TProjectInfo tProjectInfo = new TProjectInfo();
                tProjectInfo.setPjtid(pjtid);
                tProjectInfo.setPath(path);
                return toAjax(tProjectInfoService.updateTProjectInfo(tProjectInfo));
            }
            log.error("文件上传失败！");
            return error();

        } catch (Exception e) {
            log.error("文件上传失败！", e);
            return error(e.getMessage());
        }
    }

    /**
     * 新增保存【项目信息】
     */
    @RequiresPermissions("scheme:info:add")
    @Log(title = "【项目信息】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("project-view-file") MultipartFile file, @RequestParam("formData") String formData)
    {
        try {
            if (!file.isEmpty()){
                String path = FileUploadUtils.upload(Global.getProjectPath(), file);
                String fileName=file.getOriginalFilename();
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);
                TProjectInfo tProjectInfo = JSONObject.toJavaObject(formParam, TProjectInfo.class);
                tProjectInfo.setPath(path);
                return toAjax(tProjectInfoService.insertTProjectInfo(tProjectInfo));
            }
            log.error("文件上传失败！");
            return error();

        } catch (Exception e) {
            log.error("文件上传失败！", e);
            return error(e.getMessage());
        }

    }

    /**
     * 修改【项目信息】
     */
    @GetMapping("/edit/{pjtid}")
    public String edit(@PathVariable("pjtid") String pjtid, ModelMap mmap)
    {
        TProjectInfo tProjectInfo = tProjectInfoService.selectTProjectInfoById(pjtid);
        mmap.put("tProjectInfo", tProjectInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存【项目信息】
     */
    @RequiresPermissions("scheme:info:edit")
    @Log(title = "【项目信息】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectInfo tProjectInfo)
    {
        return toAjax(tProjectInfoService.updateTProjectInfo(tProjectInfo));
    }

    /**
     * 删除【项目信息】
     */
    @RequiresPermissions("scheme:info:remove")
    @Log(title = "【项目信息】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectInfoService.deleteTProjectInfoByIds(ids));
    }

    /**
     * 加载项目列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = tProjectInfoService.selectProjectTree();
        return ztrees;
    }

    /**
     * 加载项目选择列表树
     */
    @GetMapping("/projectSelectTree")
    public String projectSelectTree()
    {
        return prefix+"/projectSelectTree";
    }
}
