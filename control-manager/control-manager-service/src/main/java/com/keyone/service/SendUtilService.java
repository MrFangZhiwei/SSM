package com.keyone.service;

import com.keyone.common.pojo.MediumPlan;
import com.keyone.common.pojo.TransferPlan;



public interface SendUtilService
{
	void control(String cellcontent)throws Exception;
	void control(MediumPlan mediumPlan)throws Exception;
	void control(TransferPlan transferPlan)throws Exception;
}
