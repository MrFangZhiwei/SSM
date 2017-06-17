package com.keyone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
	@RequestMapping("/main")
	public String showMain(){
		//设置逻辑视图的名字
		return "main";
	}
}
