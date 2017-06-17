package com.keyone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.service.LightService;
import com.keyone.service.SendUtilService;

/**
 * 控制灯光的服务类
 * <p>Title: LightServiceImpl</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-7下午3:03:10
 * @version  1.0
 */
@Service
public class LightServiceImpl implements LightService
{
	@Autowired
	private SendUtilService sendUtilService;
	@Override
	public KeyoneResult changelight(String status) throws Exception
	{
			//如果开关状态是1表示要关灯
			if(status.equals("1")){
				sendUtilService.control("c");
				return KeyoneResult.build(200,"close");
			}
			else if(status.equals("0")){
			  //如果开关状态是1表示要开灯
				sendUtilService.control("o");
				return KeyoneResult.build(200,"open");
			}
		return KeyoneResult.build(400, "发送失败");
	}

}
