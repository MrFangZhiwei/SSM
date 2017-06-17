package com.keyone.service;

import java.util.List;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.pojo.TransferPlan;

public interface TransferPlanService
{
	List<TransferPlan>  showTranferPlan();
	TransferPlan  showTranferDetail(String transferPlanName) throws Exception;
	KeyoneResult updateTransfertail(TransferPlan transferPlan) throws Exception;
	KeyoneResult createtransferplan(TransferPlan transferPlan) throws Exception;
	KeyoneResult deletetransferplan(String transferPlanName) throws Exception;
	KeyoneResult dealTransferPlan(String transferPlanName) throws Exception;
}
