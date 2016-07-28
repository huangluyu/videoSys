package com.hly.videosys.comment;

import com.hly.videosys.admin.AdminJdbc;
import com.opensymphony.xwork2.ActionSupport;

public class CommentDeleteAction extends ActionSupport {
	private String commentNum;
	
	public String execute()
	{
		try {
			AdminJdbc.commentDelete(commentNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
}
