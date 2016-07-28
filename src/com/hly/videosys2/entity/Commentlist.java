package com.hly.videosys2.entity;

/**
 * Commentlist entity. @author MyEclipse Persistence Tools
 */

public class Commentlist implements java.io.Serializable {

	// Fields

	private Integer commentNum;
	private String videoNum;
	private String commentContent;
	private String commentTime;
	private String commentByUser;
	private String commentShowSet;
	private String commentTarget;

	// Constructors

	/** default constructor */
	public Commentlist() {
	}

	/** full constructor */
	public Commentlist(String videoNum, String commentContent,
			String commentTime, String commentByUser, String commentShowSet,
			String commentTarget) {
		this.videoNum = videoNum;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentByUser = commentByUser;
		this.commentShowSet = commentShowSet;
		this.commentTarget = commentTarget;
	}

	// Property accessors

	public Integer getCommentNum() {
		return this.commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public String getVideoNum() {
		return this.videoNum;
	}

	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentByUser() {
		return this.commentByUser;
	}

	public void setCommentByUser(String commentByUser) {
		this.commentByUser = commentByUser;
	}

	public String getCommentShowSet() {
		return this.commentShowSet;
	}

	public void setCommentShowSet(String commentShowSet) {
		this.commentShowSet = commentShowSet;
	}

	public String getCommentTarget() {
		return this.commentTarget;
	}

	public void setCommentTarget(String commentTarget) {
		this.commentTarget = commentTarget;
	}

}