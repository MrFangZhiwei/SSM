package com.keyone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.exception.MyException;
import com.keyone.pojo.Cellrecord;
import com.keyone.service.PassageService;

/**
 * 传代跳转页面控制器
 * <p>Title: PassageControl</p>
 * <p>Description: </p>
 * <p>Company:www.keyonecn.com</p>
 * @author   fzw
 * @date     2017-4-20上午9:23:31
 * @version  1.0
 */
@Controller
public class PassageControl
{
	@Autowired
	private PassageService passageService;
	
	@Autowired
	private JedisClient jedisClient;
	
	//显微镜观察的第一个次检查  检测ACCS是否开启
	@RequestMapping("/checkACCS")
	@ResponseBody 
	public KeyoneResult checkACCS(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   //测试远程是否还开着
		passageService.checkACCS();
		Thread.sleep(1000);
		if(jedisClient.get("TIPS")!=null){
			return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		jedisClient.set("ACCS", "1");
		return KeyoneResult.ok();
	}	
	
	//选择培养瓶编号页面
	@RequestMapping("/chooseId")
	public String chooseId(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实现选择培养瓶页面跳转	
		List<Cellrecord>  cellbottlelist = passageService.showCellbottle();
		model.addAttribute("cellbottle", cellbottlelist);
		//选择培养瓶编号显微镜的默认行为是""表示选择模式
		return "chooseId2";
	}
	
	@RequestMapping("/watch")
	public String watch(Model model) {
		if(	jedisClient.get("MODE")!=null){
			model.addAttribute("redirect", jedisClient.get("MODE"));
		}
		//实现观察显微镜页面跳转页面
		return "watch";
	}
	
	//选择培养模式
	@RequestMapping("/chooseMode")
	public String chooseMode()
	{
		//实现选择培养瓶页面跳转页面	
		//设置页面已经经过观察结束
		jedisClient.set("ACCS", "1");
		return "chooseMode";
	}
	
	
	//选择培养编号按钮处理
	@RequestMapping("/chooseIdImpl")
	@ResponseBody
	public KeyoneResult chooseIdImpl(String cellId,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		KeyoneResult result = passageService.chooseId(cellId,request,response,jedisClient);
		//ACCS系统正处于关闭状态
		Thread.sleep(1000);
		String tips="";
		try{
			tips = jedisClient.get("TIPS");
		}catch(Exception e){
			throw new MyException("网络未连接");
		}
		if(!StringUtils.isBlank(tips)){
			if(tips.equals("gg")){
				return KeyoneResult.build(400, "ACCS系统未开启");
			}
		}
		return result;
	}
	
	//选择模式之后  以及返回模式和丢弃模式售卖模式
	@RequestMapping("/chooseModeImpl")
	@ResponseBody
	public KeyoneResult chooseModeImpl(String mode,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//处理页面的刷新bug
		if(mode==null){
		mode=jedisClient.get("MODE");
		}
		passageService.chooseMode(mode,request,response);
		Thread.sleep(1100);
		if(jedisClient.get("TIPS")!=null){
    		return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		else if(mode.equals("1")||mode.equals("5")||mode.equals("4")){
			//如果模式是1或者是5就返回chooseId页面
			return KeyoneResult.build(500, "");
		}else{
			jedisClient.set("MODE", mode);
			return KeyoneResult.ok();
		}
		//如果客户端关闭响应
	 /*	Thread.sleep(1000);
    	if(jedisClient.get("TIPS")!=null){
    		throw new MyException("请勿中途关闭ACCS客户端");
		}*/
    	
//		if(!(result==null)){
//			//设置显微镜观察之后的行为
//			//model.addAttribute("redirect",mode);
//			//做完动作删除cookie
//			//CookieUtils.deleteCookie(request, response, "chooseId");
//			//CookieUtils.deleteCookie(request, response, "chooseMode");
//			//如果选择的是返回模式
//			if(mode.equals("1")||mode.equals("5")){
//				//如果模式是1或者是5就返回chooseId页面
//				return "redirect:/control/chooseId";
//			}
//			//如果不然就是传代和换液
//			//return "watch";
//			//跳转到选方案的页面 将模式传过去
//			request.setAttribute("redirect",mode);
//			return "forward:/control/plan";
//		}else{
//			//重复提交非法操作连续提交
//			return "chooseMode";
//		}
		
	}
	
	//选择模式之后
    @RequestMapping("/mediumChangeOver")
    @ResponseBody
    public KeyoneResult mediumChangeOver(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	KeyoneResult result = passageService.mediumChangeOver(request, response,jedisClient);
    	Thread.sleep(1000);
    	if(jedisClient.get("TIPS")!=null){
    		return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		return result;
    }
    
   //传代的第二步
    @RequestMapping("/digestOver")
    @ResponseBody
    public KeyoneResult digestOver(HttpServletRequest request, HttpServletResponse response) throws Exception{
     	KeyoneResult result = passageService.digestOver(request, response,jedisClient);
    	Thread.sleep(1000);
    	if(jedisClient.get("TIPS")!=null){
    		return KeyoneResult.build(400, "请勿中途关闭ACCS客户端");
		}
		return result;
    }
}
