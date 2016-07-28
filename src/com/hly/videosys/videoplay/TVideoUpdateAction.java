package com.hly.videosys.videoplay;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class TVideoUpdateAction extends ActionSupport {

	private String videoNum;
	private String videoNewName;
	private String gradeSelect;
	private String subjectSelect;
	private int newPrice;
	private String isShow;
	//for action result
	private String videoAuthor;
	private String message;
	
	public String execute() throws Exception {
		System.out.println("videoNum:" + videoNum + "grade:" + gradeSelect + "subject:" + subjectSelect);
		ResultSet rs = VideoJdbc.videoRead(videoNum);
		if(rs.next())
		{
			if(videoNewName == null || videoNewName.equals(""))
				videoNewName = rs.getString("视频名称");
			if(gradeSelect == null || gradeSelect.equals(""))
				gradeSelect = rs.getString("视频年级");
			if(subjectSelect == null || subjectSelect.equals(""))
				subjectSelect = rs.getString("视频科目");
			if(isShow == null)
				newPrice = -1;
			else if(newPrice < 0)
				newPrice = rs.getInt("视频价格");
			VideoJdbc.updateVideoInfo(videoNum,videoNewName,gradeSelect,subjectSelect,newPrice);
			message = "信息修改成功!";
			return SUCCESS;
		} else {
			message = "无法找到该视频!请联系管理员!";
			return ERROR;
		}
	}
	
	public String getVideoAuthor() {
		return videoAuthor;
	}

	public void setVideoAuthor(String id) {
		this.videoAuthor = id;
	}

	public String getVideoNum() {
		return videoNum;
	}
	
	public void setVideoNum(String id) {
		this.videoNum = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGradeSelect() {
		return gradeSelect;
	}

	public void setGradeSelect(String gradeSelect) {
		this.gradeSelect = gradeSelect;
	}

	public String getSubjectSelect() {
		return subjectSelect;
	}

	public void setSubjectSelect(String subjectSelect) {
		this.subjectSelect = subjectSelect;
	}

	public int getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getVideoNewName() {
		return videoNewName;
	}

	public void setVideoNewName(String videoNewName) {
		this.videoNewName = videoNewName;
	}
}
