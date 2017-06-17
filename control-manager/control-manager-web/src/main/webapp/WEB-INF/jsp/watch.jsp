<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--指令元素--%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
<title>显微镜观察</title>
<link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/Buttons/2.0.0/css/buttons.min.css">
<link href="//nos.netease.com/vod163/nep.min.css" rel="stylesheet">
<script type="text/javascript" src="${baseurl}/js/jquery-1.6.4.js"></script>
<style type="text/css">
/*==================王大洁写的==============*/
	.contain{
		margin: 0 auto;
		width:415px;
		position: fixed;
		bottom: 0;
		text-align:center;
		margin-left:-35px;
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

.but {
	display: inline-block;
	background: url(${baseurl}/images/1.png) no-repeat center;
	height: 60px;
	width: 65px;
	border-radius: 8px;
}

.test {
	margin-right: auto;
	width: 360px;
	margin: 0 auto;
}

.all {
	
}

.but:active {
	
}

.row {
	margin-top: 5px;
}

.my-video-dimensions {
	width: 1000px;
	height: 700px;
}

.watchover {
	cursor: pointer;
	display: inline-block;
	border-radius: 6px;
	width: 60px;
	height: 35px;
	margin-right: 1em;
	background: url(${baseurl}/images/but.png) no-repeat center;
	margin-right: 1em;
	vertical-align: middle;
	margin-bottom: 25px;
}

/*媒体查询大于480px且小于640px*/
@media ( min-width : 480px) and (max-width: 640px) {
	.my-video-dimensions {
		width: 500px;
		height: 350px;
	}
	.watchover {
		width: 70px;
		height: 37px;
		font-size: 13px;
	}
	.test {
		width: 360px;
		text-align: center;
		margin: 0 auto;
	}
}

@media ( max-width : 480px) {
	.my-video-dimensions {
		width: 350px;
		height: 250px;
	}
	.watchover {
		width: 60px;
		height: 33px;
		font-size: 10px;
	}
	.test {
		width: 360px;
		text-align: center;
		margin: 0 auto;
	}
}

div {
	
}

#lightbtn {
	cursor: pointer;
}

#btnPlus {
	cursor: pointer;
	display: inline-block;
	background: url(${baseurl}/images/yy.png) no-repeat center;
	border-radius: 6px;
	width: 40px;
	height: 40px;
	margin-right: 1em;
}

#btnMinus {
	cursor: pointer;
	display: inline-block;
	background: url(${baseurl}/images/zz.png) no-repeat center;
	border-radius: 6px;
	width: 40px;
	height: 40px;
	margin-right: 1em;
}
/*阻止手机菜单*/
* {
	-webkit-touch-callout: none; /*系统默认菜单被禁用*/
	-webkit-user-select: none; /*webkit浏览器*/
	-khtml-user-select: none; /*早期浏览器*/
	-moz-user-select: none; /*火狐*/
	-ms-user-select: none; /*IE10*/
	user-select: none;
}
</style>
<body>

	<div class="contain" style="z-index: 99">
			<ul>	
			<li><div class="box1"><br>
				 <span>1</span></div></li>
			<li><div class="box3"><img src="${baseurl}/images/point.png" style="margin-top: 20px;"></div></li>
		
			<li><div class="box1"><br>
				 <span>2</span></div></li>
		
			<li><div class="box3"><img src="${baseurl}/images/point.png" style="margin-top: 20px;"></div></li>
		
			<li><div class="box1"><br>
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




	<!-- <h1>直播播放器</h1> -->
	<video id="my-video" class="video-js" style="margin:0 auto;vertical-align:middle" x-webkit-airplay="allow" webkit-playsinline controls poster="${baseurl}/images/microscope.png" preload="auto" width="360" height="360" data-setup="{}">
	</video>
	<div class="all">
		<div alige="center" class="test" style="padding-left:50px">
			<input type="button" value="" id="btnPlus"> <input type="button" class="watchover" value="结束"> <input type="button" value="" id="btnMinus"> <input type="button" value="close" id="lightbtn" class="but" style="margin-left:28px;color:#fff">
		</div>

	</div>

	<div class="row" style="display:none">
		<input type="text" id="playUrl" placeholder="请输入播放地址" style="width:500px" value="http://pullhls745decb8.live.126.net/live/8ca0aea7da304bdeaa391b6c097945e1/playlist.m3u8" disabled="disabled">
		<button class="button button-primary button-rounded button-tiny" onclick="playNow()">开始播放</button>
	</div>
	<script src="//nos.netease.com/vod163/nep.min.js"></script>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		var testBtnList = document.getElementsByClassName('testBtn');
		videojs.options.flash.swf = "//nos.netease.com/vod163/nep.test.swf"
		var myPlayer = neplayer('my-video', {}, function() {
			console.log('播放器初始化完成');
		});
		var playerTech = videojs("my-video").tech({
			IWillNotUseThisInPlugins : true
		});
		myPlayer.onPlayState(1, function() {
			console.log('play');
		});
		myPlayer.onPlayState(2, function() {
			console.log('pause');
		});
		myPlayer.onPlayState(3, function() {
			console.log('ended')
		});
		myPlayer.onError(function(data) {
			console.log(data)
		});
		for ( var i = testBtnList.length - 1; i >= 0; i--) {
			testBtnList[i].disabled = true;
		}

		$(function() {
			playNow();
		});

		function playNow() {
			var url = document.getElementById('playUrl').value, lowUrl = url.toLowerCase(), urlType = lowUrl.substring(
					0, 4), type;
			if (url === '') {
				alert('请输入播放地址');
				return;
			}
			switch (urlType) {
			case 'http':
				if (lowUrl.indexOf('mp4') !== -1) {
					type = 'video/mp4';
				} else if (lowUrl.indexOf('flv') !== -1) {
					type = 'video/x-flv';
				} else if (lowUrl.indexOf('m3u8') !== -1) {
					type = 'application/x-mpegURL';
				}
				break;
			case 'rtmp':
				type = 'rtmp/flv';
				break;
			// default:
			//     alert('请输入正确的播放地址');
			//     return;
			}
			myPlayer.setDataSource({
				type : type,
				src : url
			});
			myPlayer.play();
			for ( var i = testBtnList.length - 1; i >= 0; i--) {
				testBtnList[i].disabled = false;
			}

		}
	</script>

	<script type="text/javascript">
		//防止页面后退
		history.pushState(null, null, document.URL);
		window.addEventListener('popstate', function() {
			history.pushState(null, null, document.URL);
		});
		var timer;
		var arrive;
		var arriveframe;
		function clear() {
			clearInterval(timer);
			$.post("${baseurl}/control/changeMicrothree", {}, function(data) {
				if (data.status != 200) {
					alert("失败，原因是：" + data.msg);
				}
			});
		}
		function changeOne() {
			$.post("${baseurl}/control/changeMicroone", {}, function(data) {
				if (data.status != 200) {
					alert("失败，原因是：" + data.msg);
				}
			});
		}
		function changeTwo() {
			$.post("${baseurl}/control/changeMicrotwo", {}, function(data) {
				if (data.status != 200) {
					alert("失败，原因是：" + data.msg);
				}
			});
		}
		function change(val) {
			if (val == 1) {
				//如果是正转
				return function() {
					timer = setInterval(function() {
						changeOne();
					}, 600);
				}
			} else if (val == -1) {
				//如果是反转
				return function() {
					timer = setInterval(function() {
						changeTwo();
					}, 600);
				}
			}
		}
		$('#btnPlus').on('mousedown', change(1)).on('mouseup', clear);
		$('#btnMinus').on('mousedown', change(-1)).on('mouseup', clear);

		$('#btnPlus').on('touchstart', change(1)).on('touchend', clear);
		$('#btnMinus').on('touchstart', change(-1)).on('touchend', clear);

		//控制显微镜光源开关
		var lightstatus;
		$('#lightbtn').on('click', function() {
			if ($('#lightbtn').val() == "open") {
				lightstatus = 1;
			} else {
				lightstatus = 0;
			}
			$.post("${baseurl}/control/light", {
				"lightstatus" : lightstatus
			}, function(data) {
				if (data.status == 200) {
					if (data.msg == "close") {
						//关闭显微镜的样式 
						$("#lightbtn").val("close");
						//绿色
						$("#lightbtn").css("background", "url(${baseurl}/images/1.png)");
					} else if (data.msg == "open") {
						//打开显微镜的样式
						$("#lightbtn").val("open");
						//红色
						$("#lightbtn").css("background", "url(${baseurl}/images/0.png)");
					}
				} else {
					alert("操作失败，原因是：" + data.msg);
				}
			});
		});
		var redirectUrl = "${redirect}";
		//如果redirdectUrl是""则让第一显示为红色
		if(redirectUrl==""){
			$(".box1").eq(1).removeClass("box1").addClass("box4");
		}else{
			$(".box1").eq(3).removeClass("box1").addClass("box4");
		}
		var Passage = {
			watchover : function() {
				switch (redirectUrl) {
				case "":
					$.post("${baseurl}/control/checkACCS", {}, function(data) {
						if(data.status==200){
							alert("提交成功请选择培养模式");
							location.href = "${baseurl}/control/chooseMode";
							//location.href = "http://www.keyonecn.com:8081/control/passage/chooseMode";		
						}else if(data.status==400){
							alert("失败，原因是：" + data.msg);
						}
					});
					break;
				case "1":
					alert("提交成功培养瓶返回动作");
					checkend();
					break;
				case "2":
					$.post("${baseurl}/control/digestOver", {}, function(data) {
						if (data.status == 200) {
							alert("消化完成开始传代动作");
							location.href = "${baseurl}/control/chooseId";
							// location.href="http://www.keyonecn.com:8081/control/passage/chooseId";							
						}else{
							alert("失败，原因是：" + data.msg);
						}
					});
					break;
				case "3":
					$.post("${baseurl}/control/mediumChangeOver", {}, function(data) {
						if (data.status == 200) {
							alert("换液体结束返回动作");
							//检测是否返回培养架
							checkend();
						} else {
							alert("失败，原因是：" + data.msg);
						}
					});
					break;
				case "4":
					alert("细胞培养瓶送出");
					break;
				case "5":
					alert("细胞培养瓶丢弃");
					break;
				}

				;
			}
		};

		$(function() {
			$(".watchover").click(function() {
				Passage.watchover();
			});
		});

		//检测培养瓶是否已经返回培养架子=========start
		function clearFrame() {
			clearInterval(arriveframe);
		}
		function checkframe() {
			$.post("${baseurl}/control/arriveFrame", {}, function(data) {
				if (data.status == 400) {
					clearFrame();
					alert("培养瓶到达培养架,换液体结束");
					location.href = "${baseurl}/control/chooseId";
					//location.href = "http://www.keyonecn.com:8081/control/passage/chooseId";
				}else if (data.status == 500) {
					alert(data.msg);
					clearFrame();
				}
			});
		}
		function checkend() {
			arriveframe = setInterval(function() {
				checkframe();
			}, 1000);
		}
		//检测培养瓶是否已经返回培养架子=========end

		//检测培养瓶是否到达显微镜==============start
		function clearMicro() {
			clearInterval(arrive);
		}

		function checkMicro() {
			$.post("${baseurl}/control/arriveMicro", {}, function(data) {
				if (data.status == 400) {
					alert("培养瓶到达显微镜");
					$("#lightbtn").attr("disabled", false);
					$(".watchover").attr("disabled", false);
					$("#btnPlus").attr("disabled", false);
					$("#btnMinus").attr("disabled", false);
					clearMicro();
				}else if (data.status == 500) {
					alert(data.msg);
					clearMicro();
				}
			});
		}
		function check() {
			arrive = setInterval(function() {
				checkMicro();
			}, 1000);
		}

		$(function() {
			check();
		});
		//检测培养瓶是否到达显微镜==============end
	</script>
</body>

</html>



