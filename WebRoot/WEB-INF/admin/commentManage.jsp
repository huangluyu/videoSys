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
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="admin.action">管理中心 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">发布活动</a></li>
            <li><a href="#">留言中心</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="videoList_allVideoList.action">视频管理</a></li>
            <li><a href="videoList_adminVerifyVideoList.action">视频审核</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="">评论管理</a></li>
            <li><a href="commentManage_getAdminCommentDeleteList.action">恢复评论</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="userListReadAdmin.action">用户中心</a></li>
            <li><a href="">用户管理</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        
          <h2 class="sub-header">评论列表</h2>
          	<form class="form-inline" action="commentManage_getAdminCommentList.action" methor="post">
          		<input type="hidden" name="keyIsShow" value="1" />
          		<div class="form-group">
					<label for="exampleInputEmail1">用户名:</label>
					<input type="text" class="form-control" name="commentByUser" placeholder="" style="width:10em">
				</div>
          		<div class="form-group">
					<label for="exampleInputEmail1">视频编号:</label>
					<input type="text" class="form-control" name="videoNum" placeholder="" style="width:5em">
				</div>
          		<div class="form-group">
          			<label for="exampleInputFile">第</label>
          			<input type="text" class="form-control" name="page" placeholder="" style="width:3em">
          			<label for="exampleInputFile">页,共<s:property value="pageSum"/>页</label>
				</div>
				<button type="submit" class="btn btn-primary">检索</button>
			</form>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th align="center">编号</th>
                  <th align="center">留言人</th>
                  <th align="center">用户名</th>
                  <th align="center">留言内容</th>
                  <th align="center">留言时间</th>
                  <th align="center">视频编号</th>
                  <th align="center">管理操作</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${request.commentList }" var="commentList">
					<tr>
              			<td>${commentList.commentNum }</td>
              			<td>${commentList.commentTarget }</td>
              			<td>${commentList.commentByUser }</td>
              			<td>${commentList.commentContent }</td>
              			<td>${commentList.commentTime }</td>
              			<td>${commentList.videoNum }&nbsp(<a href="videoPlay?videoNum=${commentList.videoNum }">播放</a>)</td>
              			<td>
              				<a href="commentManage_commentHide.action?commentNum=${commentList.commentNum }">
              					<button type="button" class="btn btn-primary btn-xs btn-danger">删除</button>
              				</a>&nbsp|&nbsp<a>禁言</a>
           				</td>
              		</tr>
              	</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
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
  </body>
</html>
