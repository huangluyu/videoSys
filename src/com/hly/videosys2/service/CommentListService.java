package com.hly.videosys2.service;

import java.util.List;

import com.hly.videosys2.entity.Commentlist;

public interface CommentListService extends BaseService<Commentlist> {

	public List<Commentlist> commentReadByVideoNum(Integer videoNum);
	
	public List<Commentlist> commentReadByCondition(Integer videoNum, String commentByUser, String commentShowSet, int page);
	
	public int commentListRead(Integer videoNum, String commentByUser, String commentShowSet);
}
