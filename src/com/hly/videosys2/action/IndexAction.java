package com.hly.videosys2.action;

import com.hly.videosys2.entity.Userinfo;
import com.hly.videosys2.entity.Videoinfo;
import com.opensymphony.xwork2.ModelDriven;

public class IndexAction extends BaseAction<Videoinfo> implements ModelDriven<Videoinfo>  {

	public String pcRead() {
		application.put("freeList", indexService.getVideoFreeList());
		application.put("newList", indexService.getVideoNewList());
		application.put("payList", indexService.getVideoPayList());
		application.put("grade1List", indexService.getVideoGradeNewList("高一"));
		application.put("grade2List", indexService.getVideoGradeNewList("高二"));
		application.put("grade3List", indexService.getVideoGradeNewList("高三"));
		return "index";
	}
}
