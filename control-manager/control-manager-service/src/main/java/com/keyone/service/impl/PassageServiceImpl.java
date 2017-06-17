package com.keyone.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.KeyoneResult;
import com.keyone.common.util.CookieUtils;
import com.keyone.common.util.ExceptionUtil;
import com.keyone.dao.JedisClient;
import com.keyone.mapper.CellrecordMapper;
import com.keyone.pojo.Cellrecord;
import com.keyone.pojo.CellrecordExample;
import com.keyone.pojo.CellrecordExample.Criteria;
import com.keyone.service.PassageService;
import com.keyone.service.SendUtilService;

@Service
public class PassageServiceImpl implements PassageService
{
	@Autowired
	private CellrecordMapper cellrecordMapper;
	@Autowired
	private SendUtilService sendUtilService;
	//培养瓶编号
	private static String cellIdnow;

	/**
	 * 选择培养瓶编号
	 * <p>Title: chooseId</p>
	 * <p>Description: </p>
	 * @param cellId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public KeyoneResult chooseId(String cellId, HttpServletRequest request, HttpServletResponse response,
			JedisClient jedisClient) throws Exception
	{
		//之前获取chooseId中cookie的值看是否为null
		//String value = CookieUtils.getCookieValue(request, "chooseId");
		//if (StringUtils.isBlank(value))
		//{
		Cellrecord cellrecord = cellrecordMapper.selectByPrimaryKey(cellId);
		if (cellrecord == null)
		{
			return KeyoneResult.build(500, "该培养瓶编号不存在");
		} else
		{
			cellIdnow = cellId;
			sendUtilService.control(cellId);
			//CookieUtils.setCookie(request, response, "chooseId", cellId);
			jedisClient.set("ACCS_CELLID", cellIdnow);
			return KeyoneResult.ok();
		}

		//}
		//return KeyoneResult.build(400, "请不要重复提交");

	}

	//选择完模式之后
	public KeyoneResult chooseMode(String mode, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		//之前获取chooseId中cookie的值看是否为null
		//String value = CookieUtils.getCookieValue(request, "chooseMode");
		//if (StringUtils.isBlank(value))
		//	{
		String message = cellIdnow + "_" + mode + "_1";
		sendUtilService.control(message);
		//处理页面的刷新bug  先将mode设置好
		//CookieUtils.setCookie(request, response, "chooseMode", mode);
		//丢弃模式删除对应编号的培养瓶
		if (mode.equals("5") || mode.equals("4"))
		{
			//修改数据库删除对应编号的培养瓶
			cellrecordMapper.deleteByPrimaryKey(cellIdnow);
		}
		return KeyoneResult.ok();
		//}
	}

	/**
	 * 搜索细胞培养瓶的全部编号
	 * <p>Title: showCellbottle</p>
	 * <p>Description: </p>
	 * @return
	 */
	public List<Cellrecord> showCellbottle() throws Exception
	{
		CellrecordExample example = new CellrecordExample();
		List<Cellrecord> cellRecordlist = cellrecordMapper.selectByExample(example);
		return cellRecordlist;
	}

	//观察结束做出路径判断
	public KeyoneResult watchover(HttpServletRequest request, HttpServletResponse response, JedisClient jedisClient)
	{
		//之前获取chooseId中cookie的值看是否为null
		String value = CookieUtils.getCookieValue(request, "chooseMode");
		//如果还没有选模式
		if (StringUtils.isBlank(value))
		{
			value = "0";
		}
		switch (value)
		{
		case "1":
			// 返回模式
			return KeyoneResult.build(200, "1");
		case "2":
			// 传代模式
			return KeyoneResult.build(200, "2");
		case "3":
			// 换液模式
			return KeyoneResult.build(200, "3");
		case "4":
			// 售卖模式
			return KeyoneResult.build(200, "4");
		case "5":
			// 丢弃模式
			return KeyoneResult.build(200, "5");
		}

		return KeyoneResult.build(200, "");
	}

	//换液模式结束
	public KeyoneResult mediumChangeOver(HttpServletRequest request, HttpServletResponse response,
			JedisClient jedisClient)
	{
		try
		{
			//如果是cellIdnow是null则抛出异常
			if (cellIdnow == null)
			{
				cellIdnow = jedisClient.get("ACCS_CELLID");
			}
			//发送数据删除cookie
			sendUtilService.control(cellIdnow + "_3_3");
			//修改数据库
			CellrecordExample example = new CellrecordExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(cellIdnow);
			Cellrecord cellrecord = cellrecordMapper.selectByPrimaryKey(cellIdnow);
			cellrecord.setCellstatus("medium change bottom");
			cellrecordMapper.updateByExample(cellrecord, example);
			//CookieUtils.deleteCookie(request, response, "chooseId");
			return KeyoneResult.ok();
		} catch (Exception e)
		{
			return KeyoneResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 消化完成开始离心计数
	 * <p>Title: digestOver</p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@Override
	public KeyoneResult digestOver(HttpServletRequest request, HttpServletResponse response, JedisClient jedisClient)
			throws Exception
	{
		//发送数据删除cookie
		//如果是cellIdnow是null则抛出异常
		if (cellIdnow == null)
		{
			cellIdnow = jedisClient.get("ACCS_CELLID");
		}
		sendUtilService.control(cellIdnow + "_2_3");
		return KeyoneResult.ok();
	}

	public KeyoneResult checkACCS() throws Exception
	{
		sendUtilService.control("y");
		return KeyoneResult.ok();
	}

}
