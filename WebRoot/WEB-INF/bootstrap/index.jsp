<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="${pageContext.request.contextPath}/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/assets/js/ie-emulation-modes-warning.js"></script>


	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.action">兰州大学MOOC</a>
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
    </nav>

<div class="container-fluid">
	<div class="col-md-2 col-xs-0"></div>
	<div class="col-md-8 col-xs-12">
	<div class="row-fluid" style="margin:0 -30px 0 -30px">
		<div class="col-md-8 col-xs-12">
			<div class="page-header">
				<h1>视频标题
					<small>很长很长的视频简介会如何显示?</small>
				</h1>
				<h5>主页>>高一>>数学
				<span class="label label-primary">等差数列</span>
				</h5>
			</div>
		</div>
		<div class="col-md-4 hidden-xs">
			<div class="row-fluid" style="margin:40px 0 20px ">
				<div class="col-md-4 col-xs-4">
					<a href="#" class="pull-left">
						<img class="img-responsive" src="http://202.201.12.118:8080/video/default/head1.png" alt='' />
					</a>
				</div>
				<div class="col-md-8 col-xs-8">
					<h4 class="media-heading">
						绽琨
					</h4> 请
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
				<h5>张三:</h5>
				<h6>我做了很多事</h6>
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
						</h6> 请
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
						</h6> 请
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
						</h6> 请
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	<div class="col-md-2 col-xs-0"></div>
</div>
	<script>
	$(".classname img").addClass("carousel-inner img-responsive img-rounded");
	</script>
	<script>
	$(window).load(function() {
		var img=$("#input").parent().find('img').width();
		var all=$("#input").parent().parent().width();
		$("#input").width(all-img);
		alert("${username}");
    });
	
	</script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${pageContext.request.contextPath}/assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
