package com.hly.videosys2.action;

import java.util.List;

import com.hly.videosys2.entity.Commentlist;
import com.hly.videosys2.entity.Videoinfo;
import com.opensymphony.xwork2.ModelDriven;

public class VideoPlayAction extends BaseAction<Videoinfo> implements ModelDriven<Videoinfo> {

	Integer videoNum;
	
	public String playVideoByNum(){
		List<Commentlist> commentList;
		Videoinfo videoinfo;
		
		commentList = commentListService.commentReadByVideoNum(videoNum);
		videoinfo = videoManageService.getInfoByVideoNum(videoNum);
		request.put("commentList", commentList);
		request.put("videoinfo", videoinfo);		
		return "play";
	}

	public Integer getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
	}
}
