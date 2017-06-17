package com.keyone.mapper;

import com.keyone.pojo.Cellrecord;
import com.keyone.pojo.CellrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CellrecordMapper {
    int countByExample(CellrecordExample example);

    int deleteByExample(CellrecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(Cellrecord record);

    int insertSelective(Cellrecord record);

    List<Cellrecord> selectByExample(CellrecordExample example);

    Cellrecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Cellrecord record, @Param("example") CellrecordExample example);

    int updateByExample(@Param("record") Cellrecord record, @Param("example") CellrecordExample example);

    int updateByPrimaryKeySelective(Cellrecord record);

    int updateByPrimaryKey(Cellrecord record);
}