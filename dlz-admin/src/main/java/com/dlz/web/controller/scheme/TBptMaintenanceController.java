package com.dlz.web.controller.scheme;

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

@Controller
@RequestMapping("/scheme/maintenance")
public class TBptMaintenanceController extends BaseController {
	private String prefix = "scheme";
	
    @RequiresPermissions("scheme:maintenance:view")
    @GetMapping()
    public String maintenance()
    {
        return prefix + "/maintenance";
    }
}
