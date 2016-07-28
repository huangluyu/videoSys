package com.hly.videosys.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.hly.videosys.common.JdbcMysql;

public class AdminJdbc {
	//找出所有待审核的视频
	public static ResultSet tVideoWaitVerify() throws Exception {
		String sql = "select * from 视频表 where 审核状态 = 0";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	//找出符合条件的所有视频的个数
	
	
	//找出符合条件的所有视频
	
	

	
	//更新一个留言的是否显示的设置
	public static int commentShowSet(String commentNum,String isShow) throws Exception{
		String sql = "update 留言列表 set 显示设置 = ? where 留言编号 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, isShow);
		pstmt.setString(2, commentNum);
		return pstmt.executeUpdate();
	}

	//删除一条留言
	public static int commentDelete(String commentNum) throws Exception{
		String sql = "delete from 留言列表 where 留言编号 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, commentNum);
		return pstmt.executeUpdate();
	}
	
	//找出符合条件的所有用户的个数
	public static int userListNumRead(String username, String realName, String authority) throws Exception {
		String sql = "select count(*) as total from 用户表 where 用户名 like ? and 真实姓名 like ? and 用户权限 like ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		if(username == null || username.equals(""))
			pstmt.setString(1, "%");
		else
			pstmt.setString(1, username);
		if(realName == null || realName.equals(""))
			pstmt.setString(2, "%");
		else
			pstmt.setString(2, realName);
		if(authority == null || authority.equals(""))
			pstmt.setString(3, "%");
		else
			pstmt.setString(3, authority);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return (rs.getInt("total") - 1) / 10 + 1;
		else
			return 0;
	}
	
	//找出符合条件的所有用户
	public static ResultSet userListRead(String username, String realName, String authority, int page) throws Exception {
		String sql = "select * from 用户表 where 用户名 like ? and 真实姓名 like ? and 用户权限 like ? limit ?,?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		if(username == null || username.equals(""))
			pstmt.setString(1, "%");
		else
			pstmt.setString(1, username);
		if(realName == null || realName.equals(""))
			pstmt.setString(2, "%");
		else
			pstmt.setString(2, realName);
		if(authority == null || authority.equals(""))
			pstmt.setString(3, "%");
		else
			pstmt.setString(3, authority);
		pstmt.setInt(4, (page - 1) * 10);
		pstmt.setInt(5, page * 10);
		return pstmt.executeQuery();
	}	
	
	//添加用户封禁记录
	//0类封禁,该用户无法进行任何操作
	//1类封禁,该用户无法进行部分操作
	//2类禁言,该用户无法进行任何留言
	//3类禁言,该用户无法在指定老师下留言
	public static int banUser(String username, String executor, String presentTime, int durationTime, String level) throws SQLException{
		String sql="insert into 用户封禁记录 values(?,?,?,?,?)";
		PreparedStatement pstmt = JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, executor);
		pstmt.setString(3, presentTime);
		pstmt.setInt(4, durationTime);
		pstmt.setString(5, level);
		return pstmt.executeUpdate();
	}
}

