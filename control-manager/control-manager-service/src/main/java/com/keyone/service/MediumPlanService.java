package com.keyone.service;

import java.util.List;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.pojo.MediumPlan;

public interface MediumPlanService
{
	List<MediumPlan> showMediumPlan() throws Exception;
	MediumPlan showMediumDetail(String mediumPlanName)throws Exception;
	KeyoneResult updateMediumDetail(MediumPlan mediumPlan)throws Exception;
	KeyoneResult createmediumplan(MediumPlan mediumPlan)throws Exception;
	KeyoneResult deletemediumplan(String mediumPlanName)throws Exception;
	KeyoneResult dealMediumPlan(String mediumPlanName)throws Exception;
}
