package com.hly.videosys2.entity;

/**
 * Videoinfo entity. @author MyEclipse Persistence Tools
 */

public class Videoinfo implements java.io.Serializable {

	// Fields

	private Integer videoNum;
	private String videoName;
	private String videoSize;
	private String videoLength;
	private String uploadTime;
	private String videoUrl;
	private String videoPrice;
	private String uploadByUser;
	private String videoGrade;
	private String videoSubject;
	private Integer videoPlayTimes;
	private String videoExamineState;
	private String videoUploadInfo;

	// Constructors

	/** default constructor */
	public Videoinfo() {
	}

	/** full constructor */
	public Videoinfo(String videoName, String videoSize, String videoLength,
			String uploadTime, String videoUrl, String videoPrice,
			String uploadByUser, String videoGrade, String videoSubject,
			Integer videoPlayTimes, String videoExamineState,
			String videoUploadInfo) {
		this.videoName = videoName;
		this.videoSize = videoSize;
		this.videoLength = videoLength;
		this.uploadTime = uploadTime;
		this.videoUrl = videoUrl;
		this.videoPrice = videoPrice;
		this.uploadByUser = uploadByUser;
		this.videoGrade = videoGrade;
		this.videoSubject = videoSubject;
		this.videoPlayTimes = videoPlayTimes;
		this.videoExamineState = videoExamineState;
		this.videoUploadInfo = videoUploadInfo;
	}

	// Property accessors

	public Integer getVideoNum() {
		return this.videoNum;
	}

	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
	}

	public String getVideoName() {
		return this.videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoSize() {
		return this.videoSize;
	}

	public void setVideoSize(String videoSize) {
		this.videoSize = videoSize;
	}

	public String getVideoLength() {
		return this.videoLength;
	}

	public void setVideoLength(String videoLength) {
		this.videoLength = videoLength;
	}

	public String getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoPrice() {
		return this.videoPrice;
	}

	public void setVideoPrice(String videoPrice) {
		this.videoPrice = videoPrice;
	}

	public String getUploadByUser() {
		return this.uploadByUser;
	}

	public void setUploadByUser(String uploadByUser) {
		this.uploadByUser = uploadByUser;
	}

	public String getVideoGrade() {
		return this.videoGrade;
	}

	public void setVideoGrade(String videoGrade) {
		this.videoGrade = videoGrade;
	}

	public String getVideoSubject() {
		return this.videoSubject;
	}

	public void setVideoSubject(String videoSubject) {
		this.videoSubject = videoSubject;
	}

	public Integer getVideoPlayTimes() {
		return this.videoPlayTimes;
	}

	public void setVideoPlayTimes(Integer videoPlayTimes) {
		this.videoPlayTimes = videoPlayTimes;
	}

	public String getVideoExamineState() {
		return this.videoExamineState;
	}

	public void setVideoExamineState(String videoExamineState) {
		this.videoExamineState = videoExamineState;
	}

	public String getVideoUploadInfo() {
		return this.videoUploadInfo;
	}

	public void setVideoUploadInfo(String videoUploadInfo) {
		this.videoUploadInfo = videoUploadInfo;
	}

}