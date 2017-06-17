<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<title>参数设置</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<c:forEach items="${mlist}" var="name">
        ${name.mplanName} <br>
	</c:forEach>
	
	<c:forEach items="${tlist}" var="name">
        ${name.tplanName} <br>
	</c:forEach>
	
	   ${medium.step1}
	    ${medium.step2}
	     ${medium.step3}
	      ${medium.step4}
</body>
</html>
