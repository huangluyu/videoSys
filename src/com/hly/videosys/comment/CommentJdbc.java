package com.hly.videosys.comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hly.videosys.common.JdbcMysql;

public class CommentJdbc {

	//新建一条留言
	public static int commentAdd(String videoNum,String videoComment,String commentTime,String commentUser,String isShow) throws Exception{
		String sql="insert into 留言列表 values(null,?,?,?,?,?,0)";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoNum);
		pstmt.setString(2, videoComment);
		pstmt.setString(3, commentTime);
		pstmt.setString(4, commentUser);
		pstmt.setString(5, isShow);
		return pstmt.executeUpdate();
	}
	
	//找出特定某个视频的所有留言
	public static ResultSet commentRead(String videoNum) throws Exception {
		String sql="select * from 留言列表 where 视频编号 = ? and 显示设置 = 1 order by 留言编号 desc";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoNum);
		return pstmt.executeQuery();
	}
	
	//找出符合条件的所有留言
	public static ResultSet commentListRead(String videoNum, String username, String isShow, int page) throws Exception {
		String sql = "select * from 留言列表 where 视频编号 like ? and 留言用户 like ? and 显示设置 like ? order by 留言编号 desc limit ?,?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		if(videoNum == null || videoNum.equals(""))
			pstmt.setString(1, "%");
		else
			pstmt.setString(1, videoNum);
		if(username == null || username.equals(""))
			pstmt.setString(2, "%");
		else
			pstmt.setString(2, username);
		pstmt.setString(3, isShow);
		pstmt.setInt(4, (page - 1) * 10);
		pstmt.setInt(5, page * 10);
		return pstmt.executeQuery();
	}


	//找出符合条件的所有留言的个数
	public static int commentListRead(String videoNum, String username, String isShow) throws Exception {
		String sql = "select count(*) as total from 留言列表 where 视频编号 like ? and 留言用户 like ? and 显示设置 like ?";
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
			return 0;
	}
}
