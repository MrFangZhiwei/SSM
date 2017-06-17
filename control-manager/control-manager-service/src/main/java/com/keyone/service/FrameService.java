package com.keyone.service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.dao.JedisClient;

public interface FrameService
{
   KeyoneResult	arriveFrame(JedisClient jedisClient) throws Exception;
}
