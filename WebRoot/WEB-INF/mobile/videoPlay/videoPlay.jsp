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

<script type="text/javascript">
function showdiv(oldName,oldGrade,oldSubject,oldPrice){
	if($("#show").css("display")=='none'){//如果show是隐藏的
		$("#show").css("display","block");//show的display属性设置为block（显示）
		//document.getElementById("s1").selectedIndex = 1;
		$("#gradeSelect option[value='"+ oldGrade + "'] ").attr("selected",true);
		$("#subjectSelect option[value='" + oldSubject + "'] ").attr("selected",true);
		$("#newName").val(oldName);
		if(oldPrice == "-1"){
			$("#newPrice").val("0");
		} else{
			$("#setCanRead:checkbox").attr("checked",true);
			$("#newPrice").val(oldPrice);
		}
	}else{//如果show是显示的
		$("#show").css("display","none");//show的display属性设置为none（隐藏）
	}
}

function videoDelete(videoNum,videoAuthor,videoName){
	var r = confirm("您确认进行删除操作吗?该操作不可撤销,将删除该视频及其有关的所有记录!点击确认继续删除操作,点击取消返回.");
	if (r == true) {
		var username = prompt("请验证您的用户名来删除视频" + "\"" + videoName + "\"","");
		if(username == null);
		else if (username == videoAuthor) {
			window.location.href = "videoDelete?videoNum=" + videoNum;
		} else {
			alert("用户名验证出错,取消删除!");
		}
	}
}

function message(msg){
	if(msg != "")
		alert(msg);
}

function error(msg){
  	self.parent.alert(msg + "尚未实装!敬请期待!");
  }
</script>
 
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
  <style>
  #content{
  width:100%;
  float:left;
  height:1.5em;
  margin-right:-6em;
  
  white-space:nowrap;
  overflow: hidden;
  text-overflow:ellipsis;
  }
  
  #content_inner{
  font-size:1.3em;
  height:1.5em;
  font-family:'SimHei';
  margin-right:6em;
  }
  
  #side{
  padding-top:0.5em;
  width:5em;
  height:1.5em;
  background:#f9f9f9;
  float:right;
  text-align:right;
  font-size:0.8em;
  font-family:'Microsoft YaHei';
  }
  </style>
  
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
	
	
	<div data-role="main" class="ui-content" style="padding: 0em;">
<%-- 	<div>
		<s:iterator id="videoInfo" value="videoInfo">
			<strong style="font-size:40px;"><s:property value="#videoInfo.videoName"/></strong>&nbsp
			<s:property value="#videoInfo.grade"/>·<s:property value="#videoInfo.subject"/>&nbsp
			<em>讲解教师:<s:property value="#videoInfo.videoAuthorName"/></em>&nbsp
			<small>播放量:<s:property value="#videoInfo.videoPlayTimes"/>&nbsp
			上传时间<s:property value="#videoInfo.videoAddTime"/></small>
			<s:if test="#videoInfo.videoAuthor == username">
				<a onclick="showdiv('<s:property value="#videoInfo.videoName"/>',
					'<s:property value="#videoInfo.grade"/>',
					'<s:property value="#videoInfo.subject"/>',
					'<s:property value="#videoInfo.videoPrice"/>')" href="#">修改视频信息</a>
				<a onclick="videoDelete(<s:property  value="videoNum" />,
						'<s:property value="videoAuthor"/>',
						'<s:property value="#videoInfo.videoName"/>')" href="#"><small>删除该视频</small></a>
			</s:if>
		</s:iterator>
	</div> --%>
	<s:iterator id="videoInfo" value="videoInfo">
		<div id="content">
			<div id="content_inner"><s:property value="#videoInfo.videoName"/></div>
		</div>
		<div id="side"><s:property value="#videoInfo.grade"/>·<s:property value="#videoInfo.subject"/></div>
	
	</s:iterator>
<%-- 	<div id="show" style="display:none;">
		<form action="videoInfoUpdate?videoNum=<s:property value="videoNum"/>" method="post">
			<table style="" align="center"><tr>
				<td>修改名字:<input type="text" name="newName" id="newName"/></td>
				<td>年级:<select name="gradeSelect" id="gradeSelect">
					<option value="未分类">年级</option>
				  	<option value="高一">高一</option>
				  	<option value="高二">高二</option>
				  	<option value="高三">高三</option>
				  	<option value="通识">通识</option>
				</select></td>
				<td>科目:<select name="subjectSelect" id="subjectSelect">
					<option value="未分类">未分类</option>
				  	<option value="语文">语文</option>
				  	<option value="数学">数学</option>
				  	<option value="英语">英语</option>
				  	<option value="生物">生物</option>
				  	<option value="化学">化学</option>
				  	<option value="物理">物理</option>
				  	<option value="政治">政治</option>
				  	<option value="地理">地理</option>
				  	<option value="历史">历史</option>
				</select></td>
	　　　		<td><input type="checkbox" name="setCanRead" value="yes" id="setCanRead"/>设置公开</td>
				<td>价格:<input style="width:30px" type="text" name="newPrice" id="newPrice"/></td>
				<td><input type="submit" value="提交更改"/></td>
				<td></td>
			</tr></table>
		</form>
	</div> --%>
		<video id="videoPlay" class="video-js vjs-default-skin" controls preload="auto" 
			width="100%" poster="http://video-js.zencoder.com/oceans-clip.png" 
			data-setup='{"example_option":true}' autoplay="autoplay">    
			<source src="http://202.201.12.118:8080/video/<s:property value="videoUrl"/>" type='video/mp4' />   
		</video>
		
		<div style="padding:0.5em;padding-top:0em">
		<s:iterator id="videoInfo" value="videoInfo">
		<ul data-role="listview" data-inset="true">
			<li>
				<a href="#">
				<img src="http://202.201.12.118:8080/video/default/head1.png">
				<h2><s:property value="#videoInfo.videoAuthorName"/>老师</h2><span class="ui-li-count">更多</span></a>
			</li>
		</ul>
		
		</s:iterator>
		<div class="commentBase" align="left">
			<form action="commentAdd.action?videoNum=<s:property value="videoNum"/>&device=mobile" method="post">
					<textarea rows="3" cols="60" name="commentContent"></textarea>
					<button type="submit">发表评论</button>
			</form>
		</div>
		
		<ul data-role="listview" data-inset="true">
		<s:iterator id="comment" value="commentList" status="L">
			<li>
				<s:property value="#comment.videoComment"/><br/>
				<s:property value="#comment.commentUser"/><s:property value="#comment.commentTime"/>
			</li>
		</s:iterator>
		</ul>
		<%-- <s:iterator id="comment" value="commentList">
			<div class="commentBase" align="left" style="border-bottom-style:dashed;">
				<s:property value="#comment.videoComment"/><br/>
			</div>
			<div class="commentBase" align="left">
				<em>留言人:<s:property value="#comment.commentUser"/></em>
				<s:if test="#videoInfo.videoAuthor == username">
					<small><a onclick="error('该功能')" href="#">禁言</a></small>
				</s:if>&nbsp
				<small>发表于:<s:property value="#comment.commentTime"/></small>
				<s:if test="#videoInfo.videoAuthor == username">
					<small><a onclick="error('该功能')" href="#">隐藏评论</a>
					<a onclick="error('该功能')" href="#">删除</a></small>
				</s:if>
			</div>
		</s:iterator> --%>
	</div>
	</div>
	</div>
	</div>
</body>
</html>