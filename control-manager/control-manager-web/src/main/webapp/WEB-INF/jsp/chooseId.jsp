<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0044)https://passport.bilibili.com/register/phone -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培养瓶选择</title>


<link rel="search" type="application/opensearchdescription+xml" href="https://static-s.bilibili.com/opensearch.xml" title="keyone">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="referrer" content="always">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,minimal-ui">
<link href="/css/normalize.css" rel="stylesheet">
<link href="/css/login-out.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
<style>
.input-alert {
	display: none;
}
.button{
	cursor: pointer;
}
</style>
<link charset="utf-8" rel="stylesheet" href="/css/white.css">
</head>
<body>
	<header>
		<a class="logo" href="http://www.keyonecn.com/"></a> <a class="logoText">培养瓶选择</a>
	</header>
	<div class="form">
		<form name="form2" id="passageCell" action="https://passport.bilibili.com/register/phone" method="post" onsubmit="return checkForm(this)">


			<div class="input-wrp" style="background: #ffffff">
				<select name="cellId" id="cellId" style="width: 100%;height: 100%">
           <c:forEach items="${cellbottle}" var="bottle">
					<option value="${bottle.id}">${bottle.id}</option>
           </c:forEach>
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
	var cellId=0;
	var Passage = {
			doChooseId:function() {
				$.post("/control/passage/chooseIdImpl",{"cellId":cellId},function(data){
					if (data.status == 200) {
						  location.href = "/control/passage/watch";
						//location.href = "http://www.keyonecn.com:8081/control/passage/watch";
						alert("提交成功");
					} else {
						alert("失败，原因是：" + data.msg);
					}
				});
			}
			,
			chooseId:function() {
					this.doChooseId();
			}
	};


	
	$(function(){
		$("#sure").click(function(){
			cellId=$("#cellId option:selected").val();
			Passage.chooseId();
		});
		$("#mode").change(function(){
			cellId=$("#cellId option:selected").val();
		});
	});
</script>

</body>
</html>
