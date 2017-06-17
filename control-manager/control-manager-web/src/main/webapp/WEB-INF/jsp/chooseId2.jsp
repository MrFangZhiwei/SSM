<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%--指令元素--%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
<title>keyonecontrol</title>
<link rel="stylesheet" href="${baseurl}/css/style3.css">
</head>
<script type="text/javascript" src="${baseurl}/js/jquery-1.6.4.js"></script>
<style type="text/css">
body {
	margin: 0 auto;
}

.contain {
	margin: 0 auto;
	width: 400px;
	position: fixed;
	bottom: 0;
	text-align: center;
	margin-left: 13px;
}

.box1 {
	margin: 0 auto;
	background: #ccc;
	height: 50px;
	width: 50px;
	margin-bottom: 10px;
	border-radius: 50px;
	color: #fff;
	font-size: 1em;
	font-weight: bold;
}

.box4 {
	margin: 0 auto;
	background-color: #e7172a;
	height: 50px;
	width: 50px;
	margin-bottom: 10px;
	border-radius: 50px;
	color: #fff;
	font-size: 1em;
	font-weight: bold;
}

.box3 {
	margin: 0 auto;
	height: 25px;
	width: 25px;
	margin-bottom: 10px;
	border-radius: 50px;
	color: #358ee6;
}

.box2 {
	margin: 0 auto;
	height: 50px;
	width: 50px;
	border-radius: 50px;
	margin-right: 25px;
	font: 16px "黑体";
}

span {
	font: 20px "黑体";
}

li {
	float: left;
	list-style: none;
}

table {
	width: 97%;
}
</style>
<body>
	<div class="contain">
		<ul>
			<li><div class="box4">
					<br> <span>1</span>
				</div></li>
			<li><div class="box3">
					<img src="${baseurl}/images/point.png" style="margin-top: 20px;">
				</div></li>

			<li><div class="box1">
					<br> <span>2</span>
				</div></li>

			<li><div class="box3">
					<img src="${baseurl}/images/point.png" style="margin-top: 20px;">
				</div></li>

			<li><div class="box1">
					<br> <span>3</span>
				</div></li>

			<li><div class="box3">
					<img src="${baseurl}/images/point.png" style="margin-top: 20px;">
				</div></li>

			<li><div class="box1">
					<br> <span>4</span>
				</div></li>

			<li><div class="box3">
					<img src="${baseurl}/images/point.png" style="margin-top: 20px;">
				</div></li>

			<li><div class="box1">
					<br> <span>5</span>
				</div></li>

		</ul>
		<ul>
			<li><div class="box2">选编号</div></li>
			<li><div class="box2">观察</div></li>
			<li><div class="box2">模式</div></li>
			<li><div class="box2">观察</div></li>
			<li><div class="box2">结束</div></li>
		</ul>
	</div>

	<div class="list ticket">
		<form action="">
			<h2>培养瓶选择</h2>
			<div class="form">
				<p>
					<label for="to_date">培养瓶编号:</label> <input type="text" name="to_date" id="to_date" placeholder="请输入培养瓶编号">
				</p>
			</div>
			<div class="button">
				<p>
					<input type="button" value="确定" class="submit">
				</p>
			</div>
			<div class="new">
				<h2>全部记录</h2>
				<table style="cellspacing:0;cellpadding:0;">
					<thead>
						<tr>
							<th class="min">id</th>
							<th>Toid</th>
							<th>Cellnum</th>
							<th>Cellstatus</th>
							<th class="min">OsResult</th>
							<th>Endtime</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cellbottle}" var="bottle">
							<tr class="choose">
								<td class="min">${bottle.id}</td>
								<td>${bottle.toid}</td>
								<td class="price">${bottle.cellnum}</td>
								<td>${bottle.cellstatus}</td>
								<td class="min">${bottle.osresult}</td>
								<td><a href="###" class="reserve">${bottle.endtime}</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="7"><a href="###" class="more">加载更多记录...</a></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
	</div>
	<footer id="footer">
		<div class="top">客户端|触屏端|电脑版</div>
		<div class="bottom">CopyrigYCKU 宁波键一生物科技</div>
	</footer>
</body>
<script type="text/javascript">
	var cellId = 0;
	var Passage = {
		checkInput : function() {
			if ($("#to_date").val() == "") {
				alert("培养瓶编号不能为空");
				$("#to_date").focus();
				return false;
			}
			return true;
		},
		doChooseId : function() {
			cellId = $("#to_date").val();
			$.post("${baseurl}/control/chooseIdImpl", {
				"cellId" : cellId
			}, function(data) {
				if (data.status == 200) {
					//location.href = "${initParam.url}/control/passage/watch";
					location.href = "${baseurl}/control/watch";
					//location.href = "http://www.keyonecn.com:8081/control/passage/watch";
					alert("提交成功");
				} else if (data.status == 500) {
					alert("失败，原因:" + data.msg);
				} else {
					alert("失败，原因:ACCS系统没有开启远程");
				}
			});
		},
		chooseId : function() {
			this.doChooseId();
		}
	};

	$(function() {
		$(".choose").click(function() {
			var a = $(this).children().eq(0).text();
			$("#to_date").val(a);
			cellId = a;
		});

		$(".submit").click(function() {
			if (Passage.checkInput()) {
				Passage.chooseId();
			}

		});
	});
</script>
</html>
