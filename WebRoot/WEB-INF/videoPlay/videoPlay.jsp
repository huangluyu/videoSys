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

	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
    
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
	
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
.navbar-inverse {
  background-color: #4879bd;
}

</style>

  <body>
	<div class="navbar navbar-inverse navbar-fixed-top">
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
            <li class="hidden-sm hidden-md"><a href="index.jsp"  target="_blank">导航1</a></li>
            <li class=""><a href="index.jsp" target="_blank">导航2</a></li>
            <li class=""><a href="index.jsp" target="_blank">导航3</a></li>
		  </ul>
		  <ul class="nav navbar-nav navbar-right hidden-sm">
            <li><a id="realName" href="">用户名</a></li>
            <li><a id="money" href="">积分</a></li>
            <li><a href="">关于</a></li>
          </ul>
        </div>
      </div>
    </div>
    
<%--     <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.action">兰州MOOC</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">仪表盘</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="搜索...">
          </form>
        </div>
      </div>
    </nav> --%>

<div class="container projects">
	<div class="row-fluid" style="margin:0 -30px 0 -30px">
		<div class="col-md-8 col-xs-12">
			<div class="page-header">
				<h1>${requestScope.videoinfo.videoName}
					<small>很长很长的视频简介会如何显示?</small>
				</h1>
				<h5>主页>>${requestScope.videoinfo.videoGrade}>>${requestScope.videoinfo.videoSubject}
				<span class="label label-primary">等差数列</span>
				</h5>
			</div>
		</div>
		<div class="col-md-4 hidden-xs">
			<div class="row-fluid hidden-sm" style="margin:40px 0 20px ">
				<div class="col-md-4 col-xs-4">
					<a href="#" class="pull-left">
						<img class="img-responsive" src="http://202.201.12.118:8080/video/default/head1.png" alt='' />
					</a>
				</div>
				<div class="col-md-8 col-xs-8">
					<h4 class="media-heading">
						${requestScope.videoinfo.uploadByUser}
					</h4> 个人简介
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid" style="margin:0 -30px 0 -30px">
		<div class="col-md-8">
			<video id="videoPlay" class="video-js vjs-default-skin" controls preload="auto" 
				width="100%" height="100%" poster="http://video-js.zencoder.com/oceans-clip.png" 
				data-setup='{"example_option":true}' autoplay="autoplay">    
				<source src="http://202.201.12.118:8080/video/20160702164041104.mp4" type='video/mp4' />   
			</video>
			<div class="page-header">
				<h3>留言列表:</h3>
			</div>
			<div style="border-bottom: 1px solid #eee;">
				<c:forEach items="${requestScope.commentList}" var="commentinfo">
				<h5>${commentinfo.commentByUser}:</h5>
				<h6>${commentinfo.commentContent}</h6>
				</c:forEach>
			</div>
			<div style="margin:20px 0 10px">
				<img style="max-width:80px;max-height:80px" src="http://202.201.12.118:8080/video/default/head1.png"/>
				<div style="float:right;width:300px" id="input">
					<textarea  class="form-control" rows="3"></textarea>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row" style="margin:5px">
				<div class="col-md-6 col-xs-6" style="padding:0">
					<a href="#" class="pull-left"><img src="http://202.201.12.118:8080/video/default/hd1.jpg" class="media-object img-responsive" alt='' /></a>
				</div>
				<div class="col-md-6 col-xs-6">
					<div class="media-body">
						<h6 class="media-heading">
							等差数列 高一|数学
						</h6> 视频简介1
					</div>
				</div>
			</div>
			<div class="row" style="margin:5px">
				<div class="col-md-6 col-xs-6" style="padding:0">
					<a href="#" class="pull-left"><img src="http://202.201.12.118:8080/video/default/hd2.jpg" class="media-object img-responsive" alt='' /></a>
				</div>
				<div class="col-md-6 col-xs-6">
					<div class="media-body">
						<h6 class="media-heading">
							等差数列 高一|数学
						</h6> 视频简介2
					</div>
				</div>
			</div>
			<div class="row" style="margin:5px">
				<div class="col-md-6 col-xs-6" style="padding:0">
					<a href="#" class="pull-left"><img src="http://202.201.12.118:8080/video/default/hd3.jpg" class="media-object img-responsive" alt='' /></a>
				</div>
				<div class="col-md-6 col-xs-6">
					<div class="media-body">
						<h6 class="media-heading">
							等差数列 高一|数学
						</h6> 视频简介3
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
    
    <script src="${pageContext.request.contextPath}/myjs/loginAjax.js"></script>
    
    <script src="${pageContext.request.contextPath}/dist/js/bootstrap.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${pageContext.request.contextPath}/assets/js/vendor/holder.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
	
	<!-- (Optional) Latest compiled and minified JavaScript translation files -->
	<script src="${pageContext.request.contextPath}/js/i18n/defaults-zh_CN.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/assets/js/ie10-viewport-bug-workaround.js"></script>
    
	
	
  </body>
</html>
