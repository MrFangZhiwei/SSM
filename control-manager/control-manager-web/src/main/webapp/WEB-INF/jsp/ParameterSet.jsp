<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%--指令元素--%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParameterSetting</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Conflux Hosting Price Table Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script type="application/x-javascript">
    addEventListener("load", function() {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    }
    </script>
<!-- //For-Mobile-Apps -->
<!-- Custom Theme File -->
<link rel="stylesheet" href="${baseurl}/css/style.css" type="text/css" media="all">
<!-- jQuery -->
<script src="${baseurl}/js/jquery.min.js"></script>
<script src="${baseurl}/js/jquery-migrate-1.2.1.js"</script>
<!--Script-->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
</script>
<!--/Script-->
</head>
<body>
	<div class="mfp-bg my-mfp-zoom-in mfp-removing" style="display:none"></div>
	<div class="mfp-wrap mfp-close-btn-in mfp-auto-cursor my-mfp-zoom-in mfp-ready" tabindex="-1" style="top: 0px; position: absolute; height: 735px;display:none;">
		<div class="mfp-container mfp-inline-holder">
			<div class="mfp-content" style="position:absolute;left:0px;top:0px">
				<div id="small-dialog1" class="">
					<div class="pop_up" id="mediumplan" style="display: none">
						<div class="payment-online-form-left">
							<form id="form1" onsubmit="return false;" method="POST">
								<h2>方案</h2>
								<hr style="width:100px">
								<hr style="margin:30px">
								<input type="hidden" name="mplanName" id="sel1name">
								<ul>
									<li><span style="font-size:30px">震荡一</span> <select id="sel1" name="step1" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></li>
								</ul>
								<div style="height:30px"></div>
								<ul>
									<li><span style="font-size:30px">缓冲液</span> <select id="sel2" name="step2" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></li>
								</ul>
								<div style="height:30px"></div>
								<ul>
									<li><span style="font-size:30px">震荡二</span> <select id="sel3" name="step3" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
									</select></li>
								</ul>
								<div style="height:30px"></div>
								<ul>
									<li><span style="font-size:30px">培养液</span> <select id="sel4" name="step4" style="width:45%;margin-left:5px;height:40px;font-size:30px">
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
									</select></li>
								</ul>
								<div style="height:30px"></div>
								<ul>
									<li>
										<div id="mplanname">
											<div>
												<ul>
													<%--设定名称--%>
													<li><span style="font-size:26px">方法名:</span> <input id="mname" style="width:45%;margin-left:-10px;height:40px;font-size:30px;" placeholder="方案名称"  oninput="this.value=this.value.replace(/[^a-zA-Z]+/g, '');">
													</li>
												</ul>
											</div>
										</div></li>
								</ul>
								<div class="clear"></div>
								<h4 class="paymenthead">
									<span class="payment"></span>Parameter Details
								</h4>
								<div class="clear"></div>
								<ul class="payment-sendbtns">
									<li><input type="reset" value="重置"></li>
									<li><a class="order mtijiao">保存</a>
									</li>
								</ul>
								<div class="clear"></div>
							</form>
						</div>
					</div>

					<div class="pop_up" id="transferplan" style="display: none">
						<div class="payment-online-form-left">
							<form id="form2" action="http://www.keyonecn.com/control1/test/paramSetting2.action" method="POST">
								<input type="hidden" name="tplanName" id="tsel1name">
								<ul>
									<li><span style="font-size:30px">震荡</span> <select id="select1" name="step1" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">缓冲</span> <select id="select2" name="step2" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">22</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">震荡</span> <select id="select3" name="step3" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">消化</span> <select id="select4" name="step4" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">22</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">加热</span> <select id="select5" name="step5" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">培养</span> <select id="select6" name="step6" style="width:45%;margin-left:5px;height:40px;font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">吹打</span> <select id="select7" name="step7" style="width:45%;margin-left:5px;height:40px;font-size:30px">
											<option value="1">mode1</option>
											<option value="2">mode2</option>
											<option value="3">mode3</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">转速</span> <select id="select8" name="step8" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1000">1000</option>
											<option value="1200">1200</option>
											<option value="1300">1300</option>
											<option value="1400">1400</option>
											<option value="1500">1500</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">时间</span> <select id="select9" name="step9" style="width:45%;margin-left:5px;height:40px; font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">22</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">培养</span> <select id="select10" name="step10" style="width:45%;margin-left:5px;height:40px;font-size:30px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></li>
								</ul>
								<ul>
									<li><span style="font-size:30px">吹打</span> <select id="select11" name="step11" style="width:45%;margin-left:5px;height:40px;font-size:30px">
											<option value="1">mode1</option>
											<option value="2">mode2</option>
											<option value="3">mode3</option>
									</select></li>
								</ul>
								<div style="height:10px"></div>
								<ul>
									<li>
										<div id="tplanname">
											<div>
												<ul>
													<%--设定方案名称--%>
													<li><span style="font-size:26px">方法名:</span> <input id="tname" style="width:45%;margin-left:-10px;height:40px;font-size:30px;" placeholder="方案名称"  oninput="this.value=this.value.replace(/[^a-zA-Z]+/g, '');">
													</li>
												</ul>
											</div>
										</div></li>
								</ul>
								<div class="clear"></div>
								<h4 class="paymenthead">
									<span class="payment"></span>Parameter Details
								</h4>
								<div class="clear"></div>
								<ul class="payment-sendbtns">
									<li><input type="reset" value="重置"></li>
									<li><a class="order ptijiao">保存</a>
									</li>
								</ul>
								<div class="clear"></div>
							</form>

						</div>
					</div>
					<button title="Close (Esc)" type="button" class="mfp-close">×</button>
				</div>
			</div>
		</div>
	</div>
	<h1>换液室操作参数设置中心</h1>
	<div class="container">
		<div class="grid1">
			<form id="shezhi1" action="http://www.keyonecn.com/control1/index.jsp" method="post">
				<span>换液/<small>方案</small> </span>
				<h2>方案中心</h2>
				<div class="param">
					<c:forEach items="${mlist}" var="name">
						<p>
							<input  name="Szhproj1" type="radio" value="1"><a class="popup-with-zoom-anim mya mediumplan" style="display:inline-block;width:63%;height:20px">${name.mplanName}<a style="display:inline-block;width:20px;height:20px;background:url(${baseurl}/images/update.png) no-repeat  center;cursor: pointer;" class="mbtnUpdate"></a><a style="display:inline-block;width:20px;height:20px;margin-left: 16px;background:url(${baseurl}/images/delete.png) no-repeat center;cursor: pointer;" class="mbtnDelete"></a>
							</a>
						</p>
					</c:forEach>
				</div>
				<div class="sign text-center">
					<a class="popup-with-zoom-anim" id="msure" style="cursor:pointer">确定方案</a> 
					<a class="popup-with-zoom-anim" id="setting" style="cursor:pointer;margin-top: 10px">设置方案</a>
				</div>
			</form>
			<script type="text/javascript">
			 //防止页面后退
			 history.pushState(null, null, document.URL);
			 window.addEventListener('popstate', function () {
			   history.pushState(null, null, document.URL);
			 });
			<%--以数字开头--%>
			var reg=/^\d+/;
				//页面dom载入时
				//是显示传代方案还是换液方案
				$(function() {
					var mode="${mode}";
					//如果是换液模式
					if(mode=="3"){
						$(".grid3").css("display","none");
					}else if(mode=="2"){
					//如果是传代模式
						$(".grid1").css("display","none");
					}
					var flag;
					$(".mbtnUpdate").live("click",
							function() {
								$("#mplanname").addClass("mfp-hide");
								flag = true;
								var mediumPlanName = $(this).prev().text();
								//提交换液方案的请求
								$.post("${baseurl}/control/plan/mediumdetail", {
									"mediumPlanName" : mediumPlanName
								}, function(data) {
									//换液方案的弹窗显示
									//幕布弹出
									$(".mfp-bg.my-mfp-zoom-in.mfp-removing").removeClass("mfp-removing").addClass(
											"mfp-ready").css("display", "block");
									//换液方案显示
									$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready").css(
											"display", "block");
									$("#mediumplan").css("display", "block");
									$("#transferplan").css("display", "none");
									$("#sel1name").val(mediumPlanName);
									$("#sel1").val(data.step1);
									$("#sel2").val(data.step2);
									$("#sel3").val(data.step3);
									$("#sel4").val(data.step4);
								});
							});

					$(".mfp-close").click(
							function() {
								$(".mfp-bg.my-mfp-zoom-in.mfp-ready").removeClass("mfp-ready").addClass("mfp-removing")
										.css("display", "none");
								;
								$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready").css("display",
										"none");
								$("#mediumplan").css("display", "block");
								$("#transferplan").css("display", "none");
							});

					//表单提交
					$(".order.mtijiao").click(
							function() {
								if (flag) {
									//方案修改
									$.post("${baseurl}/control/plan/updatemediumdetail", $("#form1").serialize(), function(data) {
										if (data.status == 200) {
											$(".mfp-bg.my-mfp-zoom-in.mfp-ready").removeClass("mfp-ready").addClass(
											"mfp-removing").css("display", "none");
									;
									$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready")
											.css("display", "none");
										} else {
											alert("修改失败，原因是：" + data.msg);
										}
									});
								} else {
									var mediumPlanName = $("#mname").val();
									if(mediumPlanName==""){
									alert("方案名字不能为空");
								}else{
									if(reg.test(mediumPlanName)){
										alert("方案名字不能以数字开头");
									}else{
										$("#sel1name").val(mediumPlanName);
										//方案增加
										$.post("${baseurl}/control/plan/createmediumplan", $("#form1").serialize(), function(data) {
											if (data.status == 200) {
												alert("创建成功！");
												$(".mfp-bg.my-mfp-zoom-in.mfp-ready").removeClass("mfp-ready").addClass(
														"mfp-removing").css("display", "none");
												;
												$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready")
														.css("display", "none");
												$(".param").append(
											"<p> <input name='Szhproj1' type='radio' value='1'><a class='popup-with-zoom-anim mya mediumplan' style='display:inline-block;width:63%;height:20px'>"+mediumPlanName+"<a style='display:inline-block;width:20px;height:20px;background:url(/images/update.png) no-repeat  center;cursor: pointer;' class='mbtnUpdate'></a><a style='display:inline-block;width:20px;height:20px;margin-left: 16px;background:url(/images/delete.png) no-repeat center;cursor: pointer;' class='mbtnDelete'></a></a></p>");
												//window.location.reload();
											} else {
												alert("创建失败，原因是：" + data.msg);
											}
										});
									}
								}
								}
							});
					//设置方案事件
					$("#setting").click(
							function() {
								flag = false;
								$("#mplanname").removeClass("mfp-hide");

								//换液方案的弹窗显示
								//幕布弹出
								$(".mfp-bg.my-mfp-zoom-in.mfp-removing").removeClass("mfp-removing").addClass(
										"mfp-ready").css("display", "block");
								//换液方案显示
								$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready").css("display",
										"block");
								$("#mediumplan").css("display", "block");
								$("#transferplan").css("display", "none");
							});
					//删除事件
					$(".mbtnDelete").live("click",function() {
						var statu = confirm("确定删除改方案?");
						if (!statu) {
							return false;
						}
						//换液方案删除
						var mediumPlanName = $(this).prev().prev().text();
						var me=$(this);
						$.post("${baseurl}/control/plan/deletemediumplan", {
							"mediumPlanName" : mediumPlanName
						}, function(data) {
							if (data.status == 200) {
								me.parent().remove();
								 //页面刷新
								//window.location.reload();
							} else {
								alert("删除失败，原因是：" + data.msg);
							}
						});
					});
					//方案提交
					$("#msure").click(function(){
						if($("input:checked").length==0){
							alert("请选择一个换液方案");
						}else{
							var mediumPlanName=$("input:checked").eq(0).next().text();
							$.post("${baseurl}/control/plan/dealMediumPlan", {"mediumPlanName":mediumPlanName}, function(data) {
								if (data.status==200) {
									location.href = "${baseurl}/control/watch";
								}else if(data.status==400){
									alert("失败，原因是：" + data.msg);
								}
							});
							//location.href = "${baseurl}/control/plan/dealMediumPlan/"+mediumPlanName;
						}
						
					});
					//双击取消单选按钮
					$("input[type='radio']").live("dblclick",function () {      
			            this.checked = false;
					});
					
				});
			
			</script>
			<%--	传代的js代码--%>
			<script type="text/javascript">
				//页面dom载入时
				$(function() {
					var flag;
					$(".tbtnUpdate").live("click",
							function() {
								flag = true;
								var transferPlanName = $(this).prev().text();
								//隐藏掉方法名字
								$("#tplanname").addClass("mfp-hide");
								//提交换液方案的请求
								$.post("${baseurl}/control/plan/transferdetail", {
									"transferPlanName" : transferPlanName
								}, function(data) {
									//换液方案的弹窗显示
									//幕布弹出
									$(".mfp-bg.my-mfp-zoom-in.mfp-removing").removeClass("mfp-removing").addClass(
											"mfp-ready").css("display", "block");
									$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready").css(
											"display", "block");
									$("#mediumplan").css("display", "none");
									$("#transferplan").css("display", "block");
									//换液方案显示
									$("#tsel1name").val(transferPlanName);
									$("#select1").val(data.step1);
									$("#select2").val(data.step2);
									$("#select3").val(data.step3);
									$("#select4").val(data.step4);
									$("#select5").val(data.step5);
									$("#select6").val(data.step6);
									$("#select7").val(data.step7);
									$("#select8").val(data.step8);
									$("#select9").val(data.step9);
									$("#select10").val(data.step10);
									$("#select11").val(data.step11);
								});
							});

					$(".mfp-close").click(
							function() {
								$(".mfp-bg.my-mfp-zoom-in.mfp-ready").removeClass("mfp-ready").addClass("mfp-removing")
										.css("display", "none");
								;
								$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready").css("display",
										"none");
								$("#mediumplan").css("display", "none");
								$("#transferplan").css("display", "none");
							});

					//表单提交
					$(".ptijiao.order").click(
							function() {
								if (flag) {
									$.post("${baseurl}/control/plan/updatetransferdetail", $("#form2").serialize(),
											function(data) {
												if (data.status == 200) {
													$(".mfp-bg.my-mfp-zoom-in.mfp-ready").removeClass("mfp-ready").addClass(
													"mfp-removing").css("display", "none");
											;
											$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready")
													.css("display", "none");
												} else {
													alert("修改失败，原因是：" + data.msg);
												}
											});
								} else {
									var transferPlanName = $("#tname").val();
									if(transferPlanName==""){
										alert("方案名字不能为空");
									}else{
										if(reg.test(transferPlanName)){
											alert("方案名字不能以数字开头");
										}else{
										$("#tsel1name").val(transferPlanName);
										//方案增加
										$.post("${baseurl}/control/plan/createtransferplan", $("#form2").serialize(), function(data) {
											if (data.status == 200) {
												alert("创建成功！");
												$(".mfp-bg.my-mfp-zoom-in.mfp-ready").removeClass("mfp-ready").addClass(
														"mfp-removing").css("display", "none");
												;
												$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready")
														.css("display", "none");
												
												$(".parat").append(
														"<p> <input name='Szhproj1' type='radio' value='1'><a class='popup-with-zoom-anim mya transferplan' style='display:inline-block;width:63%;height:20px'>"+transferPlanName+"<a style='display:inline-block;width:20px;height:20px;background:url(/images/update.png) no-repeat  center;cursor: pointer;' class='tbtnUpdate'></a><a style='display:inline-block;width:20px;height:20px;margin-left: 16px;background:url(/images/delete.png) no-repeat center;cursor: pointer;' class='tbtnDelete'></a></a></p>");
															//window.location.reload();
											} else {
												alert("创建失败，原因是：" + data.msg);
											}
										});
									}
									}
								
								}

							});

					//设置方案事件
					$("#tsetting").click(
							function() {
								flag = false;
								$("#tplanname").removeClass("mfp-hide");
								//换液方案的弹窗显示
								//幕布弹出
								$(".mfp-bg.my-mfp-zoom-in.mfp-removing").removeClass("mfp-removing").addClass(
										"mfp-ready").css("display", "block");
								//换液方案显示
								$(".mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.my-mfp-zoom-in.mfp-ready").css("display",
										"block");
								$("#mediumplan").css("display", "none");
								$("#transferplan").css("display", "block");
							});

					//删除事件
					$(".tbtnDelete").live("click",function() {
						var statu = confirm("确定删除改方案?");
						if (!statu) {
							return false;
						}
						//传代方案删除
						var transferPlanName = $(this).prev().prev().text();
						var me=$(this);
						$.post("${baseurl}/control/plan/deletetransferplan", {
							"transferPlanName" : transferPlanName
						}, function(data) {
							if (data.status == 200) {
								me.parent().remove();
								 //页面刷新
								 //window.location.reload();
							} else {
								alert("删除失败，原因是：" + data.msg);
							}
						});
					});
					
					//方案提交
					$("#tsure").click(function(){
						if($("input:checked").length==0){
							alert("请选择一个传代方案");
						}else{
							var transferPlanName=$("input:checked").eq(0).next().text();
							$.post("${baseurl}/control/plan/dealTransferPlan", {"transferPlanName":transferPlanName}, function(data) {
								if (data.status==200) {
									location.href = "${baseurl}/control/watch";
								}else if(data.status==400){
									alert("失败，原因是：" + data.msg);
								}
							});
							//location.href = "${baseurl}/control/plan/dealTransferPlan/"+transferPlanName;
						}
						
					});
				});
			</script>
		</div>
		<div class="grid3">
			<form id="shezhi2" action="" method="post">
				<span>传代/<small>方案</small> </span>
				<h2>方案中心</h2>
				<div class="parat">
					<c:forEach items="${tlist}" var="name">
						<p>
							<input name="Szhproj1" type="radio" value="1" ><a class="popup-with-zoom-anim mya transferplan" style="display:inline-block;width:63%;height:20px">${name.tplanName}<a style="display:inline-block;width:20px;height:20px;background:url(${baseurl}/images/update.png) no-repeat center;cursor: pointer;" class="tbtnUpdate"></a><a style="display:inline-block;width:20px;height:20px;margin-left: 16px;background:url(${baseurl}/images/delete.png) no-repeat center;cursor: pointer;" class="tbtnDelete"></a>
							</a>
						</p>
					</c:forEach>
				</div>
				<div class="sign text-center">
					<a class="popup-with-zoom-anim" id="tsure" style="cursor:pointer">确定方案</a> 
					<a class="popup-with-zoom-anim" id="tsetting" style="cursor:pointer;margin-top: 10px">设置方案</a>
				</div>
			</form>
		</div>
		<div class="clear"></div>
		<script type="text/javascript">
			
		</script>
	</div>
	<!--pop-up-grid-->
	<script src="${baseurl}/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});

		});
	</script>

	<div id="popup">
		<!-- 添加表单1开始 -->
		<div id="small-dialog1" class="mfp-hide"></div>
		<!-- 添加表单1结束 -->
		<!-- 添加表单2开始 -->
		<div class="mfp-hide"></div>
		<!-- 添加表单2结束 -->
	</div>
	<button title="Close (Esc)" type="button" class="mfp-close">×</button>
	<!--pop-up-grid-->
	<div class="footer">
		<p>
			@<a href="http://www.keyonecn.com/">杭州键一生物科技有限公司</a>浙ICP备13015208号
		</p>
	</div>

</body>

</html>
