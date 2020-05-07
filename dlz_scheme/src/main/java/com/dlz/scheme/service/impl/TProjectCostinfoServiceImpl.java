package com.dlz.scheme.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.dlz.common.utils.PercentUtils;
import com.dlz.common.utils.poi.ExcelUtil;
import com.dlz.scheme.domain.TProjectAdinfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectCostinfoMapper;
import com.dlz.scheme.domain.TProjectCostinfo;
import com.dlz.scheme.service.ITProjectCostinfoService;
import com.dlz.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 方案成本Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-04-27
 */
@Service
public class TProjectCostinfoServiceImpl implements ITProjectCostinfoService 
{
    @Autowired
    private TProjectCostinfoMapper tProjectCostinfoMapper;

    /**
     * 查询方案成本
     * 
     * @param pciid 方案成本ID
     * @return 方案成本
     */
    @Override
    public TProjectCostinfo selectTProjectCostinfoById(Long pciid)
    {
        return tProjectCostinfoMapper.selectTProjectCostinfoById(pciid);
    }

    /**
     * 查询方案成本列表
     * 
     * @param tProjectCostinfo 方案成本
     * @return 方案成本
     */
    @Override
    public List<TProjectCostinfo> selectTProjectCostinfoList(TProjectCostinfo tProjectCostinfo)
    {
        return tProjectCostinfoMapper.selectTProjectCostinfoList(tProjectCostinfo);
    }

    /**
     * 新增方案成本
     * 
     * @param tProjectCostinfo 方案成本
     * @return 结果
     */
    @Override
    public int insertTProjectCostinfo(TProjectCostinfo tProjectCostinfo)
    {
        return tProjectCostinfoMapper.insertTProjectCostinfo(tProjectCostinfo);
    }

    /**
     * 修改方案成本
     * 
     * @param tProjectCostinfo 方案成本
     * @return 结果
     */
    @Override
    public int updateTProjectCostinfo(TProjectCostinfo tProjectCostinfo)
    {
        return tProjectCostinfoMapper.updateTProjectCostinfo(tProjectCostinfo);
    }

    /**
     * 删除方案成本对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectCostinfoByIds(String ids)
    {
        return tProjectCostinfoMapper.deleteTProjectCostinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案成本信息
     * 
     * @param pciid 方案成本ID
     * @return 结果
     */
    @Override
    public int deleteTProjectCostinfoById(Long pciid)
    {
        return tProjectCostinfoMapper.deleteTProjectCostinfoById(pciid);
    }

    @Override
    public int importExcelData(MultipartFile file, Long faid) throws IOException {

        try {
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            Workbook workbook = null;
            if(filename.endsWith(".xls")){
                workbook = new HSSFWorkbook(inputStream);
            }
            if (filename.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            Row row= null;
            List<TProjectCostinfo> dataList = new ArrayList<>();
            for (int i = 2; i < rows-3; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    TProjectCostinfo tProjectCostinfo = new TProjectCostinfo();
                    tProjectCostinfo.setFaid(faid);
                    tProjectCostinfo.setCostItem(ExcelUtil.getCellValue(row.getCell(3)));
                    tProjectCostinfo.setCostItemCode(ExcelUtil.getCellValue(row.getCell(4)));
                    for (int j = 7; j < 10; j++) {
                        String cellValue = ExcelUtil.getCellValue(row.getCell(j));
                        if (j==7) tProjectCostinfo.setContent(cellValue);
                        if (j==8) tProjectCostinfo.setPrice(cellValue);
                        if (j==9) tProjectCostinfo.setChanges(cellValue);
                    }
                    dataList.add(tProjectCostinfo);
                } else {
                    break;
                }
            }
            return dataList == null? 0 : tProjectCostinfoMapper.batchInsertTProjectCostinfo(dataList);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
