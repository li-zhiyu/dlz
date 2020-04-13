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
import com.dlz.scheme.domain.TBptEscheme;
import com.dlz.scheme.domain.TBptMain;
import com.dlz.scheme.service.ITBptEschemeService;
import com.dlz.scheme.service.ITBptMainService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 装配方案Controller
 * 
 * @author lizhiyu
 * @date 2019-12-10
 */
@Controller
@RequestMapping("/scheme/escheme")
public class TBptEschemeController extends BaseController
{
    private String prefix = "scheme/escheme";

    @Autowired
    private ITBptEschemeService tBptEschemeService;
    
    @Autowired
    private ITBptMainService iTBptMainService;

    @RequiresPermissions("scheme:escheme:view")
    @GetMapping()
    public String escheme()
    {
        return prefix + "/escheme";
    }

    /**
     * 查询装配方案列表
     */
    @RequiresPermissions("scheme:escheme:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptEscheme tBptEscheme)
    {
        startPage();
        List<TBptEscheme> list = tBptEschemeService.selectTBptEschemeList(tBptEscheme);
        return getDataTable(list);
    }

    /**
     * 导出装配方案列表
     */
    @RequiresPermissions("scheme:escheme:export")
    @Log(title = "装配方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptEscheme tBptEscheme)
    {
        List<TBptEscheme> list = tBptEschemeService.selectTBptEschemeList(tBptEscheme);
        ExcelUtil<TBptEscheme> util = new ExcelUtil<TBptEscheme>(TBptEscheme.class);
        return util.exportExcel(list, "escheme");
    }

    /**
     * 新增装配方案
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	List<TBptMain> list = iTBptMainService.selectTBptMainList(null);    	
        mmap.put("shcemeList", list);
        return prefix + "/add";
    }

    /**
     * 新增保存装配方案
     */
    @RequiresPermissions("scheme:escheme:add")
    @Log(title = "装配方案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBptEscheme tBptEscheme)
    {
        return toAjax(tBptEschemeService.insertTBptEscheme(tBptEscheme));
    }

    /**
     * 修改装配方案
     */
    @GetMapping("/edit/{bpeid}")
    public String edit(@PathVariable("bpeid") Long bpeid, ModelMap mmap)
    {
        TBptEscheme tBptEscheme = tBptEschemeService.selectTBptEschemeById(bpeid);
        mmap.put("tBptEscheme", tBptEscheme);
        return prefix + "/edit";
    }

    /**
     * 修改保存装配方案
     */
    @RequiresPermissions("scheme:escheme:edit")
    @Log(title = "装配方案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBptEscheme tBptEscheme)
    {
        return toAjax(tBptEschemeService.updateTBptEscheme(tBptEscheme));
    }

    /**
     * 删除装配方案
     */
    @RequiresPermissions("scheme:escheme:remove")
    @Log(title = "装配方案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptEschemeService.deleteTBptEschemeByIds(ids));
    }
}
