package com.hly.videosys2.service;

import com.hly.videosys2.entity.Commentlist;

public interface CommentManageService extends BaseService<Commentlist> {

	void commentShowSet(Integer commentNum, String isShow);

	Commentlist getCommentByCommentNum(Integer commentNum);

}
