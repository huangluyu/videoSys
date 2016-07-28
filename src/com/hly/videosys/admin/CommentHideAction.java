package com.hly.videosys.admin;

import com.opensymphony.xwork2.ActionSupport;

public class CommentHideAction extends ActionSupport {
	private String commentNum;
	private String isShow;
	//for action
	private String message;
	
	public String execute() throws Exception {
		int key = AdminJdbc.commentShowSet(commentNum, isShow);
		if(isShow.equals("0"))
		{
			message = "该评论已被删除!";
			return "manage";
		}
		else
		{
			message = "该评论已被恢复!";
			return "verifyDelete";
		}
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
