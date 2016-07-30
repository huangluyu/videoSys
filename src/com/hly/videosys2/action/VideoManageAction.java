package com.hly.videosys2.action;

import java.sql.ResultSet;

import com.hly.videosys.videoplay.VideoJdbc;
import com.hly.videosys2.entity.Userinfo;
import com.hly.videosys2.entity.Videoinfo;
import com.opensymphony.xwork2.ModelDriven;

public class VideoManageAction extends BaseAction<Videoinfo> implements
		ModelDriven<Videoinfo> {

	private String isShow;
	
	//更新视频信息
	public String updateVideoinfo(){
		//权限判断
		Userinfo myinfo = (Userinfo) session.get("userinfo");
		Videoinfo videoinfo = videoManageService.getInfoByVideoNum(model.getVideoNum());
		if(!myinfo.getUsername().equals(videoinfo.getUploadByUser()) && myinfo.getUserAuthority() != 3)
		{
			System.out.println("用户:" + myinfo.getUsername() + "试图修改视频:" + videoinfo.getVideoNum());
			return "index";
		}
		if(isShow == null)
			model.setVideoPrice("-1");
		if(videoinfo != null)
			videoManageService.updateVideoinfo(model, videoinfo);
		return "teacher";
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
}
