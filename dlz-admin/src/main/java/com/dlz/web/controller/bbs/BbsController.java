package com.dlz.web.controller.bbs;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dlz.common.core.controller.BaseController;


@Controller
@RequestMapping("/bbs")
public class BbsController extends BaseController {
	
private String prefix = "html";
	
    //@RequiresPermissions("html:bbs:view")
    @GetMapping()
    public String bbsIndex()
    {
        return prefix+"/index";
    }
    
    @GetMapping("/html/jie")
    public String jasny()
    {
        return prefix + "/jie/add";
    }
}
