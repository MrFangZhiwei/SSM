package com.keyone.mapper;

import com.keyone.pojo.Cellbottle;
import com.keyone.pojo.CellbottleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CellbottleMapper {
    int countByExample(CellbottleExample example);

    int deleteByExample(CellbottleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Cellbottle record);

    int insertSelective(Cellbottle record);

    List<Cellbottle> selectByExample(CellbottleExample example);

    Cellbottle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Cellbottle record, @Param("example") CellbottleExample example);

    int updateByExample(@Param("record") Cellbottle record, @Param("example") CellbottleExample example);

    int updateByPrimaryKeySelective(Cellbottle record);

    int updateByPrimaryKey(Cellbottle record);
}