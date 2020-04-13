package com.dlz.web.controller.scheme;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dlz.scheme.domain.TBptComponent;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.dlz.common.annotation.Log;
import com.dlz.common.config.Global;
import com.dlz.common.enums.BusinessType;
import com.dlz.scheme.domain.TBptComponentnode;
import com.dlz.scheme.service.ITBptComponentnodeService;
import com.dlz.web.controller.system.SysProfileController;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.MapDataUtil;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.common.core.page.TableDataInfo;

/**
 * 节点库Controller
 * 
 * @author lizhiyu
 * @date 2019-12-12
 */
@Controller
@RequestMapping("/scheme/componentnode")
public class TBptComponentnodeController extends BaseController
{
    
	private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);
	
	private String prefix = "scheme/componentnode";

    @Autowired
    private ITBptComponentnodeService tBptComponentnodeService;

    @RequiresPermissions("scheme:componentnode:view")
    @GetMapping()
    public String componentnode()
    {
        return prefix + "/componentnode";
    }

    /**
     * 查询节点库列表
     */
    @RequiresPermissions("scheme:componentnode:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBptComponentnode tBptComponentnode)
    {
        startPage();
        List<TBptComponentnode> list = tBptComponentnodeService.selectTBptComponentnodeList(tBptComponentnode);
        return getDataTable(list);
    }

    /**
     * 导出节点库列表
     */
    @RequiresPermissions("scheme:componentnode:export")
    @Log(title = "节点库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBptComponentnode tBptComponentnode)
    {
        List<TBptComponentnode> list = tBptComponentnodeService.selectTBptComponentnodeList(tBptComponentnode);
        ExcelUtil<TBptComponentnode> util = new ExcelUtil<TBptComponentnode>(TBptComponentnode.class);
        return util.exportExcel(list, "componentnode");
    }

    /**
     * 新增节点库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存节点库
     */
    @RequiresPermissions("scheme:componentnode:add")
    @Log(title = "节点库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("conmponentNode-file") MultipartFile file,@RequestParam("formData") String formData)
    {
    	try {
			if (!file.isEmpty()) {
				String path = FileUploadUtils.upload(Global.getComponentNodePath(), file);
				String fileName=file.getOriginalFilename();
				JSONObject formParam=URLStringToJsonUtil.convertJson(formData);
                TBptComponentnode tBptComponentnode = JSONObject.toJavaObject(formParam, TBptComponentnode.class);

				tBptComponentnode.setFileNm(fileName);
				tBptComponentnode.setPath(path);
				if (formParam.containsKey("memo")) {
					tBptComponentnode.setMemo(formParam.getString("memo").toString());
				}
				return toAjax(tBptComponentnodeService.insertTBptComponentnode(tBptComponentnode));
			}
			return error();
		} catch (Exception e) {
			log.error("文件上传失败！", e);
            return error(e.getMessage());
		}
    	
    }

    /**
     * 修改节点库
     */
    @GetMapping("/edit/{cnid}")
    public String edit(@PathVariable("cnid") Long cnid, ModelMap mmap)
    {
        TBptComponentnode tBptComponentnode = tBptComponentnodeService.selectTBptComponentnodeById(cnid);
        mmap.put("tBptComponentnode", tBptComponentnode);
        return prefix + "/edit";
    }

    /**
     * 修改保存节点库
     */
    @RequiresPermissions("scheme:componentnode:edit")
    @Log(title = "节点库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBptComponentnode tBptComponentnode)
    {
        return toAjax(tBptComponentnodeService.updateTBptComponentnode(tBptComponentnode));
    }

    /**
     * 删除节点库
     */
    @RequiresPermissions("scheme:componentnode:remove")
    @Log(title = "节点库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBptComponentnodeService.deleteTBptComponentnodeByIds(ids));
    }

    /**
     * 查询项目未绑定的构件列表
     */
    @RequiresPermissions("scheme:componentnode:list")
    @PostMapping("/unbindlist")
    @ResponseBody
    public TableDataInfo unbindlist(TBptComponentnode tBptComponentnode)
    {
        startPage();
        List<TBptComponent> list = tBptComponentnodeService.selectTBptComponentnodeUnbindList(tBptComponentnode);
        return getDataTable(list);
    }

    /**
     * 通过项目ID查询构件库管理列表
     */
    @RequiresPermissions("scheme:componentnode:list")
    @PostMapping("/listBypjtid")
    @ResponseBody
    public TableDataInfo listBypjtid( TBptComponentnode tBptComponentnode)
    {
        startPage();
        List<TBptComponent> list = tBptComponentnodeService.selectTBptComponentnodeListBypjtid(tBptComponentnode);
        return getDataTable(list);
    }

    /**
     * 取消构件绑定
     */
    @RequiresPermissions("scheme:componentnode:list")
    @PostMapping("/cancel")
    @ResponseBody
    public AjaxResult cancel(String pjtid, String cnid)
    {
        return toAjax(tBptComponentnodeService.cancel(pjtid, cnid));
    }

    /**
     * 构件与项目绑定页面
     */
    @GetMapping("/select/{id}")
    public String select(@PathVariable("id") Long pjtid, ModelMap mmap)
    {
        mmap.put("pjtid",pjtid);
        return "scheme/info"+"/selectComponentNode";
    }

    /**
     * 新增构件到项目中
     */
    @RequiresPermissions("scheme:componentnode:list")
    @Log(title = "构件库管理", businessType = BusinessType.INSERT)
    @PostMapping("/bindAll")
    @ResponseBody
    public AjaxResult bindAll(String pjtid, String cnids)
    {
        return toAjax(tBptComponentnodeService.batchBindComponentNode(pjtid , cnids));
    }
}
