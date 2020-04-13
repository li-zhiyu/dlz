package com.dlz.scheme.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dlz.common.utils.PercentUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectAdinfoMapper;
import com.dlz.scheme.domain.TProjectAdinfo;
import com.dlz.scheme.service.ITProjectAdinfoService;
import com.dlz.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 方案对比数据Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-04-03
 */
@Service
public class TProjectAdinfoServiceImpl implements ITProjectAdinfoService 
{
    @Autowired
    private TProjectAdinfoMapper tProjectAdinfoMapper;

    /**
     * 查询方案对比数据
     * 
     * @param padid 方案对比数据ID
     * @return 方案对比数据
     */
    @Override
    public TProjectAdinfo selectTProjectAdinfoById(Long padid)
    {
        return tProjectAdinfoMapper.selectTProjectAdinfoById(padid);
    }

    /**
     * 查询方案对比数据列表
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 方案对比数据
     */
    @Override
    public List<TProjectAdinfo> selectTProjectAdinfoList(TProjectAdinfo tProjectAdinfo)
    {
        return tProjectAdinfoMapper.selectTProjectAdinfoList(tProjectAdinfo);
    }

    /**
     * 新增方案对比数据
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 结果
     */
    @Override
    public int insertTProjectAdinfo(TProjectAdinfo tProjectAdinfo)
    {
        return tProjectAdinfoMapper.insertTProjectAdinfo(tProjectAdinfo);
    }

    /**
     * 修改方案对比数据
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 结果
     */
    @Override
    public int updateTProjectAdinfo(TProjectAdinfo tProjectAdinfo)
    {
        return tProjectAdinfoMapper.updateTProjectAdinfo(tProjectAdinfo);
    }

    /**
     * 删除方案对比数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectAdinfoByIds(String ids)
    {
        return tProjectAdinfoMapper.deleteTProjectAdinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案对比数据信息
     * 
     * @param padid 方案对比数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectAdinfoById(Long padid)
    {
        return tProjectAdinfoMapper.deleteTProjectAdinfoById(padid);
    }

    @Override
    public int importExcelData(MultipartFile file, Long pjtid) throws IOException {

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
            String id = UUID.randomUUID().toString().substring(0, 5);
            List<TProjectAdinfo> dataList = new ArrayList<>();
            for (int i = 5; i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    TProjectAdinfo tProjectAdinfo = new TProjectAdinfo();
                    tProjectAdinfo.setPjtid(pjtid);
                    tProjectAdinfo.setZbxm(row.getCell(2).getStringCellValue());
                    for (int j = 6; j < 9; j++) {
                        Cell cell = row.getCell(j);
                        CellType cellType = cell.getCellTypeEnum();
                        String cellValue = "";
                        if (cellType==CellType.NUMERIC||cellType==CellType.FORMULA)
                        {
                            cellValue = String.valueOf(cell.getNumericCellValue());
                        }else {
                            cellValue = cell.getStringCellValue();
                        }
                        if (j==6) tProjectAdinfo.setZb(cellValue.equals("") ? "" :PercentUtils.getPercentFormat(Double.valueOf(cellValue),2,1));
                        if (j==7) tProjectAdinfo.setDf(cellValue);
                        if (j==8) tProjectAdinfo.setBz(cellValue);
                    }
                    dataList.add(tProjectAdinfo);
                } else {
                    break;
                }
            }
            return dataList == null? 0 : tProjectAdinfoMapper.batchInsertTProjectAdinfo(dataList);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
