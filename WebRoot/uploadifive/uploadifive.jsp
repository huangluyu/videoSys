<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="">
<link href="uploadifive.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="jquery.uploadifive.js"></script>
</head>
<body>
	<div id="fileQueue"></div>
	<input type="file" name="uploadifive" id="uploadifive" />
    <p>
        <a href="javascript:void(0);" onclick="startUpload()">开始上传</a>&nbsp;
		<a href="javascript:void(0);" onclick="cancelUpload()">取消所有上传</a>
	</p>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$('#uploadifive').uploadifive({
		    'auto' : false,
		    'uploadScript' : "<%=basePath%>/uploadify/uploadFile.jsp",
		    'fileObjName' : 'upload',
		    'buttonText' : '上传照片',
		    'queueID' : 'fileQueue',
		    'fileType' : 'image/*',
		    'multi' : false,
		    'fileSizeLimit'   : 5242880,
		    'uploadLimit' : 2,
		    'queueSizeLimit'  : 10,   
		    onUploadComplete : function(file, data) {
		      	alert(file.name +" - "+ data);
		    },
		    onCancel : function(file) {
		      	$data	= $(this).data('uploadifive'),
		      	settings = $data.settings;
		      	settings.uploadLimit++;
		      	alert(file.name + " 已取消上传~!");
		    },
		    onFallback : function() {
		      	alert("该浏览器无法使用!");
		    },
		    onUpload : function(file) {
		    
		    },
	});
	
});

function startUpload(){
	$('#uploadifive').uploadifive('upload');
}
function cancelUpload(){
	$('#uploadifive').uploadifive('clearQueue');
}


</script>

</html>