package com.hly.videosys.videoplay;

import java.io.File;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class TVideoDeleteAction extends ActionSupport {

	private String videoNum;
	//for action
	private String videoAuthor;
	private String message;
	
	public String execute() throws Exception {
		//删除文件
		ResultSet rs = VideoJdbc.videoListRead();
		String videoPath = "../webapps/VideoClass/";
		String photoPath = "../webapps/VideoClass/";
		while(rs.next())
		{//最蠢的查询方法,待修改
			if(rs.getString("视频编号").equals(videoNum))
				videoPath += rs.getString("视频地址") + ".mp4";
				photoPath += rs.getString("视频地址") + ".jpg";
		}
	    File videofile = new File(videoPath);  
	    File photofile = new File(photoPath);  
	    	//路径为文件且不为空则进行删除  
	    if (photofile.isFile() && photofile.exists()) {  
	    	photofile.delete();  
	        System.out.println("缩略图删除成功");
	    } if (videofile.isFile() && videofile.exists()) {  
	    	videofile.delete();  
	        System.out.println("视频删除成功");
	    } 
	    //删除数据库
		VideoJdbc.videoDelete(videoNum);
		message = "视频删除成功!";
		return SUCCESS;
	}
	
	public String getVideoNum() {
		return videoNum;
	}
	
	public void setVideoNum(String id) {
		this.videoNum = id;
	}

	public String getVideoAuthor() {
		return videoAuthor;
	}

	public void setVideoAuthor(String videoAuthor) {
		this.videoAuthor = videoAuthor;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
