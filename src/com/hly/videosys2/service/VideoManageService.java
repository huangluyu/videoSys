package com.hly.videosys2.service;

import com.hly.videosys2.entity.Videoinfo;

public interface VideoManageService extends BaseService<Videoinfo> {

	Videoinfo getInfoByVideoNum(Integer videoNum);

	int videoInfoAdd(String videoName, String videoUrl, String username,
			String uploadtime, String videoTime, String grade, String subject)
			throws Exception;

	Videoinfo getInfoByVideoUrl(String videoUrl);

}
