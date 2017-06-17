package com.keyone.common.pojo;

/**
 * 换液的实体模型类
 * <p>Title: MediumPlan</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-18上午9:56:21
 * @version  1.0
 */
public class MediumPlan
{
	private String MplanName;
	private String step1;
	private String step2;
	private String step3;
	private String step4;
	
	public String getMplanName()
	{
		return MplanName;
	}
	public void setMplanName(String mplanName)
	{
		MplanName = mplanName;
	}
	public String getStep1()
	{
		return step1;
	}
	public void setStep1(String step1)
	{
		this.step1 = step1;
	}
	public String getStep2()
	{
		return step2;
	}
	public void setStep2(String step2)
	{
		this.step2 = step2;
	}
	public String getStep3()
	{
		return step3;
	}
	public void setStep3(String step3)
	{
		this.step3 = step3;
	}
	public String getStep4()
	{
		return step4;
	}
	public void setStep4(String step4)
	{
		this.step4 = step4;
	}
	
}
