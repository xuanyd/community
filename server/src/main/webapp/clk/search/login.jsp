<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
  <head>
  	<base href="<%=basePath%>">
  	<meta charset="utf-8">
    <title>心电图信息查询</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/member.css">
  </head>
  <body style="background:#f9f9f9">
	<div class="container">
		<div class="hader-logo"><img src="images/20151203img1.png" width="333" height="72" alt=""/></div>
	</div>
	<div class="container">
		<div class="login-box">
			<h4 class="login-title">心电图查询</h4>
			<form id="queryForm" action="login.html" method="post">
				<div class="regbox">
					<div class="inputbg">
						<span class="login-span"><i class="login-style">*</i>姓名：</span>
						<label class="labelbox" for="">
							<input id="name" type="text" name="name" data-type="PH" placeholder="请输入姓名">
						</label>
					</div>
					<div id="nameCheck" class="err-tip" style="display:none;">
						<div class="dis_box"><span class="icon-error"></span><span>请输入姓名</span></div>
					</div>
					<div class="inputbg">
						<span class="login-span"><i class="login-style">*</i>性别：</span>
						<label id="sex_lb_0" class="pi-radio checked" for="" onclick="selectChange(0)">
							<span class="pi-radio-icon"></span>
							<input id="sex_check_0" type="radio" name="sex" value="男" checked="checked">男
						</label>
						<label id="sex_lb_1" class="pi-radio" for="" onclick="selectChange(1)">
							<span class="pi-radio-icon"></span>
							<input id="sex_check_1" type="radio" name="sex" value="女">女
						</label>
					</div>
					<div class="inputbg">
						<span class="login-span"><i class="login-style">*</i>密码：</span>
						<label class="labelbox" for="">
							<input id="userStr" type="password" name="namestr" data-type="PH" placeholder="初始密码：123456（进入可修改）">
						</label>
					</div>
					<div id="userStrCheck" class="err-tip" style="display:none;">
						<div class="dis_box"><span class="icon-error"></span><span>请输入密码</span></div>
					</div>
					<!-- <div class="inputbg">
						<span class="login-span">身份证号：</span>
						<label class="labelbox" for="">
							<input type="text" name="cardid" data-type="PH" placeholder="请输入身份证号">
						</label>
					</div> -->
					<!-- <div class="inputbg inputcode">
						<span class="login-span"><i class="login-style">*</i>验证码：</span>
					  <label class="labelbox" for="">
						<input class="code" type="text" name="icode" autocomplete="off" placeholder="图片验证码">
					  </label>
					 <img src="images/20151116img3.gif" class="chkcode-img" title="看不清换一张" width="125" height="42" alt="图片验证码"/>
					</div> -->
					<div>
						<div><input class="login-btn" type="submit" onclick="return loginCheck();" value="登录"></div>
						<div style="float: right"><a href="admin/index"  style="margin:left;text-decoration:underline;">专家管理</a></div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<script src="js/jquery.min.1.8.1.js"></script>
<script src="js/jquery.placeholder.js"></script>
<script type="text/javascript">
	$(function(){
		$('input, textarea').placeholder();
		var alertMsg = '${alertMsg}';
		if(alertMsg != null && alertMsg != 'undefiled' && alertMsg != ""){
			alert(alertMsg);
		}
	});
	function loginCheck(){
		if(userNameCheck() && userStrCheck()){
			return true;
		}
		return false;
	}
	
	function userNameCheck(){
		var name = $('#name').val();
		if(name == null || name =="" || name=="undefined"){
			$('#nameCheck').show();
			return false;
		} else {
			$('#nameCheck').hide();
			return true;
		}
	}

	function userStrCheck(){
		var name = $('#userStr').val();
		if(name == null || name =="" || name=="undefined"){
			$('#userStrCheck').show();
			return false;
		} else {
			$('#userStrCheck').hide();
			return true;
		}
	}
	
	function selectChange(idx){
		if(idx == 0){
			$('#sex_check_0').attr("checked","checked");
			$('#sex_check_1').removeAttr("checked");
			$('#sex_lb_0').addClass("checked");
			$('#sex_lb_1').removeClass("checked");
		} else {
			$('#sex_check_1').attr("checked","checked");
			$('#sex_check_0').removeAttr("checked");
			$('#sex_lb_1').addClass("checked");
			$('#sex_lb_0').removeClass("checked");
		}
	}
</script>