package com.keyone.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;
import com.keyone.pojo.Cellrecord;

public interface PassageService
{
	List<Cellrecord> showCellbottle() throws Exception;
	KeyoneResult chooseId(String cellId,HttpServletRequest request,HttpServletResponse response,JedisClient jedisClient) throws Exception;
	KeyoneResult checkACCS()throws Exception;
	KeyoneResult watchover(HttpServletRequest request,HttpServletResponse response,JedisClient jedisClient)throws Exception;
	KeyoneResult chooseMode(String mode,HttpServletRequest request,HttpServletResponse response) throws Exception;
	KeyoneResult mediumChangeOver(HttpServletRequest request,HttpServletResponse response,JedisClient jedisClient);
	KeyoneResult digestOver(HttpServletRequest request,HttpServletResponse response,JedisClient jedisClient)  throws Exception;;
}
