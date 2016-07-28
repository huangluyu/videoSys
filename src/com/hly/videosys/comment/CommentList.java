package com.hly.videosys.comment;

public class CommentList {
	private String videoNum;
	private String videoComment;
	private String commentTime;
	private String commentUser;
	private String commentNum;
	private String commentUserRealName;
	private String isShow;
	private String target;
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public CommentList() {
	}

	public CommentList(String videoNum, String videoComment, String commentTime, String commentUser, String isShow, String target) {
		this.videoNum = videoNum;
		this.videoComment = videoComment;
		this.commentTime = commentTime;
		this.commentUser = commentUser;
		this.isShow = isShow;
		this.target = target;
	}
	
	public String getVideoNum() {
		return videoNum;
	}
	
	public void setVideoNum(String id) {
		this.videoNum = id;
	}
	
	public String getVideoComment() {
		return videoComment;
	}
	
	public void setVideoComment(String id) {
		this.videoComment = id;
	}
	
	public String getCommentTime() {
		return commentTime;
	}
	
	public void setCommentTime(String id) {
		this.commentTime = id;
	}
	
	public String getCommentUser() {
		return commentUser;
	}
	
	public void setCommentUser(String id) {
		this.commentUser = id;
	}
	
	public String getIsShow() {
		return isShow;
	}
	
	public void setIsShow(String id) {
		this.isShow = id;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	public String getCommentUserRealName() {
		return commentUserRealName;
	}

	public void setCommentUserRealName(String commentUserRealName) {
		this.commentUserRealName = commentUserRealName;
	}
}
