<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%--指令元素--%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培养模式选择</title>


<link rel="search" type="application/opensearchdescription+xml" href="https://static-s.bilibili.com/opensearch.xml" title="keyone">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="referrer" content="always">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,minimal-ui">
<link href="${baseurl}/css/normalize.css" rel="stylesheet">
<link href="${baseurl}/css/login-out.css" rel="stylesheet">
<script type="text/javascript" src="${baseurl}/js/jquery-1.6.4.js"></script>
<style>
/*==================王大洁写的==============*/
	.contain{
		margin: 0 auto;
		width:415px;
		position: fixed;
		bottom: 0;
		text-align:center;
	}
	.box1{
		margin: 0 auto;
		background:#ccc;
		height:50px; 
		width:50px;
		margin-bottom: 10px;
		border-radius: 50px;
		color: #fff;
		font-size: 1em;
		font-weight: bold;
	}
	.box4{
		margin: 0 auto;
		background-color: #e7172a;
		height:50px; 
		width:50px;
		margin-bottom: 10px;
		border-radius: 50px;
		color: #fff;
		font-size: 1em;
		font-weight: bold;
	}
	.box3{
		margin: 0 auto;
		height:25px; 
		width:25px;
		margin-bottom: 10px;
		border-radius: 50px;
		color: #358ee6;
	}
	.box2{
		margin: 0 auto;
		height:50px; 
		width:50px;
		border-radius: 50px;
		margin-right: 25px;
		font: 16px "黑体";
	}
	span{
		font:20px "黑体";
	}
	li{
		float: left;
		list-style: none;
	}

/*==================王大洁写的==============*/

.input-alert {
	display: none;
}
.button{
	cursor: pointer;
}
</style>
<link charset="utf-8" rel="stylesheet" href="${baseurl}/css/white.css">
</head>
<body>

	<div class="contain">
			<ul>	
			<li><div class="box1"><br>
				 <span>1</span></div></li>
			<li><div class="box3"><img src="${baseurl}/images/point.png" style="margin-top: 20px;"></div></li>
		
			<li><div class="box1"><br>
				 <span>2</span></div></li>
		
			<li><div class="box3"><img src="${baseurl}/images/point.png" style="margin-top: 20px;"></div></li>
		
			<li><div class="box4"><br>
				 <span>3</span></div></li>
		
			<li><div class="box3"><img src="${baseurl}/images/point.png" style="margin-top: 20px;"></div></li>
		
			<li><div class="box1"><br>
				 <span>4</span></div></li>
		
			<li><div class="box3"><img src="${baseurl}/images/point.png" style="margin-top: 20px;"></div></li>
		
			<li><div class="box1"><br>
				 <span>5</span></div></li>
		
			</ul>
			<ul>	
			<li><div class="box2">选编号</div></li>
			<li><div class="box2">观察</div></li>
			<li><div class="box2">模式</div></li>
			<li><div class="box2">观察</div></li>
			<li><div class="box2">结束</div></li>
			</ul>
		</div>


	<header>
		<a class="logo" href="http://www.keyonecn.com/"></a> <a class="logoText">培养模式选择</a>
	</header>
	<div class="form">
		<form name="form2" id="passageCell" action="${baseurl}/control/chooseModeImpl" method="post">
			<div class="input-wrp" style="background: #ffffff">
				<select name="mode" id="mode" style="width: 100%;height: 100%">
					<option value="1" selected="selected" >Back</option>
					<option value="2">Passage</option>
					<option value="3">Medium Change</option>
					<option value="4">Sale</option>
					<option value="5">Disdard</option>
				</select>
			</div>
			<input type="hidden" name="gourl" value="http://www.bilibili.com"> <input type="hidden" name="dopost" value="regok">

			<div>
				<a class="button" id="sure">确认</a>
			</div>
		</form>
	</div>

	<script type="text/javascript">
	 //防止页面后退
	 history.pushState(null, null, document.URL);
	 window.addEventListener('popstate', function () {
	   history.pushState(null, null, document.URL);
	 });
	var countdown = 60;
	var mode=0;
	var Passage = {
			doChooseId:function() {
				location.href = "${baseurl}/control/chooseModeImpl?mode="+mode;
				//location.href = "http://www.keyonecn.com:8081/control/passage/chooseModeImpl?mode="+mode;
			}
			,
			chooseId:function() {
					this.doChooseId();
			}
	};

	$(function(){
		$("#sure").click(function(){
			mode=$("#mode option:selected").val();
			$.post("${baseurl}/control/chooseModeImpl", {"mode":mode}, function(data) {
				if (data.status==200) {
					location.href = "${baseurl}/control/plan";
				}else if(data.status==500){
					location.href = "${baseurl}/control/chooseId";
				}else if(data.status==400){
					alert("失败，原因是：" + data.msg);
				}
			});
			//Passage.chooseId();
			//变成表单post提交
			//$("#passageCell").submit();
			
		});
		
		$("#mode").change(function(){
			mode=$("#mode option:selected").val();
		});
	});
</script>

</body>
</html>
