package com.keyone.mapper;

import com.keyone.pojo.Emptyframe;
import com.keyone.pojo.EmptyframeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmptyframeMapper {
    int countByExample(EmptyframeExample example);

    int deleteByExample(EmptyframeExample example);

    int insert(Emptyframe record);

    int insertSelective(Emptyframe record);

    List<Emptyframe> selectByExample(EmptyframeExample example);

    int updateByExampleSelective(@Param("record") Emptyframe record, @Param("example") EmptyframeExample example);

    int updateByExample(@Param("record") Emptyframe record, @Param("example") EmptyframeExample example);
}