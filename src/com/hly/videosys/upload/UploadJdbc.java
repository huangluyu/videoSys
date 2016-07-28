package com.hly.videosys.upload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hly.videosys.common.JdbcMysql;

public class UploadJdbc {
	
	public static int videoInfoAdd(String videoName,String videoUrl,String username,String uploadtime,String videoTime,String grade,String subject)throws Exception{
		String sql="insert into 视频表 values(null,?,1,?,?,?,-2,?,?,?,0,0)";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoName);
		pstmt.setString(2, videoTime);
		pstmt.setString(3, uploadtime);
		pstmt.setString(4, videoUrl);
		pstmt.setString(5, username);
		pstmt.setString(6, grade);
		pstmt.setString(7, subject);
		return pstmt.executeUpdate();
	}
	
	public static int addUploadState(String videoUrl,String uploadState) throws SQLException{
		String sql="insert into 视频上传表 values(?,?)";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoUrl);
		pstmt.setString(2, uploadState);
		return pstmt.executeUpdate();
	}
	
	public static int updateUploadState(String videoUrl,String uploadState) throws SQLException{
		String sql="update 视频上传表 set 上传状态 = ? where 视频地址 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(2, videoUrl);
		pstmt.setString(1, uploadState);
		return pstmt.executeUpdate();
	}
	
	public static int updateVideoState(String videoUrl) throws Exception {
		String sql="update 视频表 set 视频价格 = 0 where 视频地址 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoUrl);
		return pstmt.executeUpdate();
	}
}
