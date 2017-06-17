package com.keyone.service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;

public interface MicroService
{
	KeyoneResult changeMicroone()throws Exception;
	KeyoneResult changeMicrotwo()throws Exception;
	KeyoneResult changeMicrothree()throws Exception;
	KeyoneResult arriveMicro(JedisClient jedisClient)throws Exception;
}
