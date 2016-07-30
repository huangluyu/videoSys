package com.hly.videosys2.service;

import java.util.List;

import com.hly.videosys2.entity.Videoinfo;

public interface VideoListService extends BaseService<Videoinfo> {

	public List<?> videoListRead(String author, String grade, String subject, String videoName, int page);
	
	public int videoListNumRead(String author, String grade, String subject, String videoName);

	List<Videoinfo> videoListWaitVerify(int PageSum);

	List<Integer> getVideoListByUser(String username);
}
