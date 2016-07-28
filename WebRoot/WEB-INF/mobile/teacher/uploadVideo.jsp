<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  
  <body>
   <div style="max-width: 640px;width:100%;">
    <div data-role="page" id="pageone">
	  <div data-role="header">
	    <div style="float:left;margin:12px 12px"><img src="logo.png"style="max-width:100%"/></div>
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
		<form method="post" action="upload.action" data-ajax="false" enctype="multipart/form-data">
			<input type="file" name="myVideo"></input> 
			*支持格式:asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv
			<input type="text" name="setVideoName" placeholder="请输入视频名字"/>   
			
			<fieldset data-role="controlgroup" data-type="horizontal">
				<label for="高一">高一</label>
				<input type="radio" name="gradeSelect" id="高一" value="高一">
				<label for="高二">高二</label>
				<input type="radio" name="gradeSelect" id="高二" value="高二"> 
				<label for="高三">高三</label>
				<input type="radio" name="gradeSelect" id="高三" value="高三"> 
				<label for="通识">通识</label>
				<input type="radio" name="gradeSelect" id="通识" value="通识" checked> 
			</fieldset>
			
			<select name="subjectSelect">
				<option value="未分类">请选择科目</option>
			  	<option value="语文">语文</option>
			  	<option value="数学">数学</option>
			  	<option value="英语">英语</option>
			  	<option value="生物">生物</option>
			  	<option value="化学">化学</option>
			  	<option value="物理">物理</option>
			  	<option value="政治">政治</option>
			  	<option value="地理">地理</option>
			  	<option value="历史">历史</option>
			</select>
			<input type="submit" name="submit" value="上传视频" />  
		</form>
	  </div>
    </div>
   </div>
  </body>
</html>
