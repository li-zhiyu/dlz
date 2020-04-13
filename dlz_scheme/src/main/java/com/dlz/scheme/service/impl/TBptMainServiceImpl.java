package com.dlz.scheme.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.dlz.common.config.Global;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.DateUtils;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlz.scheme.mapper.TBptDetailMapper;
import com.dlz.scheme.mapper.TBptMainMapper;
import com.dlz.scheme.mapper.TBptParamMapper;
import com.dlz.scheme.domain.TBptMain;
import com.dlz.scheme.service.ITBptMainService;
import com.dlz.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 方案管理Service业务层处理
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
@Service
public class TBptMainServiceImpl implements ITBptMainService 
{
    @Autowired
    private TBptMainMapper tBptMainMapper;
    
    @Autowired
    private TBptDetailMapper tBptDetailMapper;
    
    @Autowired
    private TBptParamMapper tBptParamMapper;

    /**
     * 查询方案管理
     * 
     * @param bptid 方案管理ID
     * @return 方案管理
     */
    @Override
    public TBptMain selectTBptMainById(Long bptid)
    {
        return tBptMainMapper.selectTBptMainById(bptid);
    }

    /**
     * 查询方案管理列表
     * 
     * @param tBptMain 方案管理
     * @return 方案管理
     */
    @Override
    public List<TBptMain> selectTBptMainList(TBptMain tBptMain)
    {
        return tBptMainMapper.selectTBptMainList(tBptMain);
    }

    /**
     * 新增方案管理
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    @Override
    public int insertTBptMain(TBptMain tBptMain)
    {
        tBptMain.setCreateTime(DateUtils.getNowDate());
        return tBptMainMapper.insertTBptMain(tBptMain);
    }
    
    /**
     * 新增方案
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTBptMainAll(MultipartFile file , String formData)
    {
        try {
            if (!file.isEmpty()){
                String path = FileUploadUtils.upload(Global.getProjectPath(), file);
                String fileName=file.getOriginalFilename();
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);

                //表t_bpt_main
                TBptMain tBptMain=new TBptMain();
                tBptMain.setCreateTime(DateUtils.getNowDate());
                tBptMain.setBptNm(formParam.getString("bptNm"));
                tBptMain.setBptId(formParam.getString("bptCode"));
                tBptMain.setCreator(formParam.getString("creator"));
                tBptMain.setPath(path);
                int i = tBptMainMapper.insertTBptMain(tBptMain);
                if (i==0) return AjaxResult.error();

                String bptid = tBptMain.getBptid().toString();//获取主表的主键

                //表t_bpt_detail和表t_bpt_param
                List<Map> detailList=new ArrayList<Map>();
                //List<Map> paramList=new ArrayList<Map>();
                for(String key :formParam.keySet())
                {
                    if(key.startsWith("detail")&&!formParam.get(key).toString().equals(""))
                    {
                        Map<String,Object> newMap=new HashMap<String,Object>();
                        newMap.put("bptid", bptid);
                        newMap.put("detail", key.split("_")[1]);
                        newMap.put("detail_value", formParam.get(key));
                        detailList.add(newMap);

                    }
                    /*if(key.startsWith("para"))
                    {
                        Map<String,Object> newMap=new HashMap<String,Object>();
                        newMap.put("bptid", bptid);
                        newMap.put("param", key.split("_")[1]);
                        newMap.put("param_value", dataMap.get(key));
                        paramList.add(newMap);

                    }*/
                }
                int count = tBptDetailMapper.batchInsert(detailList);
                if (count==0) return AjaxResult.error();
                return AjaxResult.success();
            }
            return AjaxResult.error();
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 修改方案管理
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    @Override
    public int updateTBptMain(TBptMain tBptMain)
    {
        return tBptMainMapper.updateTBptMain(tBptMain);
    }

    /**
     * 删除方案管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptMainByIds(String ids)
    {
        return tBptMainMapper.deleteTBptMainByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案管理信息
     * 
     * @param bptid 方案管理ID
     * @return 结果
     */
    @Override
    public int deleteTBptMainById(Long bptid)
    {
        return tBptMainMapper.deleteTBptMainById(bptid);
    }
}
