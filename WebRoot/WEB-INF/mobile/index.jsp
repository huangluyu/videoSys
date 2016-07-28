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
  
  <body onload="changelie()">
  <style>
  	img{
		border-radius: 9px;
		-webkit-border-radius: 9px;
		-moz-border-radius: 9px;
	}
	
	.title{
	font-size:1.5em;
	font-family:'SimHei';
	padding:0.4em 0em 0.4em 0.2em;
	}
	
	#title2{
	font-size:1em;
	font-family:'Microsoft YaHei';
	margin:10px 0px 10px 0px;
}
  </style>
  <script>
  function changelie(){
  	 var width = $("#l1").width(); 
  	 var div = document.getElementById("l1"); 
  	 if(width > 720){
		div.className = "ui-grid-c"; 
		document.getElementById("s1").className = "ui-block-c"; 
  	 }
  }
  </script>
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
	
	
	<div data-role="main" class="ui-content" style="padding:5px">
		<div style="width:100%;height:200px;background-color:blue;" >
		<div class="swiper-container" id="swiper1">
		    <div class="swiper-wrapper">
		        <div class="swiper-slide"><img src="http://202.201.12.118:8080/video/default/hd1.jpg" style="margin:0 auto;max-height:100%;border-radius: 0px;-webkit-border-radius: 0px;-moz-border-radius: 0px;"/></div>
		        <div class="swiper-slide"><img src="http://202.201.12.118:8080/video/default/hd2.jpg" style="margin:0 auto;max-height:100%"/></div>
		        <div class="swiper-slide"><img src="http://202.201.12.118:8080/video/default/hd3.jpg" style="margin:0 auto;max-height:100%"/></div>
		    </div>
		    <div class="swiper-pagination"></div>
		</div>
		</div>
		<script language="javascript"> 
		var mySwiper = new Swiper('#swiper1',{
		freeMode : false,
		pagination : '.swiper-pagination',
		loop : true,
		//pagination : '#swiper-pagination1',
		})
		</script>
	    <div class="ui-grid-a" id="l1">
	    	<div class="title">最新视频</div>
			<s:iterator id="video" value="videoNewList" status="L">
				<div name="videolist" style="padding:5px" class="ui-block-<s:if test="#L.index == 0">a</s:if><s:elseif test="#L.index == 1">b</s:elseif><s:elseif test="#L.index == 2">a</s:elseif><s:elseif test="#L.index == 3">b</s:elseif>" <s:if test="#L.index == 2">id="s1"</s:if>>
					<a href="videoPlay.action?videoNum=<s:property  value="#video.videoNum" />&device=mobile">
					<div class="ui-grid-solo">
						<div class="ui-block-a">
							<img src="http://202.201.12.118:8080/video/<s:property value="#video.videoUrl"/>.jpg" alt="<s:property value="#video.videoName"/>" style="max-width:100%"/>
						</div>
						<div class="ui-block-a">
							<span style="font:'1rem/1.5 'Microsoft YaHei', 'Droid Sans Fallback', SimHei, Arial, Helvetica, tahoma, sans-serif'"><s:property value="#video.videoName"/></span>
						</div>
					</div>
					<div class="ui-grid-a">
						<div class="ui-block-a">
							<s:property value="#video.videoAuthorName"/>
						</div>
						<div class="ui-block-b" >
							人气:<s:property value="#video.videoPlayTimes" />
						</div>
					</div>
					</a>
				</div>
			</s:iterator>
	    </div>
	    <br>
	    <div>
	    	<span href="#" id="btng1" class="title">高一</span> |
	    	<span href="#" id="btng2" class="title">高二</span> |
	    	<span href="#" id="btng3" class="title">高三</span>
	    </div>
	    <br>
	    <div class="swiper-container" id="swiper2">
		    <div class="swiper-wrapper">
		        <div class="swiper-slide">
		        	<div class="ui-grid-a">
						<s:iterator id="video" value="videoG1NewList" status="L">
							<div name="videolist" style="padding:5px" class="ui-block-<s:if test="#L.index == 0">a</s:if><s:elseif test="#L.index == 1">b</s:elseif><s:elseif test="#L.index == 2">a</s:elseif><s:elseif test="#L.index == 3">b</s:elseif>">
								<a href="videoPlay.action?videoNum=<s:property  value="#video.videoNum" />&device=mobile">
									<div class="ui-grid-solo">
										<div class="ui-block-a">
											<img src="http://202.201.12.118:8080/video/<s:property value="#video.videoUrl"/>.jpg" alt="<s:property value="#video.videoName"/>" style="max-width:100%"/>
										</div>
										<div class="ui-block-a">
											<s:property value="#video.videoName"/>
										</div>
									</div>
									<div class="ui-grid-a">
										<div class="ui-block-a">
											<s:property value="#video.videoAuthorName"/>
										</div>
										<div class="ui-block-b" >
											人气:<s:property value="#video.videoPlayTimes" />
										</div>
									</div>
								</a>
							</div>
						</s:iterator>
				    </div>
			    </div>
		        <div class="swiper-slide">
					<div class="ui-grid-a">
						<s:iterator id="video" value="videoG2NewList" status="L">
							<div name="videolist" style="padding:5px" class="ui-block-<s:if test="#L.index == 0">a</s:if><s:elseif test="#L.index == 1">b</s:elseif><s:elseif test="#L.index == 2">a</s:elseif><s:elseif test="#L.index == 3">b</s:elseif>">
								<a href="videoPlay.action?videoNum=<s:property  value="#video.videoNum" />&device=mobile">
								<div class="ui-grid-solo">
									<div class="ui-block-a">
										<img src="http://202.201.12.118:8080/video/<s:property value="#video.videoUrl"/>.jpg" alt="<s:property value="#video.videoName"/>" style="max-width:100%"/>
									</div>
									<div class="ui-block-a">
										<s:property value="#video.videoName"/>
									</div>
								</div>
								<div class="ui-grid-a">
									<div class="ui-block-a">
										<s:property value="#video.videoAuthorName"/>
									</div>
									<div class="ui-block-b" >
										人气:<s:property value="#video.videoPlayTimes" />
									</div>
								</div>
								</a>
							</div>
						</s:iterator>
				    </div>
			    </div>
		        <div class="swiper-slide">
		        	<div class="ui-grid-a">
						<s:iterator id="video" value="videoG3NewList" status="L">
							<div name="videolist" style="padding:5px" class="ui-block-<s:if test="#L.index == 0">a</s:if><s:elseif test="#L.index == 1">b</s:elseif><s:elseif test="#L.index == 2">a</s:elseif><s:elseif test="#L.index == 3">b</s:elseif>">
								<a href="videoPlay.action?videoNum=<s:property  value="#video.videoNum" />&device=mobile">
								<div class="ui-grid-solo">
									<div class="ui-block-a">
										<img src="http://202.201.12.118:8080/video/<s:property value="#video.videoUrl"/>.jpg" alt="<s:property value="#video.videoName"/>" style="max-width:100%"/>
									</div>
									<div class="ui-block-a">
										<s:property value="#video.videoName"/>
									</div>
								</div>
								<div class="ui-grid-a">
									<div class="ui-block-a">
										<s:property value="#video.videoAuthorName"/>
									</div>
									<div class="ui-block-b" >
										人气:<s:property value="#video.videoPlayTimes" />
									</div>
								</div>
								</a>
							</div>
						</s:iterator>
				    </div>
			    </div>
		    </div>
		</div>
		<script language="javascript"> 
		var mySwiper2 = new Swiper('#swiper2',{
		//pagination : '#swiper-pagination1',
		})
		
		$('#btng1').click(function(){
			mySwiper2.slideTo(0, 1000, false);//切换到第一个slide，速度为1秒
		})
		$('#btng2').click(function(){
			mySwiper2.slideTo(1, 1000, false);//切换到第二个slide，速度为1秒
		})
		$('#btng3').click(function(){
			mySwiper2.slideTo(2, 1000, false);//切换到第三个slide，速度为1秒
		})
		</script>
	    <br>
		<p>免费排行榜</p>
		<ul data-role="listview">
			<s:iterator id="video" value="videoFreeList" status="L">
				<li data-icon="false">
					<a href="videoPlay.action?videoNum=<s:property  value="#video.videoNum" />&device=mobile">
						<span style="float:left"><s:property  value="#L.index + 1" />.<s:property value="#video.videoName"/></span>
						<span class="ui-li-count">1</span>
					</a>
				</li>
			</s:iterator>
		</ul>
		<br>
		<p>付费排行榜</p>
		<ul data-role="listview">
			<s:iterator id="video" value="videoPayList" status="L">
				<li data-icon="false">
					<a href="videoPlay.action?videoNum=<s:property  value="#video.videoNum" />&device=mobile">
						<s:property  value="#L.index + 1" />.<s:property value="#video.videoName"/>
						<span class="ui-li-count">1</span>
					</a>
				</li>
			</s:iterator>
		</ul>
	  </div>
	</div>
	</div>
  		
  </body>
</html>
