package com.keyone.service.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyone.common.pojo.MediumPlan;
import com.keyone.common.pojo.TransferPlan;
import com.keyone.dao.JedisClient;
import com.keyone.service.SendUtilService;

@Service
public class SendUtilServiceImpl implements SendUtilService, Runnable
{

	Socket socket = null;
	public static SendUtilServiceImpl s = null;
	public static String content = "";
	//public static  HttpServletRequest cellrequest;
	//public static HttpServletResponse cellresponse;

	@Autowired
	public JedisClient jedisClient;

	//方法重载,没有httprequest以及responds
	public void control(MediumPlan mediumPlan) throws Exception
	{
		String step1 = mediumPlan.getStep1();
		String step2 = mediumPlan.getStep2();
		String step3 = mediumPlan.getStep3();
		String step4 = mediumPlan.getStep4();
		content = jedisClient.get("ACCS_CELLID") + "_3_2";
		new Thread(this).start();
	}

	//方法重载,没有httprequest以及responds
	public void control(TransferPlan transferPlan) throws Exception
	{
		String step1 = transferPlan.getStep1();
		String step2 = transferPlan.getStep2();
		String step3 = transferPlan.getStep3();
		String step4 = transferPlan.getStep4();
		String step5 = transferPlan.getStep5();
		String step6 = transferPlan.getStep6();
		String step7 = transferPlan.getStep7();
		String step8 = transferPlan.getStep8();
		String step9 = transferPlan.getStep9();
		String step10 = transferPlan.getStep10();
		String step11 = transferPlan.getStep11();
		content = jedisClient.get("ACCS_CELLID") + "_2_2";
		new Thread(this).start();
	}

	//方法重载,没有httprequest以及responds
	public void control(String cellcontent) throws Exception
	{
		content = cellcontent;
		new Thread(this).start();
	}

	public void run()
	{
		Socket socket = null;
		InputStream dos = null;
		String result = null;
		String[] flag = null;
		try
		{
			socket = new Socket("121.199.2.76", 8886);
			if (socket.isConnected())
			{
				//System.out.println("已建立连接!---");
				//Thread.sleep(800);
				OutputStream outputStream = socket.getOutputStream();
				//首次发送对应瓶子的id
				outputStream.write(content.getBytes());

				//返回模式发送回去的信息
				//outputStream.write("100_1_1".getBytes());

				//发送细胞id以及模式
				//outputStream.write("100_2_1".getBytes());

				//传代模式输入细胞编号以及模式以及数量加瓶子数量
				// outputStream.write("321312_2_2_10_3_3".getBytes());

				//调用 outputStream.write("id_mode_numberCells_e".getBytes());
				//outputStream.write("321312_2_3_1_3".getBytes());

				//调用 outputStream.write("id_mode_4_id_Toid_BottleRemask".getBytes());
				// outputStream.write("321312_2_4_110_37_堪萨斯".getBytes());

				//调用 换液
				//outputStream.write("321312_3_1".getBytes());

				//返回培养瓶
				//outputStream.write("3211312_4_1".getBytes());

				//返回培养管是否消化
				//outputStream.write("3211312_5_1".getBytes());

				//返回培养管
				//outputStream.write("3211312_5_2".getBytes());

				//获取socket发送过来的输出流
				dos = socket.getInputStream();
				byte[] buffer = new byte[1024];
				int len = -1;
				while ((len = dos.read(buffer)) != -1)
				{
					//接受字符串
					result = new String(buffer, 0, len, "utf-8");
					//System.out.println(result);
					flag = result.split("_");
					//开始做逻辑判断
					if (flag.length == 1)
					{
						String first = flag[0];
						if (first.equals("0"))
						{
							jedisClient.expire("MODE", -1);
							//设置表示培养瓶编号已经提交
							jedisClient.set("ACCS", "0");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (first.equals("c"))
						{
							//System.out.println("灯光关闭");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (first.equals("o"))
						{
							//System.out.println("灯光开启");
						} else if (first.equals("x"))
						{
							//cellresponse.setContentType("text/html; charset=utf-8");
							//PrintWriter writer = cellresponse.getWriter();
							//writer.write("<script>alert('培养瓶到达显微镜');</script>");
							//System.out.println("培养瓶到达显微镜");
							//如果到达显微镜则弹窗
							//调用sso系统的服务,根据token取用户信息
							// HttpClientUtil.doGet("http://localhost:8080/passage/tips");
							jedisClient.set("TIPSMICRO", "x");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (first.equals("f"))
						{
							//培养瓶到达架子
							//设置提示
							jedisClient.set("TIPSFRAME", "f");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (first.equals("y"))
						{
							//校验ACCS
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (first.equals("gg"))
						{
							//显微镜程序并未打开
							//设置提示未开启ACCS系统
							jedisClient.set("TIPS", "gg");
							//System.out.println("gg");
						}
					} else if (flag.length == 2)
					{
						String mode = flag[0];
						String nextmode = flag[1];
						if (nextmode.equals("1") && mode.equals("1"))
						{
							jedisClient.expire("TIPS", -1);
							jedisClient.set("ACCS", "-1");
							//PLC工作结束培养瓶返回模式结束,页面响应
							//System.out.println("返回模式结束");
							//方案结束
							jedisClient.expire("MODE", -1);
							//设置ACCS系统已经打开放行
						} else if (nextmode.equals("1") && mode.equals("2"))
						{
							//PLC工作结束传代模式到达开始计数阶段
							//	System.out.println("叫我输入细胞技计数以及细胞瓶子的数目");
							//确定之后发送
							//调用 outputStream.write("id_mode_numberCells_e__numbottle".getBytes());
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
							jedisClient.set("ACCS", "2_1");
						} else if (nextmode.equals("2") && mode.equals("2"))
						{
							//PLC工作结束传代模式到达输入传代瓶数的阶段,页面响应
							//System.out.println("消化完成开始传代动作");
							//确定之后发送
							//调用 outputStream.write("id_mode_numberCells_e".getBytes());
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
							//开始执行传代方案
							jedisClient.set("ACCS", "2_2");
						} else if (nextmode.equals("3") && mode.equals("2"))
						{
							//PLC工作结束传代模式到Remasks
							//System.out.println("叫我输入细胞Remasks");
							//确定之后发送
							//调用 outputStream.write("id_Toid_BottleRemask".getBytes());
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
							//开始执行换液方案
							jedisClient.set("ACCS", "-1");
							//方案结束
							jedisClient.expire("MODE", -1);
						} else if (nextmode.equals("4") && mode.equals("2"))
						{
							//PLC工作结束传代模式到结束
							//System.out.println("结束传代");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (nextmode.equals("1") && mode.equals("3"))
						{
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
							//System.out.println("换液开始");
							jedisClient.set("ACCS", "3_1");
						} else if (nextmode.equals("2") && mode.equals("3"))
						{
							//换液模式方案提交
							jedisClient.set("ACCS", "3_2");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
						} else if (nextmode.equals("3") && mode.equals("3"))
						{
							//PLC工作结束换液模式结束,页面响应
							//System.out.println("换液结束");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
							jedisClient.set("ACCS", "-1");
							//方案结束
							jedisClient.expire("MODE", -1);
						} else if (nextmode.equals("1") && mode.equals("4"))
						{
							//PLC工作结束瓶子销售结束,页面响应
							//System.out.println("卖培养瓶结束");
							jedisClient.expire("TIPS", -1);
							jedisClient.set("ACCS", "-1");
							//方案结束
							jedisClient.expire("MODE", -1);
						} else if (nextmode.equals("1") && mode.equals("5"))
						{
							//PLC工作结束管子开始消化,页面响应
							//System.out.println("培养瓶丢弃");
							//设置ACCS系统已经打开放行
							jedisClient.expire("TIPS", -1);
							jedisClient.set("ACCS", "-1");
							//方案结束
							jedisClient.expire("MODE", -1);
						}

					}
				}
			}
		} catch (Exception s)
		{
			try
			{
				if (!socket.equals(null))
				{
					socket.close();
				}
				jedisClient.set("TIPS", "gg");
			} catch (Exception e)
			{
				jedisClient.set("TIPS", "gg");
			}
		}
	}

}
