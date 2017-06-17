package com.keyone.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.pojo.MediumPlan;
import com.keyone.common.util.DOMUtils;
import com.keyone.common.util.ExceptionUtil;
import com.keyone.service.MediumPlanService;
import com.keyone.service.SendUtilService;

/**
 * 换液的业务层逻辑处理类
 * <p>Title: MediumPlanServiceImpl</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-18上午9:53:58
 * @version  1.0
 */
@Service
public class MediumPlanServiceImpl implements MediumPlanService
{
	@Autowired
	private SendUtilService sendUtilService;

	@Override
	public List<MediumPlan> showMediumPlan() throws Exception
	{
		List<MediumPlan> mlist = new ArrayList<MediumPlan>();
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/medium.xml").getPath());
		Element rootElement = document.getRootElement();
		List<Element> list = DOMUtils.getChildElements(rootElement);
		for (Element element : list)
		{
			MediumPlan mediumPlan = new MediumPlan();
			mediumPlan.setMplanName(element.getName());
			mlist.add(mediumPlan);
		}
		return mlist;
	}

	@Override
	public MediumPlan showMediumDetail(String mediumPlanName) throws Exception
	{
		MediumPlan mediumPlan = new MediumPlan();
		mediumPlan.setMplanName(mediumPlanName);
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/medium.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element = DOMUtils.getChildElement(rootElement, mediumPlanName.trim());
		List<Element> elements = DOMUtils.getChildElements(element);
		int i = 1;
		for (Element e : elements)
		{
			switch (i)
			{
			case 1:
				mediumPlan.setStep1(e.getText());
				break;
			case 2:
				mediumPlan.setStep2(e.getText());
				break;
			case 3:
				mediumPlan.setStep3(e.getText());
				break;
			case 4:
				mediumPlan.setStep4(e.getText());
				break;
			}
			i++;
		}

		return mediumPlan;
	}

	//修改配置文件
	public KeyoneResult updateMediumDetail(MediumPlan mediumPlan) throws Exception
	{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/medium.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element = DOMUtils.getChildElement(rootElement, mediumPlan.getMplanName().trim());
		Element childElement1 = DOMUtils.getChildElement(element, "step1");
		childElement1.setText(mediumPlan.getStep1());
		Element childElement2 = DOMUtils.getChildElement(element, "step2");
		childElement2.setText(mediumPlan.getStep2());
		Element childElement3 = DOMUtils.getChildElement(element, "step3");
		childElement3.setText(mediumPlan.getStep3());
		Element childElement4 = DOMUtils.getChildElement(element, "step4");
		childElement4.setText(mediumPlan.getStep4());
		try
		{
			DOMUtils.writeXMLToFile(document, this.getClass().getResource("/config/medium.xml").getPath());
		} catch (IOException e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return KeyoneResult.ok();
	}

	//创建换液方案的节点
	public KeyoneResult createmediumplan(MediumPlan mediumPlan) throws Exception
	{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/medium.xml").getPath());
		Element rootElement = document.getRootElement();
		List<Element> list = DOMUtils.getChildElements(rootElement);
		for (Element element : list)
		{
			if (element.getName().equals(mediumPlan))
			{
				return KeyoneResult.build(400, "方案名重复");
			}
		}
		DOMUtils.addChild(rootElement, mediumPlan.getMplanName().trim(), null);
		Element element1 = DOMUtils.getChildElement(rootElement, mediumPlan.getMplanName().trim());
		DOMUtils.addChild(element1, "step1", mediumPlan.getStep1());
		DOMUtils.addChild(element1, "step2", mediumPlan.getStep2());
		DOMUtils.addChild(element1, "step3", mediumPlan.getStep3());
		DOMUtils.addChild(element1, "step4", mediumPlan.getStep4());
		try
		{
			DOMUtils.writeXMLToFile(document, this.getClass().getResource("/config/medium.xml").getPath());
		} catch (IOException e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return KeyoneResult.ok();
	}

	//删除换液方案
	public KeyoneResult deletemediumplan(String mediumPlanName) throws Exception
	{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/medium.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element1 = DOMUtils.getChildElement(rootElement, mediumPlanName);
		DOMUtils.removeElement(rootElement, element1);
		try
		{
			DOMUtils.writeXMLToFile(document, this.getClass().getResource("/config/medium.xml").getPath());
		} catch (IOException e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return KeyoneResult.ok();
	}

	//换液方案提交
	public KeyoneResult dealMediumPlan(String mediumPlanName) throws Exception
	{
		MediumPlan mediumPlan = new MediumPlan();
		mediumPlan.setMplanName(mediumPlanName);
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/config/medium.xml").getPath());
		Element rootElement = document.getRootElement();
		Element element = DOMUtils.getChildElement(rootElement, mediumPlanName.trim());
		List<Element> elements = DOMUtils.getChildElements(element);
		int i = 1;
		for (Element e : elements)
		{
			switch (i)
			{
			case 1:
				mediumPlan.setStep1(e.getText());
				break;
			case 2:
				mediumPlan.setStep2(e.getText());
				break;
			case 3:
				mediumPlan.setStep3(e.getText());
				break;
			case 4:
				mediumPlan.setStep4(e.getText());
				break;
			}
			i++;
		}
		try
		{
			sendUtilService.control(mediumPlan);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return KeyoneResult.ok(mediumPlan);
	}

}
