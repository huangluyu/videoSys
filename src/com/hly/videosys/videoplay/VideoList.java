package com.hly.videosys.videoplay;

public class VideoList {
	private String videoName;
	private String videoAuthor;
	private String videoAuthorName;
	private String videoAddTime;
	private String videoTime;
	private String videoPrice;
	private String videoNum;
	private String videoPlayTimes;
	private String grade;
	private String subject;
	private String videoUrl;
	private String examineState;

	public VideoList() {
	}
	
	public VideoList(String videoName, String videoAuthor, String videoAuthorName, String videoAddTime, String videoTime, String videoNum, String grade, String subject, String videoPlayTimes) {
		this.videoName = videoName;
		this.videoAuthor = videoAuthor;
		this.videoAuthorName = videoAuthorName;
		this.videoAddTime = videoAddTime;
		this.videoTime = videoTime;
		this.videoNum = videoNum;
		this.grade = grade;
		this.subject = subject;
		this.videoPlayTimes = videoPlayTimes;
	}
	
	public String getVideoPlayTimes() {
		return videoPlayTimes;
	}

	public void setVideoPlayTimes(String videoPlayTimes) {
		this.videoPlayTimes = videoPlayTimes;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getVideoName() {
		return videoName;
	}
	
	public void setVideoName(String id) {
		this.videoName = id;
	}
	
	public String getVideoAuthor() {
		return videoAuthor;
	}
	
	public void setVideoAuthor(String id) {
		this.videoAuthor = id;
	}
	
	public String getVideoAddTime() {
		return videoAddTime;
	}
	
	public void setVideoAddTime(String id) {
		this.videoAddTime = id;
	}
	
	public String getVideoTime() {
		return videoTime;
	}
	
	public void setVideoTime(String id) {
		this.videoTime = id;
	}
	
	public String getVideoNum() {
		return videoNum;
	}
	
	public void setVideoNum(String id) {
		this.videoNum = id;
	}
	
	public String getVideoAuthorName() {
		return videoAuthorName;
	}

	public void setVideoAuthorName(String videoAuthorName) {
		this.videoAuthorName = videoAuthorName;
	}

	public String getVideoPrice() {
		return videoPrice;
	}

	public void setVideoPrice(String videoPrice) {
		this.videoPrice = videoPrice;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getExamineState() {
		return examineState;
	}

	public void setExamineState(String examineState) {
		this.examineState = examineState;
	}
}
