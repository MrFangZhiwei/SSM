<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--指令元素--%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误信息</title>
<script type="text/javascript">
	//防止页面后退
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function() {
		history.pushState(null, null, document.URL);
	});
	function refresh() {
		window.location.reload();
	}
</script>
<style type="text/css">
.refresh {
	cursor: pointer;
	width: 35%
}
</style>
</head>
<body style="text-align: center;">
	<div style="color:red;font-size:20pt;text-align:center">
		<font color="red"><b>错误信息:${message}<br />页面出现错误请尝试刷新,如无法解决请与管理员联系!!!</b>
		</font>
	</div>
	<br>
	<div id="timer" style="color:#999;font-size:30pt;text-align:center"></div>
	<img src="${pageContext.request.contextPath}/images/refresh.png" onclick="refresh()" class="refresh">
	<br>
	<span style="font-size:30pt;text-align:center">点击图片刷新继续上一步动作</span>
</body>
</html>