<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--指令元素--%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主界面</title>
<style type="text/css">
	body{
		background-color: #358ee6;
		text-align: center;
		
	}
	.contain{
		
		margin: 0 auto;
		width:450px;
	}
	.box1{

		margin: 0 auto;
		margin-top: 200px;
		background-color: #ffffff;
		height:450px; 
		width:450px;
		border: 3px solid #a0a0a0;
		
		border-radius: 20px;
	}
	.box2{
		margin: 0 auto;
		margin-top: 300px;
		background-color: #ffffff;
		height:450px; 
		width:450px;
		border-radius: 20px;
		border: 3px solid #a0a0a0;
	}
	span{
		font-size: 2.5em;
	}

</style>
</head>
<body >
<div class="contain">
	<div class="box1">
		<a href="${pageContext.request.contextPath}/control/chooseId"><img src="${pageContext.request.contextPath}/images/control.png" style="margin-top: 40px"></a>
		<br>
		 <span>远程控制</span>
	</div>

	<div class="box2">
	<a href="http://www.keyonecn.com/new"><img src="${pageContext.request.contextPath}/images/chart.png" style="margin-top: 90px"></a>
	<br>
		 <span>数据监测</span>
	</div>
</div>


</body>
</html>

