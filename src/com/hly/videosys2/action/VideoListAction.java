package com.hly.videosys2.action;

import java.util.List;

import com.hly.videosys2.entity.Userinfo;
import com.hly.videosys2.entity.Videoinfo;
import com.hly.videosys2.service.VideoListService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class VideoListAction extends BaseAction<Videoinfo> implements ModelDriven<Videoinfo>{

	int page = 1;
	
	public String myVideoList() {
		List<?> videoList;
		int pageSum;
		String myName = "";
		
		myName = ((Userinfo)session.get("userinfo")).getUsername();
		videoList = videoListService.videoListRead(myName , model.getVideoGrade(), model.getVideoSubject(), model.getVideoName(), page);
		pageSum = videoListService.videoListNumRead(myName , model.getVideoGrade(), model.getVideoSubject(), model.getVideoName());
		request.put("videoList", videoList);
		request.put("pageSum", pageSum);
		return "tVideoList";
	}

	public String allVideoList() {
		List<?> videoList;
		List<Userinfo> teacherList;
		int pageSum;
		String myName = "";
		
		videoList = videoListService.videoListRead(model.getUploadByUser() , model.getVideoGrade(), model.getVideoSubject(), model.getVideoName(), page);
		pageSum = videoListService.videoListNumRead(model.getUploadByUser() , model.getVideoGrade(), model.getVideoSubject(), model.getVideoName());
		teacherList = userManageService.getTeacherList();
		request.put("videoList", videoList);
		request.put("teacherList", teacherList);
		request.put("pageSum", pageSum);
		return "aVideoList";
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
