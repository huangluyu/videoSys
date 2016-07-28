<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>欢迎学生!</title>
</head>

<style>
div.videoList {
	width:160px;
	height:150px;
	/* MARGIN-RIGHT: auto; */
	MARGIN-LEFT: 10px;	
	float:left;
	padding: 0px;
}


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
		<h1>视频列表</h1>
		<a href="videoListRead" style="align:left">刷新视频列表</a>
		<a href="http://localhost:8080/VideoClass/VideoPlay.jsp">播放本地视频</a>
		筛选:&nbsp<select name="gradeSearchSelect" id="gradeSelect" onChange="select(this.value,subjectSelect.value,authorSelect.value)">
				<option value="all">年级</option>
				<option value="g1">高一</option>
			  	<option value="g2">高二</option>
			  	<option value="g3">高三</option>
			  	<option value="common">通用</option>
			</select>
			<select name="subjectSearchSelect" id="subjectSelect" onChange="select(gradeSelect.value,this.value,authorSelect.value)">
			  	<option value="all">科目</option>
			  	<option value="s1">语文</option>
			  	<option value="s2">数学</option>
			  	<option value="s3">英语</option>
			  	<option value="s4">生物</option>
			  	<option value="s5">化学</option>
			  	<option value="s6">物理</option>
			  	<option value="s7">政治</option>
			  	<option value="s8">地理</option>
			  	<option value="s9">历史</option>
			</select>
			<select name="authorSelect" id="authorSelect" onChange="select(gradeSelect.value,subjectSelect.value,this.value)">
				<option value="all">教师</option> 
				<s:iterator id="author" value="authorList">
					<option value="<s:property value="#author.authorName"/>"><s:property value="#author.authorName"/></option>
				</s:iterator>
			</select><br/><br/>
		<table id="tb">
			<tr>
				<th>视频标题</th>
				<th>年级</th>
				<th>科目</th>
				<th>讲解老师</th>
				<th>上传时间</th>
				<th>时长</th>
				<th>播放数</th>
			</tr>
			<s:iterator id="video" value="videoList">
				<tr>
					<td align="center">&nbsp<s:property value="#video.videoName"/>&nbsp</td>
					<td align="center"><s:property value="#video.grade"/></td>
					<td align="center"><s:property value="#video.subject"/></td>
					<td align="center">&nbsp<s:property value="#video.videoAuthorName"/>&nbsp</td>
					<td align="center"><s:property value="#video.videoAddTime"/></td>
					<td align="center">&nbsp<s:property value="#video.videoTime" />秒&nbsp</td>
					<td align="center">&nbsp<s:property value="#video.videoPlayTimes" />&nbsp</td>
					<td align="center">
						<a href="videoPlay?videoNum=<s:property  value="#video.videoNum" />">播放</a>
						<s:if test="#video.videoPrice != 0"></s:if>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>

<script>
function select(gradeSelect,subjectSelect,authorSelect){
	var tb = document.getElementById("tb");  //根据id找到这个表格
    var rows = tb.rows;               //取得这个table下的所有行
    for(var i=1;i<rows.length;i++)//循环遍历所有的tr行
    {
		var grade = rows[i].cells[1].innerHTML;//获取某行下面的某个td元素
		var subject = rows[i].cells[2].innerHTML;
		var author = rows[i].cells[3].innerHTML;
		if(GradeSelect(gradeSelect,grade) && SubjectSelect(subjectSelect,subject) && AuthorSelect("&nbsp;" + authorSelect + "&nbsp;",author))		
			rows[i].style.display = "";
		else
			rows[i].style.display = "none";
    }
}

function GradeSelect(gradeSelect,grade){
	if(gradeSelect == "g1" && grade != "高一")
		return false;
	else if(gradeSelect == "g2" && grade != "高二")
		return false;
	else if(gradeSelect == "g3" && grade != "高三")
		return false;
	else
		return true;
}


function SubjectSelect(subjectSelect,subject){
	if(subjectSelect == "s1" && subject != "语文")
		return false;
	else if(subjectSelect == "s2" && subject != "数学")
		return false;
	else if(subjectSelect == "s3" && subject != "英语")
		return false;
	else if(subjectSelect == "s4" && subject != "生物")
		return false;
	else if(subjectSelect == "s5" && subject != "化学")
		return false;
	else if(subjectSelect == "s6" && subject != "物理")
		return false;
	else if(subjectSelect == "s7" && subject != "政治")
		return false;
	else if(subjectSelect == "s8" && subject != "地理")
		return false;
	else if(subjectSelect == "s9" && subject != "历史")
		return false;
	else
		return true;
}

function AuthorSelect(authorSelect,author){
	if(authorSelect == author || authorSelect == "&nbsp;all&nbsp;")
		return true;
	else
		return false;
}
</script>
</html>