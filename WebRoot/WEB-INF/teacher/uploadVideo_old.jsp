<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>欢迎老师!</title>
</head>

<script>
function message(msg){
	if(msg != "")
		alert(msg);
}
</script>

<body onload="message('<s:property value="message"/>')" align="center">
	<div class="big" align="center">
		<h1>视频上传</h1>
		<form action="upload" method="post" enctype="multipart/form-data">
			<label for="setVideoName">请输入要上传文件的文件名:</label>
	      	<input type="text" name="setVideoName" />
			年级:
			<select name="gradeSelect">
				<option value="未分类">年级</option>
			  	<option value="高一">高一</option>
			  	<option value="高二">高二</option>
			  	<option value="高三">高三</option>
			  	<option value="通识">通识</option>
			</select>
			科目:
			<select name="subjectSelect">
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
			</select><br/><br/>
	      	<label for="myVideo">选择需要上传的视频,支持格式:asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv</label>
	      	<input type="file" name="myVideo" />
	      	<input type="submit" value="上传"/>
	   	</form>
	</div>
</body>

</html>

<!--  ../../../uploadFiles/test/ -->