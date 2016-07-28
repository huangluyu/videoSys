<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>在线视频教学系统登陆</title>
	 
	 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
 	<style>
		.panel{
			text-align:mid;
			margin-left: auto;
		 	margin-right: auto;
		}
	</style> 
</head>

<script>
function login() { 
		$('#false').text("");
		$('#false2').text("");
		$.post( 
      		'servlet/LoginServlet',  
        	{
        	userName:$('#username').val(),
        	userCode:$('#usercode').val()
        	},  
	        function(data){  
		        if(data == "false2"){
		     //   	alert("该用户名尚未注册!");
		        	$('#false2').text("*该用户名尚未注册*");
		        	$('#false').text("");
		        }else if(data == "false")
		        {
		        	$('#false').text("*密码输入错误*");
		        	$('#false2').text("");
		       // 	alert("密码错误!");
		        } else {
		       		window.location.href="index.jsp";
		        }
			}  
		);
	}
	
function message(msg){
	if(GetQueryString("message") == "login");
	else if(msg != "")
		alert(msg);
	else
		alert("该功能需要登录,请登录后再试!");
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)
		return unescape(r[2]);
	return null;
	}
</script>




<body style="TEXT-ALIGN: center" onload="message('<s:property value="message"/>')">

<form action="userManage_login.action" method="post">
	<span style="MARGIN-RIGHT: auto; MARGIN-LEFT: auto;font-family:'STCaiyun';font-size:29px;color:#76becc;'" >在线视频教学系统登陆</span>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="" style="width:300px;padding:30px 45px">
		<div>
			<input name="username" class="easyui-textbox" data-options="prompt:'请输入您的用户名...',validType:'',iconCls:'icon-man',iconWidth:38" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<span id="false2"></span>
		</div>
		
		<div>
			<input name="password" class="easyui-textbox"  type="password" data-options="prompt:'请输入您的密码...',validType:'',iconCls:'icon-lock',iconWidth:38" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<span id="false"></span>
		</div>
		
		<div style="padding:10px 0;" >
			<input type="submit" value="登陆" class="easyui-linkbutton" data-options="plain:true"  style="background-color:#76becc;width:40%;height:32px;"/>
			<a onclick="message('注册暂未实装!敬请期待!')" class="easyui-linkbutton" data-options="plain:true" style="background-color:#76becc;width:30%;height:32px;">注册</a>
			<a onclick="message('找回密码暂未实装!敬请期待!')" style="">找回密码</a>
			<%-- 
			<a href="loginAction?testAccount=test" target="_top"><small><small>以游客身份登录</small></small></a> --%>
		</div>
	</div>
   </form>
</body>
</html>