package com.hly.videosys2.service;

import com.hly.videosys2.entity.Videoinfo;

public interface VideoManageService extends BaseService<Videoinfo> {

	Videoinfo getInfoByVideoNum(Integer videoNum);

	Videoinfo getInfoByVideoUrl(String videoUrl);

	int updateVideoinfo(Videoinfo model, Videoinfo videoinfo);

	void updateVideoExamineState(Integer videoNum, String videoExamineState,
			String videoPrice);

}
