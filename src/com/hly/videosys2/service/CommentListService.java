package com.hly.videosys2.service;

import java.util.List;

import com.hly.videosys2.entity.Commentlist;

public interface CommentListService extends BaseService<Commentlist> {

	List<Commentlist> commentReadByVideoNum(Integer videoNum);
		
	int commentListRead(Integer videoNum, String commentByUser, String commentShowSet);

	List<Commentlist> getTeacherCommentList(String username,
			String commentByUser, String commentShowSet, int page);

	List<Commentlist> commentReadByCondition(String videoNum,
			String commentByUser, String commentShowSet, int page);
}
