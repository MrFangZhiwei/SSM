package com.keyone.mapper;

import com.keyone.pojo.Cellframe;
import com.keyone.pojo.CellframeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CellframeMapper {
    int countByExample(CellframeExample example);

    int deleteByExample(CellframeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Cellframe record);

    int insertSelective(Cellframe record);

    List<Cellframe> selectByExample(CellframeExample example);

    Cellframe selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Cellframe record, @Param("example") CellframeExample example);

    int updateByExample(@Param("record") Cellframe record, @Param("example") CellframeExample example);

    int updateByPrimaryKeySelective(Cellframe record);

    int updateByPrimaryKey(Cellframe record);
}