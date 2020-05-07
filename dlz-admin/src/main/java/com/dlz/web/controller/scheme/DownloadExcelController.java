package com.dlz.web.controller.scheme;

import com.dlz.common.config.Global;
import com.dlz.common.core.controller.BaseController;
import com.dlz.common.utils.file.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * 项目文件管理Controller
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
@Controller
@RequestMapping("/download/excel")
public class DownloadExcelController extends BaseController
{

    /**
     * 下载Excel模板
     */
    @RequestMapping("/template/{fileId}")
    @ResponseBody
    public void downloadExcelTemplate(HttpServletResponse response,HttpServletRequest request,@PathVariable("fileId") String id)
    {
        try
        {
            //获取要下载的模板名称
            String fileName = "";
            if ("1".equals(id)) fileName = "1543658213654-zpl.xlsx";
            if ("2".equals(id)) fileName = "1543658213655-cb.xlsx";

            //获取要下载的模板路径
            //String filePath = getClass().getResource("/static/excelTemplate/" + fileName).getPath();
            String filePath = Global.getExcelTemplatePath()+"/"+fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, fileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
        }
        catch (Exception e)
        {
            logger.error("下载文件失败", e);
        }
    }

}
