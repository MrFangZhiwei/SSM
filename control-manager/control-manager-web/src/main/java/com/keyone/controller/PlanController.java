package com.keyone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.pojo.MediumPlan;
import com.keyone.common.pojo.TransferPlan;
import com.keyone.dao.JedisClient;
import com.keyone.service.MediumPlanService;
import com.keyone.service.TransferPlanService;

/**
 * 方案的控制类
 * <p>Title: MediumPlanController</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-18上午9:52:18
 * @version  1.0
 */
@Controller
public class PlanController
{
	@Autowired
	private MediumPlanService mediumPlanService;
	@Autowired
	private TransferPlanService transferPlanService;

	@Autowired
	private JedisClient jedisClient;
	private static String mode;

	@RequestMapping("/plan")
	public String showMediumPlan(Model model, HttpServletRequest request) throws Exception
	{
		mode = jedisClient.get("MODE");
		//获取模式数字
		List<MediumPlan> result = mediumPlanService.showMediumPlan();
		model.addAttribute("mlist", result);
		List<TransferPlan> result1 = transferPlanService.showTranferPlan();
		model.addAttribute("tlist", result1);
		model.addAttribute("mode", mode);
		return "ParameterSet";
	}

	@RequestMapping("/plan/mediumdetail")
	@ResponseBody
	public MediumPlan showMediumDetail(String mediumPlanName) throws Exception
	{
		MediumPlan result = mediumPlanService.showMediumDetail(mediumPlanName);
		return result;
	}

	//修改的数据接收
	@RequestMapping("/plan/updatemediumdetail")
	@ResponseBody
	public KeyoneResult updateMediumDetail(MediumPlan mediumPlan) throws Exception
	{
		KeyoneResult result = mediumPlanService.updateMediumDetail(mediumPlan);
		return result;
	}

	//增加换液方案
	@RequestMapping("/plan/createmediumplan")
	@ResponseBody
	public KeyoneResult createmediumplan(MediumPlan mediumPlan) throws Exception
	{
		KeyoneResult result = mediumPlanService.createmediumplan(mediumPlan);
		return result;
	}

	//删除换液方案
	@RequestMapping("/plan/deletemediumplan")
	@ResponseBody
	public KeyoneResult deletemediumplan(String mediumPlanName) throws Exception
	{
		KeyoneResult result = mediumPlanService.deletemediumplan(mediumPlanName);
		return result;
	}

	//换液方案提交
	@RequestMapping("/plan/dealMediumPlan")
	@ResponseBody
	public KeyoneResult dealMediumPlan(String mediumPlanName) throws Exception
	{
		if (mediumPlanName == null)
		{
			mediumPlanName = jedisClient.get("PLANNAME");
		}
		//将方案名字设置到redis中
		jedisClient.set("PLANNAME", mediumPlanName);
		mediumPlanService.dealMediumPlan(mediumPlanName);
		//如果客户端关闭响应
		Thread.sleep(1000);
		if (jedisClient.get("TIPS") != null)
		{
			return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		return KeyoneResult.ok();
		//把模式要传给watch页面
		//model.addAttribute("redirect", mode);
		//return "watch";
	}

	//传代参数显示
	@RequestMapping("/plan/transferdetail")
	@ResponseBody
	public TransferPlan showTranferPlan(String transferPlanName, Model model) throws Exception
	{
		TransferPlan result = transferPlanService.showTranferDetail(transferPlanName);
		return result;
	}

	//修改的数据接收
	@RequestMapping("/plan/updatetransferdetail")
	@ResponseBody
	public KeyoneResult updateTransfertail(TransferPlan transferPlan) throws Exception
	{
		KeyoneResult result = transferPlanService.updateTransfertail(transferPlan);
		return result;
	}

	//新建传代方案
	@RequestMapping("/plan/createtransferplan")
	@ResponseBody
	public KeyoneResult createtransferplan(TransferPlan transferPlan) throws Exception
	{
		KeyoneResult result = transferPlanService.createtransferplan(transferPlan);
		return result;
	}

	//删除传代方案
	@RequestMapping("/plan/deletetransferplan")
	@ResponseBody
	public KeyoneResult deletetransferplan(String transferPlanName) throws Exception
	{
		KeyoneResult result = transferPlanService.deletetransferplan(transferPlanName);
		return result;
	}

	//传代方案提交
	@RequestMapping("/plan/dealTransferPlan")
	@ResponseBody
	public KeyoneResult dealTransferPlan(String transferPlanName) throws Exception
	{
		if (transferPlanName == null)
		{
			transferPlanName = jedisClient.get("PLANNAME");
		}
		//将方案名字设置到redis中
		jedisClient.set("PLANNAME", transferPlanName);
		//model不能用在重定向(redirect)中 一定是retrun字符串 页面中
		transferPlanService.dealTransferPlan(transferPlanName);
		//如果客户端关闭响应
		Thread.sleep(1000);
		if (jedisClient.get("TIPS") != null)
		{
			return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		return KeyoneResult.ok();
		//把模式要传给watch页面
		//model.addAttribute("redirect", mode);
		//return "watch";
	}
}
