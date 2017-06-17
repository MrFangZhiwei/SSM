package com.keyone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.service.LightService;

/**
 * 显微镜光源控制
 * <p>Title: LightController</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-7下午2:50:10
 * @version  1.0
 */
@Controller
public class LightController
{
	@Autowired
	private LightService lightService;
	@Autowired
	private JedisClient jedisClient;
	
	@RequestMapping("/light")
	@ResponseBody
	public KeyoneResult changelight(String lightstatus) throws Exception{
		KeyoneResult result = lightService.changelight(lightstatus);
		Thread.sleep(300);
		if(jedisClient.get("TIPS")!=null){
			return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		return result;
	}
}
