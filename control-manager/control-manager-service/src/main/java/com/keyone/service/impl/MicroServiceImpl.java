package com.keyone.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.service.MicroService;
import com.keyone.service.SendUtilService;

/**
 *  显微镜电机状态改变
 * <p>Title: MicroServiceImpl</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-8上午10:15:20
 * @version  1.0
 */

@Service
public class MicroServiceImpl implements MicroService
{
	@Autowired
	private SendUtilService sendUtilService;
	/**
	 * 显微镜电机正转
	 * <p>Title: changeMircone</p>
	 * <p>Description: </p>
	 * @return
	 * @throws Exception 
	 */
	@Override
	public KeyoneResult changeMicroone() throws Exception
	{
		sendUtilService.control("l");
		return KeyoneResult.ok();
	}
	
	
	
	/**
	 * 显微镜电机反转
	 * <p>Title: changeMircone</p>
	 * <p>Description: </p>
	 * @return
	 * @throws Exception 
	 */
	@Override
	public KeyoneResult changeMicrotwo() throws Exception
	{
		sendUtilService.control("r");
		return KeyoneResult.ok();
	}
	
	/**
	 * 显微镜电机反转
	 * <p>Title: changeMircone</p>
	 * <p>Description: </p>
	 * @return
	 * @throws Exception 
	 */
	@Override
	public KeyoneResult changeMicrothree() throws Exception
	{
		sendUtilService.control("s");
		return KeyoneResult.ok();
	}

/**
 * 培养瓶是否到达显微镜
 * <p>Title: arriveMicro</p>
 * <p>Description: </p>
 * @return
 * @throws Exception
 */

	@Override
	public KeyoneResult arriveMicro(JedisClient jedisClient) throws Exception
	{
		String tips = jedisClient.get("TIPSMICRO");
		if(!StringUtils.isBlank(tips)){
			if(tips.equals("x")){
				//删除信号
				jedisClient.expire("TIPSMICRO",-1);
				return KeyoneResult.build(400, "x");
			}
		}
		return KeyoneResult.ok();
	}
	

}
