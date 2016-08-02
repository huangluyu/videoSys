<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico">

    <title>兰州大学MOOC</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
	
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="${pageContext.request.contextPath}/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/assets/js/ie-emulation-modes-warning.js"></script>

  	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  	<style>
	  	img{
			border-radius: 9px;
			-webkit-border-radius: 9px;
			-moz-border-radius: 9px;
		}
		
		.jumbotron{ 
			background-color: #4879bd;
			color: #FFFFFF;
		} 
		
		.title{ 
		    width: 100%;
		    word-break: break-all;
		    text-overflow: ellipsis;
		    display: -webkit-box; /** 对象作为伸缩盒子模型显示 **/
		    -webkit-box-orient: vertical; /** 设置或检索伸缩盒对象的子元素的排列方式 **/
		    -webkit-line-clamp: 2; /** 显示的行数 **/
		    overflow: hidden;  /** 隐藏超出的内容 **/
		}
	</style>
	
  <body>
	<div class="navbar navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="index.jsp">兰州MOOC</a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li class="hidden-sm hidden-md"><a href="index.jsp"  target="_blank">热门视频</a></li>
            <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-hover="dropdown">年级</a>
	          <ul class="dropdown-menu" style="min-width:100px">
	            <li><a href="#">高一</a></li>
	            <li><a href="#">高二</a></li>
	            <li><a href="#">高三</a></li>
	          </ul>
	        </li>
		  </ul>
          <ul id="myUserInfo" style="display:none" class="nav navbar-nav navbar-right hidden-sm">
            <li class="dropdown">
	          <a id="realName" href="#" class="dropdown-toggle" data-hover="dropdown" data-close-others="false" role="button" aria-haspopup="true" aria-expanded="false">用户名 <span class="caret"></span></a>
	          <ul class="dropdown-menu" style="min-width:100px">
	            <li><a href="#" style="color: #337ab7;">个人中心</a></li>
            	<li role="separator" class="divider"></li>
	            <li><a href="userManage_logout.action">退出登录</a></li>
	          </ul>
	        </li>
            <li><a id="money" href="">积分</a></li>
            <li id="videoManage" class="dropdown" style="display:none">
	          <a href="#" class="dropdown-toggle" data-hover="dropdown">我的视频</a>
	          <ul class="dropdown-menu" style="min-width:100px">
	            <li><a href="videoList_myVideoList.action">视频管理</a></li>
	            <li><a href="uploadVideo.action">视频上传</a></li>
	          </ul>
	        </li>
            <li id="adminManage" style="display:none"><a href="admin.action">管理中心</a></li>
          </ul>
          <form id="loginText" style="display:none" class="navbar-form navbar-right hidden-sm" action="userManage_login.action">
          	<input name="username" type="text" class="form-control" placeholder="用户名" />
            <input name="password" type="text" class="form-control" placeholder="密码" />
            <button type="submit" class="btn btn-primary">登录</button>
          </form>
        </div>
      </div>
    </div>

    <div class="jumbotron">
      <div class="container">
        <h1>MOOC兰州</h1>
        <h2 class="title">随时随地，多终端视频教学，让学习更便捷、简单。</h2>
      </div>
    </div>
    
    <div class="container">
    	<!-- 最新视频 -->
    	<div class="row">
    		<c:forEach items="${applicationScope.newList }" var="videoinfo">
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div style="padding:2%">
						<a href="videoPlay?videoNum=${videoinfo.videoNum }">
							<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }" width="100%">
							<span class="title">${videoinfo.videoName }</span><br/>
							<span>${videoinfo.uploadByUser }</span>
							<span style="float:right">播放数:${videoinfo.videoPlayTimes }</span>
						</a>
					</div>
				</div> 
		    </c:forEach>
		</div>
    	<!-- 高一最热视频 -->
    	<div class="row">
		  <div class="col-md-3 col-sm-6 col-xs-6">
		    <div class="thumbnail">
		      <img src="http://202.201.12.118:8080/video/20160702191544792.jpg" alt="...">
		      <div class="caption">
		        <h3>subnautica蓝图介绍</h3>
		        <p>没有介绍</p>
		        <p><a href="#" class="btn btn-primary" role="button">播放</a> <a href="#" class="btn btn-default" role="button">购买</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3 col-sm-6 col-xs-6">
		    <div class="thumbnail">
		      <img src="http://202.201.12.118:8080/video/20160702191544792.jpg" alt="...">
		      <div class="caption">
		        <h3>subnautica蓝图介绍</h3>
		        <p>没有介绍</p>
		        <p><a href="#" class="btn btn-primary" role="button">播放</a> <a href="#" class="btn btn-default" role="button">购买</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3 col-sm-6 col-xs-6">
		    <div class="thumbnail">
		      <img src="http://202.201.12.118:8080/video/20160702191544792.jpg" alt="...">
		      <div class="caption">
		        <h3>subnautica蓝图介绍</h3>
		        <p>没有介绍</p>
		        <p><a href="#" class="btn btn-primary" role="button">播放</a> <a href="#" class="btn btn-default" role="button">购买</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3 col-sm-6 col-xs-6">
		    <div class="thumbnail">
		      <img src="http://202.201.12.118:8080/video/20160702191544792.jpg" alt="...">
		      <div class="caption">
		        <h3>subnautica蓝图介绍</h3>
		        <p>没有介绍</p>
		        <p><a href="#" class="btn btn-primary" role="button">播放</a> <a href="#" class="btn btn-default" role="button">购买</a></p>
		      </div>
		    </div>
		  </div>
		</div>
    	<div class="row">
    		<c:forEach items="${applicationScope.grade1List }" var="videoinfo">
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div style="padding:2%">
						<a href="videoPlay?videoNum=${videoinfo.videoNum }">
							<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }" width="100%">
							<span class="title" >${videoinfo.videoName }</span><br/>
							<span>${videoinfo.uploadByUser }</span>
							<span style="float:right">播放数:${videoinfo.videoPlayTimes }</span>
						</a>
					</div>
				</div> 
		    </c:forEach>
		</div>
    	<!-- 高二最热视频 -->
    	<div class="row">
    		<c:forEach items="${applicationScope.grade2List }" var="videoinfo">
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div style="padding:2%">
						<a href="videoPlay?videoNum=${videoinfo.videoNum }">
							<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }" width="100%">
							<span class="title" >${videoinfo.videoName }</span><br/>
							<span>${videoinfo.uploadByUser }</span>
							<span style="float:right">播放数:${videoinfo.videoPlayTimes }</span>
						</a>
					</div>
				</div> 
		    </c:forEach>
		</div>
    	<!-- 高三最热视频 -->
    	<div class="row">
    		<c:forEach items="${applicationScope.grade3List }" var="videoinfo">
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div style="padding:2%">
						<a href="videoPlay?videoNum=${videoinfo.videoNum }">
							<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }" width="100%">
							<span class="title" >${videoinfo.videoName }</span><br/>
							<span>${videoinfo.uploadByUser }</span>
							<span style="float:right">播放数:${videoinfo.videoPlayTimes }</span>
						</a>
					</div>
				</div> 
		    </c:forEach>
		</div>
	</div>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>

    <script src="${pageContext.request.contextPath}/dist/js/bootstrap.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${pageContext.request.contextPath}/assets/js/vendor/holder.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
	
	<!-- (Optional) Latest compiled and minified JavaScript translation files -->
	<script src="${pageContext.request.contextPath}/js/i18n/defaults-zh_CN.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/assets/js/ie10-viewport-bug-workaround.js"></script>
  
    <script src="${pageContext.request.contextPath}/myjs/loginAjax.js"></script>
  
  </body>
</html>
