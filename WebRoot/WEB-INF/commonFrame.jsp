<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>这是一个框架</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script type="text/javascript">
	function redirectHref(goals){
		self.parent.location.href=goals;
	}
	
	function error(msg){
		self.parent.alert(msg + "尚未实装!敬请期待!");
	}

	function startTime()
	{
		var today=new Date();
		var h=today.getHours();
		var m=today.getMinutes();
		var s=today.getSeconds();
		// add a zero in front of numbers<10
		m=checkTime(m);
		s=checkTime(s);
		document.getElementById('txt').innerHTML=h+":"+m+":"+s;
		t=setTimeout('startTime()',500);
	}
	
	function checkTime(i)
	{
		if (i<10) 
			{i="0" + i;}
		return i;
	}
  </script>
  
   <script type="text/javascript"> 
</script>
  <body onload="startTime()">
    <div style="float:left">
    	<a href="#" onclick="redirectHref('index')">首页</a>
    	<a href="#" onclick="redirectHref('videoListRead')">视频列表</a>
    	<a href="#" onclick="redirectHref('bootstrap')">bootstrap</a>
    	<a href="#" onclick="redirectHref('mobile')">mobile</a>
    	<span id="txt"></span>
    </div>
    <div style="float:right">
		<c:choose>
			<c:when test="${sessionScope.userinfo.userAuthority == 0 }">   
				欢迎!游客!
    			<a href="login?message=login" target="_top">登陆</a>
    			<a href="index" target="_top" onclick="error('该功能')">注册</a>  
			</c:when>
			<c:when test="${sessionScope.userinfo.userAuthority == 1 }">   
				欢迎学生：${sessionScope.userinfo.realName }
				<a target="_top" href="userManage_logout.action">
					<small>注销</small>
				</a>
				积分:${sessionScope.userinfo.money }
    		</c:when>
			<c:otherwise>
				欢迎老师：${sessionScope.userinfo.realName }
				<a target="_top" href="userManage_logout.action">
					<small>注销</small>
				</a>
				积分:${sessionScope.userinfo.money }
				我的视频<!-- videoListRead?videoAuthor=${sessionScope.userinfo.username }&key=1  -->
				<a href="videoList_myVideoList.action" target="_top">查看</a>·<a target="_top" href="uploadVideo?videoAuthor==${sessionScope.userinfo.username }">上传</a>		
		   </c:otherwise>
		</c:choose>
    </div>
  </body>
</html>
