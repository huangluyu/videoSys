<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>欢迎老师!</title>
</head>

<style>
div.big {
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	width:930px;
	height:400px;
}
</style>

<script>
function message(msg){
	if(msg != "")
		alert(msg);
}
</script>

<body onload="message('<s:property value="message"/>')">
	<div align="center"><iframe src="commonFrame" width="930" height="30" frameborder="0"  scrolling="no" allowtransparency="yes"></iframe></div>
	<div class="big" align="center">
		<h1><s:property value="videoAuthorName"/>的视频主页</h1>
		<a href="tVideoListRead?videoAuthor=<s:property value="videoAuthor"/>">刷新视频列表</a><br><br/>
		<table>
			<tr>
				<th>视频标题</th>
				<th>年级</th>
				<th>科目</th>
				<th>上传时间</th>
				<th>时长</th>
			<s:iterator id="video" value="videoList">
				<tr>
					<td align="center">&nbsp<s:property value="#video.videoName"/>&nbsp</td>
					<td align="center"><s:property value="#video.grade"/></td>
					<td align="center"><s:property value="#video.subject"/></td>
					<td align="center">&nbsp<s:property value="#video.videoAddTime"/>&nbsp</td>
					<td align="center"><s:property value="#video.videoTime" />秒</td>
					<td align="center">&nbsp<a href="videoPlay?videoNum=<s:property  value="#video.videoNum" />">播放</a></td>
					<td align="center">
						<s:if test="#video.videoPrice == 0">
							免费
						</s:if>
						<s:else>
							<a href="pay?videoNum=<s:property  value="#video.videoNum" />">购买</a>
						</s:else>
					</td>
					<td align="center">
						<s:if test="#video.videoPrice != 0">
							<small>花费<s:property  value="#video.videoPrice" />积分</small>
						</s:if>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>

<script>
function videoDelete(videoNum,videoAuthor,videoName){
	var r = confirm("您确认进行删除操作吗?该操作不可撤销,将删除该视频及其有关的所有记录!点击确认继续删除操作,点击取消返回.");
	if (r == true)
	{
		var username = prompt("请验证您的用户名来删除视频" + "\"" + videoName + "\"","在此输入您的用户名");
		
		if (username == videoAuthor)
		{
			window.location.href = "videoDelete?videoNum=" + videoNum;
		} else 
		{
			alert("用户名验证出错,取消删除!");
		}
	}
}

function videoUpdate(videoNum,videoAuthor,videoName){
	var newName = prompt("请输入您的视频" + "\"" + videoName + "\"的新标题:","");

	window.location.href = "videoInfoUpdate?videoNum=" + videoNum + "&newName=" + newName + "&videoAuthor=" + videoAuthor;
}
</script>
</html>