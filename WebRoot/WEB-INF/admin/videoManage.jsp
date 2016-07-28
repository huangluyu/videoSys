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
            <li><a href="bootstrap.action">管理中心 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">发布活动</a></li>
            <li><a href="#">留言中心</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="">视频管理</a></li>
            <li><a href="videoWaitVerifyListRead.action">视频审核</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="commentListReadAdmin.action?keyIsShow=1">评论管理</a></li>
            <li><a href="commentListReadAdmin.action?keyIsShow=0">恢复评论</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="userListReadAdmin.action">用户中心</a></li>
            <li><a href="">用户管理</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">视频列表</h2>
          	<form class="form-inline" action="videoList_allVideoList.action" method="post">
          		<div class="form-group">
          			<input name="videoName" value="${model.videoName }" />
          		</div>
          		<div class="form-group">
          			<label for="exampleInputFile">年级:</label>
					<select class="selectpicker" name="videoGrade" id="gradeSearchSelect" data-width="fit">
						<option value="all">全部</option>
					  	<option value="高一">高一</option>
					  	<option value="高二">高二</option>
					  	<option value="高三">高三</option>
					  	<option value="通识">通识</option>
					</select>
				</div>
          		<div class="form-group">
          			<label for="exampleInputFile">科目:</label>
					<select class="selectpicker" name="videoSubject" id="subjectSearchSelect" data-width="fit">
					  	<option value="all">全部</option>
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
				</div>
          		<div class="form-group">
          			<label for="exampleInputFile">教师:</label>
					<select class="selectpicker" name="uploadByUser" id="authorSelect" data-width="fit">
						<option value="all">全部</option>
						<c:forEach items="${request.teacherList }" var="tUserinfo">
							<option value="${tUserinfo.username }">${tUserinfo.realName }</option>
						</c:forEach>
					</select>
				</div>
          		<div class="form-group">
          			<label for="exampleInputFile">第</label>
          			<input type="text" class="form-control" name="page" value="${page }" style="width:3em"/>
          			<label for="exampleInputFile">页,共${pageSum }页</label>
				</div>
				<button type="submit" class="btn btn-primary">检索</button>
			</form>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th align="center"></th>
                  <th align="center">视频作者</th>
                  <th align="center">视频名称</th>
                  <th align="center">上传时间</th>
                  <th align="center">科目年级</th>
                  <th align="center">视频时长</th>
                  <th align="center">审核处理</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${request.videoList }" var="videoinfo" varStatus="status"> 
              		<tr>
              			<td>${status.count }</td>
              			<td>${videoinfo.uploadByUser }</td>
              			<td>${videoinfo.videoName }</td>
              			<td>${videoinfo.uploadTime }</td>
              			<td>${videoinfo.videoGrade }|${videoinfo.videoSubject }</td>
              			<td>${videoinfo.videoLength }秒</td>
              			<td>${videoinfo.videoExamineState }</td>
              			<td><a href="videoPlay?videoNum=${videoinfo.videoNum }">播放</a>&nbsp|&nbsp<a>通过</a>&nbsp|&nbsp<a>拒绝</a></td>
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
