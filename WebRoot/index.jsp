<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>在线视频教学系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="视频教学,高中,学习">
<meta http-equiv="description" content="兰州大学在线视频教学系统">
</head>

<style>
div.listTitle {
	width:175px;
	height:20px;
	padding: 2px;
}

div.leftBig {
}

div.rightBig {
	width:180px;
	height:390px;
	float:right;
}

div.listCrosswise {
	border-top-style:solid;
	border-width:2px;
	width:720px;
	height:160px;
	padding: 0px;
}

div.big {
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	width:930px;
	height:400px;
}


div.listlengthways {
	border-top-style:solid;
	border-width:2px;
	width:160px;
	height:370px;
	padding: 10px;
}

div.videoList {
	width:160px;
	height:140px;
	/* MARGIN-RIGHT: auto; */
	MARGIN-LEFT: 0px;	
	float:left;
	padding: 10px;
}

</style>

<script type="text/javascript">
function message(msg){
	if(msg != "")
		alert(msg);
}
</script>

<body align="center">
<iframe src="commonFrame" width="930" height="30" frameborder="0"  scrolling="no" allowtransparency="yes" align="center"></iframe>
<h1>在线视频教学系统</h1>
<div class="big">
	<div style="width:725px;height:400px;float:left">
		<div class="listTitle"><span style="float:left">最新视频</span></div>
		<div class="listCrosswise">
		    <c:forEach items="${applicationScope.newList }" var="videoinfo"> 
				<div class="videoList">
					<a href="videoPlay?videoNum=${videoinfo.videoNum }">
						<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }"  width="160" height="100">
						<span style="float:left">${videoinfo.videoName }</span></br>
						<span style="float:left">${videoinfo.uploadByUser }
						&nbsp播放数:${videoinfo.videoPlayTimes }</span>
					</a>
				</div>
		    </c:forEach>
			<%-- <s:iterator id="video" value="videoNewList">
				<div class="videoList">
					<a href="videoPlay?videoNum=<s:property  value="#video.videoNum" />">
						<img src="http://202.201.12.118:8080/video/<s:property value="#video.videoUrl"/>.jpg" alt="<s:property value="#video.videoName"/>"  width="160" height="100">
						<span style="float:left"><s:property value="#video.videoName"/></span></br>
						<span style="float:left"><s:property value="#video.videoAuthorName"/>
						&nbsp播放数:<s:property value="#video.videoPlayTimes" /></span>
					</a>
				</div>
			</s:iterator> --%>
		</div><br/>
		<div class="listTitle"><span style="float:left" >高一</span></div>
		<div class="listCrosswise">
			<c:forEach items="${applicationScope.grade1List }" var="videoinfo"> 
				<div class="videoList">
					<a href="videoPlay?videoNum=${videoinfo.videoNum }">
						<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }"  width="160" height="100">
						<span style="float:left">${videoinfo.videoName }</span></br>
						<span style="float:left">${videoinfo.uploadByUser }
						&nbsp播放数:${videoinfo.videoPlayTimes }</span>
					</a>
				</div>
		    </c:forEach>
		</div><br/>
	</div>
	<div class="rightBig">
		<div class="listTitle"><span style="float:left">免费排行榜</span><span style="float:right">播放数</span></div>
		<div class="listlengthways">
			<%-- <s:iterator id="video" value="videoFreeList" status="L">
				<div style="width:160px;height:20px">
					<a href="videoPlay?videoNum=<s:property  value="#video.videoNum" />">
						<span style="float:left"><s:property  value="#L.index + 1" />.<s:property value="#video.videoName"/></span>
						<span style="float:right"><s:property value="#video.videoPlayTimes"/></span>
					</a>
				</div>
			</s:iterator> --%>
			<c:forEach items="${applicationScope.freeList }" var="videoinfo" varStatus="status"> 
				<div style="width:160px;height:20px">
					<a href="videoPlay?videoNum=${videoinfo.videoNum }">
						<span style="float:left">${status.count}.${videoinfo.videoName }</span>
						<span style="float:right">${videoinfo.videoPlayTimes }</span>
					</a>
				</div>
		    </c:forEach>
		</div>
	</div>
</div>

<div class="big">
	<div style="width:725px;height:400px;float:left">
		<div class="listTitle"><span style="float:left">高二</span></div>
		<div class="listCrosswise">
			<c:forEach items="${applicationScope.grade2List }" var="videoinfo"> 
				<div class="videoList">
					<a href="videoPlay?videoNum=${videoinfo.videoNum }">
						<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }"  width="160" height="100">
						<span style="float:left">${videoinfo.videoName }</span></br>
						<span style="float:left">${videoinfo.uploadByUser }
						&nbsp播放数:${videoinfo.videoPlayTimes }</span>
					</a>
				</div>
		    </c:forEach>
		</div><br/>
		<div class="listTitle"><span style="float:left">高三</span></div>
		<div class="listCrosswise">
			<c:forEach items="${applicationScope.grade3List }" var="videoinfo"> 
				<div class="videoList">
					<a href="videoPlay?videoNum=${videoinfo.videoNum }">
						<img src="http://202.201.12.118:8080/video/${videoinfo.videoUrl }.jpg" alt="${videoinfo.videoName }"  width="160" height="100">
						<span style="float:left">${videoinfo.videoName }</span></br>
						<span style="float:left">${videoinfo.uploadByUser }
						&nbsp播放数:${videoinfo.videoPlayTimes }</span>
					</a>
				</div>
		    </c:forEach>
		</div>
	</div>
	<div class="rightBig">
		<div class="listTitle"><span style="float:left">付费排行榜</span><span style="float:right">播放数</span></div>
		<div class="listlengthways">
			<c:forEach items="${applicationScope.payList }" var="videoinfo" varStatus="status"> 
				<div style="width:160px;height:20px">
					<a href="videoPlay?videoNum=${videoinfo.videoNum }">
						<span style="float:left">${status.count}.${videoinfo.videoName }</span>
						<span style="float:right">${videoinfo.videoPlayTimes }</span>
					</a>
				</div>
		    </c:forEach>
		</div>
	</div>
</div>
</body>
</html>