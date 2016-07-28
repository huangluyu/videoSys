package com.hly.videosys.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hly.videosys.common.CommonJdbc;
import com.hly.videosys.videoplay.VideoList;
import com.opensymphony.xwork2.ActionSupport;

public class VideoVerifyListReadAction extends ActionSupport {
	private List tVideoWaitVerifyList = new ArrayList();
	
	public String execute() throws Exception {
		ResultSet rs = AdminJdbc.tVideoWaitVerify();
		while(rs.next()){
			if(!rs.getString("视频价格").equals("-2"))
			{
	            VideoList vlist = new VideoList();
	            vlist.setVideoName(rs.getString("视频名称"));
	            vlist.setVideoAuthor(CommonJdbc.getRealName(rs.getString("上传者")));
	            vlist.setVideoAddTime(rs.getString("上传时间"));
	            vlist.setVideoTime(rs.getInt("视频时长")/60 + "分" + rs.getInt("视频时长")%60);
	            vlist.setVideoNum(rs.getString("视频编号"));
	            vlist.setVideoPlayTimes(rs.getString("播放数") + 1);
	            vlist.setVideoPrice(rs.getString("视频价格"));
	            vlist.setGrade(rs.getString("视频年级"));
	            vlist.setSubject(rs.getString("视频科目"));
	            tVideoWaitVerifyList.add(vlist);
			}
        }
		return SUCCESS;
		
	}

	public List gettVideoWaitVerifyList() {
		return tVideoWaitVerifyList;
	}

	public void settVideoWaitVerifyList(List tVideoWaitVerifyList) {
		this.tVideoWaitVerifyList = tVideoWaitVerifyList;
	}
}
