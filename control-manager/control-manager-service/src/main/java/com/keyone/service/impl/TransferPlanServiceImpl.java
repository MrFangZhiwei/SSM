package com.keyone.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.pojo.TransferPlan;
import com.keyone.common.util.DOMUtils;
import com.keyone.common.util.ExceptionUtil;
import com.keyone.service.SendUtilService;
import com.keyone.service.TransferPlanService;

/**
 * 传代的业务层逻辑处理类
 * <p>Title: TransferPlanServiceImpl</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-18上午9:54:53
 * @version  1.0
 */
@Service
public class TransferPlanServiceImpl implements TransferPlanService
{
	@Autowired
	private SendUtilService sendUtilService;

	@Override
	public List<TransferPlan> showTranferPlan()
	{
		List<TransferPlan> tlist = new ArrayList<TransferPlan>();
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/transfer.xml").getPath());
		Element rootElement = document.getRootElement();
		List<Element> list = DOMUtils.getChildElements(rootElement);
		for (Element element : list)
		{
			TransferPlan transferPlan = new TransferPlan();
			transferPlan.setTplanName(element.getName());
			tlist.add(transferPlan);
		}
		return tlist;
	}

	@Override
	public TransferPlan showTranferDetail(String transferPlanName) throws Exception
	{
		TransferPlan transferPlan = new TransferPlan();
		transferPlan.setTplanName(transferPlanName);
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/transfer.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element = DOMUtils.getChildElement(rootElement, transferPlanName);
		List<Element> elements = DOMUtils.getChildElements(element);
		int i = 1;
		for (Element e : elements)
		{
			switch (i)
			{
			case 1:
				transferPlan.setStep1(e.getText());
				break;
			case 2:
				transferPlan.setStep2(e.getText());
				break;
			case 3:
				transferPlan.setStep3(e.getText());
				break;
			case 4:
				transferPlan.setStep4(e.getText());
				break;
			case 5:
				transferPlan.setStep5(e.getText());
				break;
			case 6:
				transferPlan.setStep6(e.getText());
				break;
			case 7:
				transferPlan.setStep7(e.getText());
				break;
			case 8:
				transferPlan.setStep8(e.getText());
				break;
			case 9:
				transferPlan.setStep9(e.getText());
				break;
			case 10:
				transferPlan.setStep10(e.getText());
				break;
			case 11:
				transferPlan.setStep11(e.getText());
				break;
			}
			i++;
		}

		return transferPlan;
	}

	//接收数据修改配置文件
	public KeyoneResult updateTransfertail(TransferPlan transferPlan) throws Exception
	{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/transfer.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element = DOMUtils.getChildElement(rootElement, transferPlan.getTplanName().trim());
		Element childElement1 = DOMUtils.getChildElement(element, "step1");
		childElement1.setText(transferPlan.getStep1());
		Element childElement2 = DOMUtils.getChildElement(element, "step2");
		childElement2.setText(transferPlan.getStep2());
		Element childElement3 = DOMUtils.getChildElement(element, "step3");
		childElement3.setText(transferPlan.getStep3());
		Element childElement4 = DOMUtils.getChildElement(element, "step4");
		childElement4.setText(transferPlan.getStep4());
		Element childElement5 = DOMUtils.getChildElement(element, "step5");
		childElement5.setText(transferPlan.getStep5());
		Element childElement6 = DOMUtils.getChildElement(element, "step6");
		childElement6.setText(transferPlan.getStep6());
		Element childElement7 = DOMUtils.getChildElement(element, "step7");
		childElement7.setText(transferPlan.getStep7());
		Element childElement8 = DOMUtils.getChildElement(element, "step8");
		childElement8.setText(transferPlan.getStep8());
		Element childElement9 = DOMUtils.getChildElement(element, "step9");
		childElement9.setText(transferPlan.getStep9());
		Element childElement10 = DOMUtils.getChildElement(element, "step10");
		childElement10.setText(transferPlan.getStep10());
		Element childElement11 = DOMUtils.getChildElement(element, "step11");
		childElement11.setText(transferPlan.getStep11());
		try
		{
			DOMUtils.writeXMLToFile(document, this.getClass().getResource("/config/transfer.xml").getPath());
		} catch (IOException e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return KeyoneResult.ok();
	}

	//创建传代方案的节点
	public KeyoneResult createtransferplan(TransferPlan transferPlan) throws Exception
	{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/transfer.xml").getPath());
		Element rootElement = document.getRootElement();
		List<Element> list = DOMUtils.getChildElements(rootElement);
		for (Element element : list)
		{
			if (element.getName().equals(transferPlan))
			{
				return KeyoneResult.build(400, "方案名重复");
			}
		}
		DOMUtils.addChild(rootElement, transferPlan.getTplanName().trim(), null);
		Element element1 = DOMUtils.getChildElement(rootElement, transferPlan.getTplanName().trim());
		DOMUtils.addChild(element1, "step1", transferPlan.getStep1());
		DOMUtils.addChild(element1, "step2", transferPlan.getStep2());
		DOMUtils.addChild(element1, "step3", transferPlan.getStep3());
		DOMUtils.addChild(element1, "step4", transferPlan.getStep4());
		DOMUtils.addChild(element1, "step5", transferPlan.getStep5());
		DOMUtils.addChild(element1, "step6", transferPlan.getStep6());
		DOMUtils.addChild(element1, "step7", transferPlan.getStep7());
		DOMUtils.addChild(element1, "step8", transferPlan.getStep8());
		DOMUtils.addChild(element1, "step9", transferPlan.getStep9());
		DOMUtils.addChild(element1, "step10", transferPlan.getStep10());
		DOMUtils.addChild(element1, "step11", transferPlan.getStep11());
		try
		{
			DOMUtils.writeXMLToFile(document, this.getClass().getResource("/config/transfer.xml").getPath());
		} catch (IOException e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return KeyoneResult.ok();
	}

	//删除传代方案
	public KeyoneResult deletetransferplan(String transferPlanName) throws Exception
	{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/transfer.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element1 = DOMUtils.getChildElement(rootElement, transferPlanName);
		DOMUtils.removeElement(rootElement, element1);
		try
		{
			DOMUtils.writeXMLToFile(document, this.getClass().getResource("/config/transfer.xml").getPath());
		} catch (IOException e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return KeyoneResult.ok();
	}

	//传代方案提交
	public KeyoneResult dealTransferPlan(String transferPlanName) throws Exception
	{
		TransferPlan transferPlan = new TransferPlan();
		transferPlan.setTplanName(transferPlanName);
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/transfer.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element = DOMUtils.getChildElement(rootElement, transferPlanName);
		List<Element> elements = DOMUtils.getChildElements(element);
		int i = 1;
		for (Element e : elements)
		{
			switch (i)
			{
			case 1:
				transferPlan.setStep1(e.getText());
				break;
			case 2:
				transferPlan.setStep2(e.getText());
				break;
			case 3:
				transferPlan.setStep3(e.getText());
				break;
			case 4:
				transferPlan.setStep4(e.getText());
				break;
			case 5:
				transferPlan.setStep5(e.getText());
				break;
			case 6:
				transferPlan.setStep6(e.getText());
				break;
			case 7:
				transferPlan.setStep7(e.getText());
				break;
			case 8:
				transferPlan.setStep8(e.getText());
				break;
			case 9:
				transferPlan.setStep9(e.getText());
				break;
			case 10:
				transferPlan.setStep10(e.getText());
				break;
			case 11:
				transferPlan.setStep11(e.getText());
				break;
			}
			i++;
		}
		try
		{
			sendUtilService.control(transferPlan);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return KeyoneResult.ok(transferPlan);
	}

}
