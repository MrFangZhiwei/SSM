package com.keyone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.service.FrameService;

/**
 * 到达培养架的控制类
 * <p>Title: FrameController</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-15下午12:58:23
 * @version  1.0
 */
@Controller
public class FrameController
{
	@Autowired
	private JedisClient jedisClient;
	
	@Autowired
	private FrameService frameService;
	
	@RequestMapping("/arriveFrame")
	@ResponseBody
	public  KeyoneResult arriveFrame() throws Exception{
//		if(jedisClient.get("TIPS")!=null){
//			return KeyoneResult.build(500, "请勿中途关闭ACCS客户端");
//		}
		KeyoneResult result = frameService.arriveFrame(jedisClient);
		return result;
	} 
}
