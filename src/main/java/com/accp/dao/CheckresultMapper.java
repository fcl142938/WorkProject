package com.accp.dao;

import com.accp.pojo.Checkresult;

public interface CheckresultMapper {
    int deleteByPrimaryKey(Integer resultid);

    int insert(Checkresult record);

    int insertSelective(Checkresult record);

    Checkresult selectByPrimaryKey(Integer resultid);

    int updateByPrimaryKeySelective(Checkresult record);

    int updateByPrimaryKey(Checkresult record);
}