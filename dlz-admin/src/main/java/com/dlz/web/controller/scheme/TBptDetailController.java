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
import com.dlz.scheme.service.ITBptDetailService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 方案明细Controller
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/scheme/detail")
public class TBptDetailController extends BaseController
{
    private String prefix = "scheme/detail";

    @Autowired
    private ITBptDetailService tBptDetailService;

    @RequiresPermissions("scheme:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/detail";
    }

    /**
     * 查询方案明细列表
     */
    @RequiresPermissions("scheme:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptDetail tBptDetail)
    {
        startPage();
        List<TBptDetail> list = tBptDetailService.selectTBptDetailList(tBptDetail);
        return getDataTable(list);
    }

    /**
     * 导出方案明细列表
     */
    @RequiresPermissions("scheme:detail:export")
    @Log(title = "方案明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptDetail tBptDetail)
    {
        List<TBptDetail> list = tBptDetailService.selectTBptDetailList(tBptDetail);
        ExcelUtil<TBptDetail> util = new ExcelUtil<TBptDetail>(TBptDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增方案明细
     */
    @GetMapping("/add/{bptid}")
    public String add(@PathVariable("bptid") Long bptid, ModelMap mmap)
    {
    	mmap.put("bptid", bptid);
    	return prefix + "/add";
    }

    /**
     * 新增保存方案明细
     */
    @RequiresPermissions("scheme:detail:add")
    @Log(title = "方案明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam Map<String,Object> dataMap)
    {
        return toAjax(tBptDetailService.batchInsert(dataMap));
    }

    /**
     * 修改方案明细
     */
    @GetMapping("/edit/{bptid}")
    public String edit(@PathVariable("bptid") Long bptid, ModelMap mmap)
    {
    	TBptDetail tBptDetail=new TBptDetail();
    	tBptDetail.setBptid(Long.toString(bptid));
    	Map<String,Object> map =new HashMap<String,Object>();
    	List<TBptDetail> list = tBptDetailService.selectTBptDetailList(tBptDetail);
    	for (TBptDetail tBptDetail2 : list) {
			map.put(tBptDetail2.getDetail(), tBptDetail2.getDetailValue());
		}
        mmap.put("detailMap", map);
        return prefix + "/edit";
    }

    /**
     * 修改保存方案明细
     */
    @RequiresPermissions("scheme:detail:edit")
    @Log(title = "方案明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam Map<String,Object> dataMap)
    {
        return toAjax(tBptDetailService.batchUpdate(dataMap));
    }

    /**
     * 删除方案明细
     */
    @RequiresPermissions("scheme:detail:remove")
    @Log(title = "方案明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptDetailService.deleteTBptDetailByIds(ids));
    }
}
