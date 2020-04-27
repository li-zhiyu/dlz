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
import com.dlz.scheme.domain.TProjectCostinfo;
import com.dlz.scheme.service.ITProjectCostinfoService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 方案成本Controller
 * 
 * @author lizhiyu
 * @date 2020-04-27
 */
@Controller
@RequestMapping("/scheme/costinfo")
public class TProjectCostinfoController extends BaseController
{
    private String prefix = "scheme/costinfo";

    @Autowired
    private ITProjectCostinfoService tProjectCostinfoService;

    @RequiresPermissions("scheme:costinfo:view")
    @GetMapping()
    public String costinfo()
    {
        return prefix + "/costinfo";
    }

    /**
     * 查询方案成本列表
     */
    @RequiresPermissions("scheme:costinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectCostinfo tProjectCostinfo)
    {
        startPage();
        List<TProjectCostinfo> list = tProjectCostinfoService.selectTProjectCostinfoList(tProjectCostinfo);
        return getDataTable(list);
    }

    /**
     * 导出方案成本列表
     */
    @RequiresPermissions("scheme:costinfo:export")
    @Log(title = "方案成本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectCostinfo tProjectCostinfo)
    {
        List<TProjectCostinfo> list = tProjectCostinfoService.selectTProjectCostinfoList(tProjectCostinfo);
        ExcelUtil<TProjectCostinfo> util = new ExcelUtil<TProjectCostinfo>(TProjectCostinfo.class);
        return util.exportExcel(list, "costinfo");
    }

    /**
     * 新增方案成本
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存方案成本
     */
    @RequiresPermissions("scheme:costinfo:add")
    @Log(title = "方案成本", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectCostinfo tProjectCostinfo)
    {
        return toAjax(tProjectCostinfoService.insertTProjectCostinfo(tProjectCostinfo));
    }

    /**
     * 修改方案成本
     */
    @GetMapping("/edit/{pciid}")
    public String edit(@PathVariable("pciid") Long pciid, ModelMap mmap)
    {
        TProjectCostinfo tProjectCostinfo = tProjectCostinfoService.selectTProjectCostinfoById(pciid);
        mmap.put("tProjectCostinfo", tProjectCostinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存方案成本
     */
    @RequiresPermissions("scheme:costinfo:edit")
    @Log(title = "方案成本", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectCostinfo tProjectCostinfo)
    {
        return toAjax(tProjectCostinfoService.updateTProjectCostinfo(tProjectCostinfo));
    }

    /**
     * 删除方案成本
     */
    @RequiresPermissions("scheme:costinfo:remove")
    @Log(title = "方案成本", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectCostinfoService.deleteTProjectCostinfoByIds(ids));
    }
}
