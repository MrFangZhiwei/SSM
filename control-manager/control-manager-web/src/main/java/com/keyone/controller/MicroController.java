package com.keyone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.service.MicroService;

/**
 * 显微镜电机旋转控制
 * <p>Title: MicroController</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-5-8上午10:30:33
 * @version  1.0
 */
@Controller
public class MicroController
{
	@Autowired
	private MicroService microService;
	@Autowired
	private JedisClient jedisClient;
	//电机正转
	@RequestMapping("/changeMicroone")
	@ResponseBody
	public KeyoneResult changeMicroone() throws Exception{
		KeyoneResult result = microService.changeMicroone();
		return result;
	}
	
	//电机反转
	@RequestMapping("/changeMicrotwo")
	@ResponseBody
	public KeyoneResult changeMircone() throws Exception{
		KeyoneResult result = microService.changeMicrotwo();
		return result;
	}
	//电机停止
	@RequestMapping("/changeMicrothree")
	@ResponseBody
	public KeyoneResult changeMicrothree() throws Exception{
		KeyoneResult result = microService.changeMicrothree();
		return result;
		}
	//显微镜到达位置
	@RequestMapping("arriveMicro")
	@ResponseBody
	public KeyoneResult arriveMicro() throws Exception{
		KeyoneResult result = microService.arriveMicro(jedisClient);
		return result;
	}
}
