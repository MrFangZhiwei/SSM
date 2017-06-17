package com.keyone.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.util.ExceptionUtil;
import com.keyone.sso.service.SmsUserService;

@Controller
@RequestMapping("/sms")
public class SmsUserController
{
	@Autowired
	private SmsUserService smsUserService;
	
	/**
	 * 获取验证码
	 * <p>Title: getidentifycode</p>
	 * <p>Description: </p>
	 * @param phone
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/idenfiy")
	@ResponseBody
	public KeyoneResult getidentifycode(String phone, HttpServletRequest request, HttpServletResponse response)
	{
		KeyoneResult result = smsUserService.getidentifycode(phone, request, response);
		return result;

	}

	/**
	 * 验证用户输入的验证码是否过期或者错误
	 * <p>Title: userLogin</p>
	 * <p>Description: </p>
	 * @param phone
	 * @param identifycode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/userlogin")
	@ResponseBody
	public KeyoneResult userLogin(String phone, String identifycode, HttpServletRequest request,
			HttpServletResponse response)
	{
		KeyoneResult result = smsUserService.userLogin(phone, identifycode, request, response);
		return result;

	}
	
	/**
	 * 获取用户信息
	 * <p>Title: getUserByToken</p>
	 * <p>Description: </p>
	 * @param token
	 * @return
	 */
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback)
	{
		KeyoneResult result = null;
		try
		{
			result = smsUserService.getUserByToken(token);
		} catch (Exception e)
		{
			result = KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		//判断是否为jsonp调用 
		if (StringUtils.isBlank(callback))
		{
			return result;
		} else
		{
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
	}
}
