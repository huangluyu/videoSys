package com.hly.videosys.index;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hly.videosys.common.CommonJdbc;
import com.hly.videosys.videoplay.VideoJdbc;
import com.hly.videosys.videoplay.VideoList;
import com.opensymphony.xwork2.ActionSupport;

public class MobileIndexAction extends ActionSupport  {
	private List videoFreeList = new ArrayList();
	private List videoPayList = new ArrayList();
	private List videoNewList = new ArrayList();
	private List videoG1NewList = new ArrayList();
	private List videoG2NewList = new ArrayList();
	private List videoG3NewList = new ArrayList();
	
	public String execute() throws Exception {
		//VideoList vlist = new VideoList();
		ResultSet rs = IndexJdbc.getVideoFreeList();
		putResultSet2List(rs,videoFreeList);
		rs = IndexJdbc.getVideoPayList();
		putResultSet2List(rs,videoPayList);
		rs = IndexJdbc.getVideoNewList();
		putResultSet2List(rs,videoNewList);
		rs = IndexJdbc.getVideoGradeNewList("高一");
		putResultSet2List(rs,videoG1NewList);
		rs = IndexJdbc.getVideoGradeNewList("高二");
		putResultSet2List(rs,videoG2NewList);
		rs = IndexJdbc.getVideoGradeNewList("高三");
		putResultSet2List(rs,videoG3NewList);
		return SUCCESS;
	}

	void putResultSet2List(ResultSet rs,List list) throws SQLException, Exception{
		while(rs.next())
		{
			VideoList vlist = new VideoList();
            vlist.setVideoName(rs.getString("videoName"));
            vlist.setVideoAuthor(rs.getString("uploadByUser"));
            vlist.setVideoAuthorName(CommonJdbc.getRealName(rs.getString("uploadByUser")));
            vlist.setVideoAddTime(rs.getString("uploadTime"));
            vlist.setVideoTime(rs.getInt("videoLength")/60 + "分" + rs.getInt("videoLength")%60);
            vlist.setVideoNum(rs.getString("videoNum"));
            vlist.setVideoPlayTimes(rs.getString("videoPlayTimes"));
            vlist.setGrade(rs.getString("videoGrade"));
            vlist.setSubject(rs.getString("videoSubject"));
            vlist.setVideoUrl(rs.getString("videoUrl"));
            list.add(vlist);
		}
	}
	
	public List getVideoFreeList() {
		return videoFreeList;
	}

	public void setVideoFreeList(List videoFreeList) {
		this.videoFreeList = videoFreeList;
	}

	public List getVideoPayList() {
		return videoPayList;
	}

	public void setVideoPayList(List videoPayList) {
		this.videoPayList = videoPayList;
	}

	public List getVideoNewList() {
		return videoNewList;
	}

	public void setVideoNewList(List videoNewList) {
		this.videoNewList = videoNewList;
	}

	public List getVideoG1NewList() {
		return videoG1NewList;
	}

	public void setVideoG1NewList(List videoG1NewList) {
		this.videoG1NewList = videoG1NewList;
	}

	public List getVideoG2NewList() {
		return videoG2NewList;
	}

	public void setVideoG2NewList(List videoG2NewList) {
		this.videoG2NewList = videoG2NewList;
	}

	public List getVideoG3NewList() {
		return videoG3NewList;
	}

	public void setVideoG3NewList(List videoG3NewList) {
		this.videoG3NewList = videoG3NewList;
	}
}
