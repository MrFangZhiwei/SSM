package com.keyone.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.service.FrameService;

/**
 * 检测培养是否到达培养架位置
 * <p>Title: FrameServiceImpl</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-15下午12:47:49
 * @version  1.0
 */
@Service
public class FrameServiceImpl implements FrameService
{

	public KeyoneResult arriveFrame(JedisClient jedisClient)throws Exception
	{
		String tips = jedisClient.get("TIPSFRAME");
		if(!StringUtils.isBlank(tips)){
			if(tips.equals("f")){
				//删除信号
				jedisClient.expire("TIPSFRAME",-1);
				return KeyoneResult.build(400, "f");
			}
		}
		return KeyoneResult.ok();
	}

}
