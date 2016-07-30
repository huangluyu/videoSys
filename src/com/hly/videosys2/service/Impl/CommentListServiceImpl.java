package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Commentlist;
import com.hly.videosys2.service.CommentListService;

public class CommentListServiceImpl extends BaseServiceImpl<Commentlist> implements
		CommentListService {
	
	//新建一条留言
	@Override  
    public void save(Commentlist commentinfo) {  
        getSession().save(commentinfo);  
    }
	
	//新建一条留言
	public void commentAdd(String videoNum,String videoComment,String commentTime,String commentUser,String isShow){
		/*String sql="insert into 留言列表 values(null,?,?,?,?,?,0)";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoNum);
		pstmt.setString(2, videoComment);
		pstmt.setString(3, commentTime);
		pstmt.setString(4, commentUser);
		pstmt.setString(5, isShow);
		return pstmt.executeUpdate();*/
		String hql = "insert into 留言列表 values(null,?,?,?,?,?,0)";
	}
	
	//找出特定某个视频的所有留言,排除隐藏的,用于视频播放界面
	@SuppressWarnings("unchecked")
	public List<Commentlist> commentReadByVideoNum(Integer videoNum){
		String hql = "from Commentlist c where c.videoNum = :videoNum and c.commentShowSet = 1 order by commentNum desc";
		return getSession().createQuery(hql)
				.setInteger("videoNum", videoNum)
				.list();
	}
	
	//找出某个老师符合条件的所有留言
	@SuppressWarnings("unchecked")
	@Override
	public List<Commentlist> getTeacherCommentList(String username, String commentByUser, String commentShowSet, int page){
		String hql = "from Commentlist c where c.videoNum = any(select v.videoNum from Videoinfo v where v.uploadByUser = :uploadByUser) and c.commentShowSet = :commentShowSet and c.commentByUser like :commentByUser order by c.commentNum desc";
		if(commentByUser == null || commentByUser.equals(""))
			commentByUser = "%";
		return getSession().createQuery(hql)
				.setString("uploadByUser", username)
				.setString("commentByUser", commentByUser)
				.setString("commentShowSet", commentShowSet)
		        .setFirstResult((page - 1) * 10)
		        .setMaxResults(page * 10)
				.list();
	}
	
	//找出符合条件的所有留言
	@SuppressWarnings("unchecked")
	@Override
	public List<Commentlist> commentReadByCondition(String videoNum, String commentByUser, String commentShowSet, int page) {
		String hql = "from Commentlist c where c.videoNum like :videoNum and c.commentShowSet = :commentShowSet and c.commentByUser like :commentByUser order by commentNum desc";
		if(videoNum == null || videoNum.equals(""))
			videoNum = "%";
		
		if(commentByUser == null || commentByUser.equals(""))
			commentByUser = "%";
		return getSession().createQuery(hql)
				.setString("videoNum", videoNum)
				.setString("commentByUser", commentByUser)
				.setString("commentShowSet", commentShowSet)
		        .setFirstResult((page - 1) * 10)
		        .setMaxResults(page * 10)
				.list();
	}


	//找出符合条件的所有留言的个数
	@Override
	public int commentListRead(Integer videoNum, String commentByUser, String commentShowSet) {
		/*String sql = "select count(*) as total from 留言列表 where 视频编号 like ? and 留言用户 like ? and 显示设置 like ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		if(videoNum == null || videoNum.equals("all"))
			pstmt.setString(1, "%");
		else
			pstmt.setString(1, videoNum);
		if(username == null || username.equals("all"))
			pstmt.setString(2, "%");
		else
			pstmt.setString(2, username);
		pstmt.setString(3, isShow);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return (rs.getInt("total") - 1) / 10 + 1;
		else
			return 0;*/
		String hql = "select count(v) from Commentlist c where c.videoNum like :videoNum and c.commentShowSet = :commentShowSet and c.commentByUser = :commentByUser";
		if(commentByUser == null || commentByUser.equals(""))
			commentByUser = "%";
		return (int) (((long)getSession().createQuery(hql)
				.setInteger("videoNum", videoNum)
				.setString("commentByUser", commentByUser)
				.setString("commentShowSet", commentShowSet)
		        .uniqueResult() - 1) / 10 + 1);
		
	}
}
