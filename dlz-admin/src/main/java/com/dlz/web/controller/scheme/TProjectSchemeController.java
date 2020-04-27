package com.dlz.web.controller.scheme;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dlz.common.annotation.Log;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TProjectScheme;
import com.dlz.scheme.service.ITProjectSchemeService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 方案管理Controller
 * 
 * @author lizhiyu
 * @date 2020-04-16
 */
@Controller
@RequestMapping("/scheme/scheme")
public class TProjectSchemeController extends BaseController
{
    private String prefix = "scheme/scheme";

    @Autowired
    private ITProjectSchemeService tProjectSchemeService;

    @RequiresPermissions("scheme:scheme:view")
    @GetMapping()
    public String scheme()
    {
        return prefix + "/scheme";
    }

    /**
     * 查询方案管理列表
     */
    @RequiresPermissions("scheme:scheme:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectScheme tProjectScheme)
    {
        startPage();
        List<TProjectScheme> list = tProjectSchemeService.selectTProjectSchemeList(tProjectScheme);
        return getDataTable(list);
    }

    /**
     * 导出方案管理列表
     */
    @RequiresPermissions("scheme:scheme:export")
    @Log(title = "方案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectScheme tProjectScheme)
    {
        List<TProjectScheme> list = tProjectSchemeService.selectTProjectSchemeList(tProjectScheme);
        ExcelUtil<TProjectScheme> util = new ExcelUtil<TProjectScheme>(TProjectScheme.class);
        return util.exportExcel(list, "scheme");
    }

    /**
     * 新增方案管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存方案管理
     */
    @RequiresPermissions("scheme:scheme:add")
    @Log(title = "方案管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectScheme tProjectScheme)
    {
        return toAjax(tProjectSchemeService.insertTProjectScheme(tProjectScheme));
    }

    /**
     * 修改方案管理
     */
    @GetMapping("/edit/{faid}")
    public String edit(@PathVariable("faid") Long faid, ModelMap mmap)
    {
        TProjectScheme tProjectScheme = tProjectSchemeService.selectTProjectSchemeById(faid);
        mmap.put("tProjectScheme", tProjectScheme);
        return prefix + "/edit";
    }

    /**
     * 修改保存方案管理
     */
    @RequiresPermissions("scheme:scheme:edit")
    @Log(title = "方案管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectScheme tProjectScheme)
    {
        return toAjax(tProjectSchemeService.updateTProjectScheme(tProjectScheme));
    }

    /**
     * 删除方案管理
     */
    @RequiresPermissions("scheme:scheme:remove")
    @Log(title = "方案管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectSchemeService.deleteTProjectSchemeByIds(ids));
    }
}
