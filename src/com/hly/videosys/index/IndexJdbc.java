package com.hly.videosys.index;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hly.videosys.common.JdbcMysql;

public class IndexJdbc {

	//找出免费热门排行前十
	public static ResultSet getVideoFreeList() throws Exception {
		String sql="select * from videoinfo where videoPrice = 0 order by videoPlayTimes desc limit 10";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	//找出付费热门排行前十
	public static ResultSet getVideoPayList() throws Exception {
		String sql="select * from videoinfo where videoPrice > 0 order by videoPlayTimes desc limit 10";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	//找出最新的五个视频
	public static ResultSet getVideoNewList() throws Exception {
		String sql="select * from videoinfo where videoPrice >= 0 order by videoNum desc limit 4";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	//找出某年级的五个最近热门视频
	public static ResultSet getVideoGradeNewList(String grade) throws Exception {
		String sql="select * from videoinfo where videoPrice >= 0 and videoGrade = ? order by videoPlayTimes desc limit 4";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, grade);
		return pstmt.executeQuery();
	}
	
	//找出
}
