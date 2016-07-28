<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>兰州高中在线视频教学网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/swiper/swiper-3.3.1.min.css">
	
<script>
$(document).bind("mobileinit", function() {
		// disable ajax nav
		$.mobile.ajaxEnabled=false
	});
</script>
	<!-- meta使用viewport以确保页面可自由缩放 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 引入 jQuery Mobile 样式 -->
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<!-- 引入 jQuery 库 -->
	<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
	<!-- 引入 jQuery Mobile 库 -->
	<script src="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/swiper/swiper-3.3.1.min.js"></script>
  </head>
  
  <style>
  @media all and (min-width: 800px) {
  #nav {
    width: 300px;
    float: left;
    margin-right: 20px;
  }
  #grid {
    width: 450px;
    float: left;
  }
}

@media all and (max-width: 799px) {
  #nav {
    width: 100%;
  }
  #grid {
    width: 100%;
  }
}
  </style>
  
  <body>
  <div style="max-width: 640px;width:100%;">
    <div data-role="page" id="pageone">
	  <div data-role="header">
		<a href="index.action" class="ui-btn ui-btn-icon-left" data-ajax="false"><img src="logo.png" style="max-width:100%;margin:-4px"/></a>
		<h1>欢迎访问我的主页</h1>
		<a href="#" class="ui-btn ui-icon-search ui-btn-icon-left">搜索</a>
	    <div data-role="navbar">
	      <ul>
	        <li><a href="mobile.action">主页</a></li>
	        <li><a href="#">科目</a></li>
	        <li><a href="#">排行</a></li>
	        <li><a href="personInfo.action?device=mobile">我的</a></li>
	      </ul>
	    </div>
	  </div>
	
	
	<div data-role="main" class="ui-content">
		<ul data-role="listview" data-inset="true">
			<li><a href="#">
				<img src="http://202.201.12.118:8080/video/default/head1.png">
				<h2><s:property value="realName"/>
					<s:if test="info == 'teacher'">
						老师
					</s:if>
				</h2>
				<p>积分:<s:if test="info == 'visitor'">--</s:if><s:else><s:property value="money"/></s:else></p></a>
			</li>
			<li><a href="#"><h2>查看我的视频</h2></a></li>
			<li><a href="#"><h2>查看我的 </h2></a></li>
		</ul>
		<s:if test="info == 'teacher'">
			<a href="uploadVideoM.action"><input type="button" data-inline="false" value="上传视频"></a>
		</s:if>
		
		<s:if test="info == 'visitor'">
			<a href="mlogin.action"><input type="button" data-inline="false" value="登录"></a>
		</s:if>
		<s:else>
			<a href="loginOut.action"><input type="button" data-inline="false" value="注销"></a>
		</s:else>
	</div>
</div>
</div>
</body>
</html>
