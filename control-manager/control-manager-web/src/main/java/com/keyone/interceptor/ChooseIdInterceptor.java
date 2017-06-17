package com.keyone.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.keyone.dao.JedisClient;
import com.keyone.exception.MyException;

public class ChooseIdInterceptor implements HandlerInterceptor
{
	@Autowired
	private JedisClient jedisClient;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		//handler执行之前
		//返回值绝对handler是否执行。ture执行 false不执行
		//判断用户是否提交过瓶子的编号如果没有提交就放行,如果提交过就跳转到显微镜观察的页面
		Thread.sleep(1000);
		String flag = "";
		try
		{
			flag = jedisClient.get("ACCS");
		} catch (Exception e)
		{
			throw new MyException("网络出现错误,请重新访问");
		}
		if (flag == null)
		{
			flag = "-1";
		}
		if (flag.equals("0"))//0就是已经chooseId页面提交了
		{
			request.getRequestDispatcher("/control/watch").forward(request, response);
			return false;
		} else if (flag.equals("1"))//1就是已经watch页面提交了
		{
			request.getRequestDispatcher("/control/chooseMode").forward(request, response);
			return false;
		} else if (flag.equals("2_1") || flag.equals("3_1"))
		{
			request.getRequestDispatcher("/control/plan").forward(request, response);
			return false;
		} else if (flag.equals("2_2") || flag.equals("3_2"))
		{
			request.getRequestDispatcher("/control/watch").forward(request, response);
			return false;
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
		//handler执行之后,返回ModelView之前

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		//返回ModelView之后
		//反应用户之后

	}

}
