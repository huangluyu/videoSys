package com.hly.videosys.comment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAddAction extends ActionSupport {
	private String commentContent;
	private String videoNum;
	//for action
	private String device = "pc";
	private String message;

	public String execute()
	{
		String username;
		int authority;
		try{
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			username = (String)session.get("username");
			authority = (Integer)session.get("authority");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(commentContent == null || commentContent.equals(""))
				message = "评论不能为空";
			else {
				if(authority >= 1)
					CommentJdbc.commentAdd(videoNum,commentContent,df.format(new Date()),username,"1");
				else
					message = "登陆后才能评论!";
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(device.equals("mobile"))
		{
			System.out.println("1");
			return "mVideoPlay";
		}
		else
			return "videoPlay";
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	
	public void setCommentContent(String id) {
		this.commentContent = id;
	}
	
	public String getVideoNum() {
		return videoNum;
	}
	
	public void setVideoNum(String id) {
		this.videoNum = id;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
