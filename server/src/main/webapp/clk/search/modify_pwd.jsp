<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/member.css">
  </head>
  <body style="background:#f9f9f9">
  	<div class="container">
		<div class="hader-logo"><img src="images/20151203img1.png" width="333" height="72" alt=""/></div>
	</div>
	<div class="container">
		<div class="login-box">
			<h4 class="login-title">修改密码</h4>
			<form id="queryForm" action="modifyPwd" method="post">
				<div class="regbox">
					<div class="inputbg">
						<span class="login-span"><i class="login-style">*</i>原密码：</span>
						<label class="labelbox" for="">
							<input id="oldpwd" type="password" name="oldpwd" data-type="PH" placeholder="请输入原密码">
						</label>
					</div>
					<div id="oldpwdTip" class="err-tip" style="display:none;">
						<div class="dis_box"><span class="icon-error"></span><span>原密码不能为空</span></div>
					</div>
					<div class="inputbg">
						<span class="login-span"><i class="login-style">*</i>新密码：</span>
						<label class="labelbox" for="">
							<input id="newpwd" type="password" name="newpwd" data-type="PH" placeholder="请输入新密码">
						</label>
					</div>
					<div id="newpwdTip" class="err-tip" style="display:none">
						<div class="dis_box"><span class="icon-error"></span><span>新密码不能为空</span></div>
					</div>
					<div class="inputbg">
						<span class="login-span"><i class="login-style">*</i>确认密码：</span>
						<label class="labelbox" for="">
							<input id="newpwd1" type="password" name="newpwd1" data-type="PH" placeholder="请再次输入密码">
						</label>
					</div>
					<div id="newpwd1Tip" class="err-tip" style="display:none">
						<div class="dis_box"><span class="icon-error"></span><span>两次密码输入必须一致</span></div>
					</div>
					<div>
						<input class="login-btn" type="submit" onclick="return modifyCheck();" value="确定">
					</div>
				</div>
			</form>
		</div>
	</div>
  </body>
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
  	function modifyCheck(){
		if(oldpwdCheck() && newpwdCheck()&&newpwd1Check()){
			return true;
		}
		return false;
	}
  	function oldpwdCheck(){
		var oldpwd = $('#oldpwd').val();
		if(oldpwd == null || oldpwd =="" || oldpwd=="undefined"){
			$('#oldpwdTip').show();
			return false;
		} else {
			$('#oldpwdTip').hide();
			return true;
		}
	}
  	function newpwdCheck(){
		var newpwd = $('#newpwd').val();
		if(newpwd == null || newpwd =="" || newpwd=="undefined"){
			$('#newpwdTip').show();
			return false;
		} else {
			$('#newpwdTip').hide();
			return true;
		}
	}
	function newpwd1Check(){
		var newpwd = $('#newpwd').val();
		var newpwd1 = $('#newpwd1').val();
		if(newpwd1 != newpwd){
			$('#newpwd1Tip').show();
			return false;
		} else {
			$('#newpwd1Tip').hide();
			return true;
		}
	}
  </script>
</html>
