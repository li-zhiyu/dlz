package com.dlz.web.controller.scheme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dlz.common.annotation.Log;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TBptDetail;
import com.dlz.scheme.domain.TBptParam;
import com.dlz.scheme.service.ITBptParamService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 方案参数Controller
 * 
 * @author lizhiyu
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/scheme/param")
public class TBptParamController extends BaseController
{
    private String prefix = "scheme/param";

    @Autowired
    private ITBptParamService tBptParamService;

    @RequiresPermissions("scheme:param:view")
    @GetMapping()
    public String param()
    {
        return prefix + "/param";
    }

    /**
     * 查询方案参数列表
     */
    @RequiresPermissions("scheme:param:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptParam tBptParam)
    {
        startPage();
        List<TBptParam> list = tBptParamService.selectTBptParamList(tBptParam);
        return getDataTable(list);
    }

    /**
     * 导出方案参数列表
     */
    @RequiresPermissions("scheme:param:export")
    @Log(title = "方案参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptParam tBptParam)
    {
        List<TBptParam> list = tBptParamService.selectTBptParamList(tBptParam);
        ExcelUtil<TBptParam> util = new ExcelUtil<TBptParam>(TBptParam.class);
        return util.exportExcel(list, "param");
    }

    /**
     * 新增方案参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存方案参数
     */
    @RequiresPermissions("scheme:param:add")
    @Log(title = "方案参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBptParam tBptParam)
    {
        return toAjax(tBptParamService.insertTBptParam(tBptParam));
    }

    /**
     * 修改方案参数
     */
    @GetMapping("/edit/{bptid}")
    public String edit(@PathVariable("bptid") Long bptid, ModelMap mmap)
    {
    	TBptParam tBptParam=new TBptParam();
    	tBptParam.setBptid(Long.toString(bptid));
    	List<TBptParam> list = tBptParamService.selectTBptParamList(tBptParam);
    	Map<String,Object> map =new HashMap<String,Object>();
    	for (TBptParam tBptParam2 : list) {
			map.put(tBptParam2.getParam(), tBptParam2.getPrmValue());
		}
        mmap.put("tBptParam", map);
        return prefix + "/edit";
    }

    /**
     * 修改保存方案参数
     */
    @RequiresPermissions("scheme:param:edit")
    @Log(title = "方案参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam Map<String,Object> dataMap)
    {
        return toAjax(tBptParamService.batchUpdate(dataMap));
    }

    /**
     * 删除方案参数
     */
    @RequiresPermissions("scheme:param:remove")
    @Log(title = "方案参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptParamService.deleteTBptParamByIds(ids));
    }
}
