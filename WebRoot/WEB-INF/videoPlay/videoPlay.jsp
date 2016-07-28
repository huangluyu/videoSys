<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:property value="videoName"/></title>
</head>
<link href="http://example.com/path/to/video-js.css" rel="stylesheet">  
<script src="http://example.com/path/to/video.js"></script>  
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script>  
  _V_.options.flash.swf = "http://example.com/path/to/video-js.swf"  
</script> 

<style>
div.commentBase {
	border-left-style:solid;
	border-bottom-style:solid;
	border-right-style:solid;
	border-width:1px;
	max-width:500px;
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	padding: 8px;
}
</style>

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
			window.location.href = "videoDelete?videoNum=" + videoNum + "&videoAuthor=" + videoAuthor;
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
 
<body align="center" onload="message('<s:property value="message"/>')">
	<iframe src="commonFrame" width="930" height="30" frameborder="0"  scrolling="no" allowtransparency="yes" align="center"></iframe>
	<br/>
	<div>
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
	</div>
	<div id="show" style="display:none;">
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
	</div><br/>
	<video id="videoPlay" class="video-js vjs-default-skin" controls preload="auto" 
		width="930" height="520" poster="http://video-js.zencoder.com/oceans-clip.png" 
		data-setup='{"example_option":true}' autoplay="autoplay">    
		<source src="http://202.201.12.118:8080/video/<s:property value="videoUrl"/>" type='video/mp4' />   
	</video><br/><br/><br/>
	<div class="commentBase" style="padding:0px;max-width:516px;"></div>
	
	<div class="commentBase" align="left" style="">
		<strong>评论列表</strong>
	</div>
	<div class="commentBase" align="left" style="max-height:60px;">
		<form action="commentAdd?videoNum=<s:property value="videoNum"/>" method="post">
			<table><tr>
				<td><textarea rows="3" cols="60" name="commentContent"></textarea></td>
				<td><button type="submit" style="width:53px;height:53px;">发表评论</button></td>
			</tr></table>
		</form>
	</div>
	<s:iterator id="comment" value="commentList">
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
	</s:iterator>
</body>
</html>