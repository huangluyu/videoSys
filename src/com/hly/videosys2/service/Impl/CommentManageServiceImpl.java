package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Commentlist;
import com.hly.videosys2.service.CommentManageService;

public class CommentManageServiceImpl extends BaseServiceImpl<Commentlist>
		implements CommentManageService {

	//更新一个留言的是否显示的设置
	@Override
	public void commentShowSet(Integer commentNum,String isShow){
		String hql = "update Commentlist c set c.commentShowSet = :commentShowSet where c.commentNum = :commentNum";
		getSession().createQuery(hql)
			.setInteger("commentNum", commentNum)
			.setString("commentShowSet", isShow)
			.executeUpdate();
	}
	
	//根据commentNum找到留言
	@Override
	public Commentlist getCommentByCommentNum(Integer commentNum)  {
		String hql = "from Commentlist c where c.commentNum = :commentNum";
		return (Commentlist) getSession().createQuery(hql)
				.setInteger("commentNum", commentNum)
				.uniqueResult();
	}
	
}
