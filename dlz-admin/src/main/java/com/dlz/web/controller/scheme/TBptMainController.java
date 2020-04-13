package com.dlz.web.controller.scheme;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dlz.scheme.domain.TBptDetail;
import com.dlz.scheme.service.ITBptDetailService;
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
import com.dlz.scheme.domain.TBptMain;
import com.dlz.scheme.service.ITBptMainService;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 方案管理Controller
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/scheme/main")
public class TBptMainController extends BaseController
{
    private String prefix = "scheme/main";

    @Autowired
    private ITBptMainService tBptMainService;

    @Autowired
    private ITBptDetailService itBptDetailService;

    @RequiresPermissions("scheme:main:view")
    @GetMapping()
    public String main()
    {
        return prefix + "/main1";
    }

    /**
     * 查询方案管理列表
     */
    @RequiresPermissions("scheme:main:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptMain tBptMain)
    {
        startPage();
        List<TBptMain> list = tBptMainService.selectTBptMainList(tBptMain);
        return getDataTable(list);
    }

    /**
     * 导出方案管理列表
     */
    @RequiresPermissions("scheme:main:export")
    @Log(title = "方案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptMain tBptMain)
    {
        List<TBptMain> list = tBptMainService.selectTBptMainList(tBptMain);
        ExcelUtil<TBptMain> util = new ExcelUtil<TBptMain>(TBptMain.class);
        return util.exportExcel(list, "main");
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
    @RequiresPermissions("scheme:main:add")
    @Log(title = "方案管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBptMain tBptMain)
    {
        return toAjax(tBptMainService.insertTBptMain(tBptMain));
    }
    
    /**
     * 新增保存方案
     */
    @RequiresPermissions("scheme:main:add")
    @Log(title = "方案管理", businessType = BusinessType.INSERT)
    @PostMapping("/addAll")
    @ResponseBody
    public AjaxResult addSaveAll(@RequestParam("model-file") MultipartFile file, @RequestParam("formData") String formData)//@RequestParam Map<String,Object> dataMap
    {
        return tBptMainService.insertTBptMainAll(file,formData);
    }

    /**
     * 修改方案管理
     */
    @GetMapping("/edit/{bptid}")
    public String edit(@PathVariable("bptid") Long bptid, ModelMap mmap)
    {
        TBptMain tBptMain = tBptMainService.selectTBptMainById(bptid);
        mmap.put("tBptMain", tBptMain);
        return prefix + "/edit";
    }

    /**
     * 修改保存方案管理
     */
    @RequiresPermissions("scheme:main:edit")
    @Log(title = "方案管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBptMain tBptMain)
    {
        return toAjax(tBptMainService.updateTBptMain(tBptMain));
    }

    /**
     * 删除方案管理
     */
    @RequiresPermissions("scheme:main:remove")
    @Log(title = "方案管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptMainService.deleteTBptMainByIds(ids));
    }

    /**
     * 积分管理
     */
    @GetMapping("/points/{bptid}")
    public String point(@PathVariable("bptid") Long bptid, ModelMap mmap)
    {
        TBptMain tBptMain = tBptMainService.selectTBptMainById(bptid);
        TBptDetail tBptDetail=new TBptDetail();
        tBptDetail.setBptid(Long.toString(bptid));
        List<TBptDetail> tBptDetails = itBptDetailService.selectTBptDetailList(tBptDetail);
        List<TBptDetail> collect = tBptDetails.stream().filter(tBptDetail1 -> "单层建筑面积".equals(tBptDetail1.getDetail())).collect(Collectors.toList());
        String eara="";
        if (collect.size() == 1){
            eara = collect.get(0).getDetailValue();
        }
        mmap.put("eara",eara);
        mmap.put("tBptMain", tBptMain);
        return prefix + "/points";
    }
    /**
     * 保存积分
     */
    //@RequiresPermissions("scheme:main:edit")
    @Log(title = "积分管理", businessType = BusinessType.INSERT)
    @PostMapping("/point/add")
    @ResponseBody
    public AjaxResult addPointSave(TBptMain tBptMain)
    {
        return toAjax(tBptMainService.updateTBptMain(tBptMain));
    }
}
