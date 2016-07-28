package com.hly.videosys.pay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hly.videosys.common.JdbcMysql;

public class PayJdbc {
	
	//找出视频权限
	public static ResultSet checkVideoReadAuthority(String username,String videoNum) throws SQLException, ClassNotFoundException{
		String sql="select * from 视频购买记录 where 视频编号 = ? AND 用户名 = ?";
		PreparedStatement pstmt = JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoNum);
		pstmt.setString(2, username);
		return pstmt.executeQuery();
	}
	
	//新增购买记录
	public static int commentAdd(String username,String videoNum,int videoPrice,String payTime) throws Exception{
		String sql="insert into 视频购买记录 values(?,?,?,?)";	
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, videoNum);
		pstmt.setInt(3, videoPrice);
		pstmt.setString(4, payTime);
		return pstmt.executeUpdate();
	}
	
	//支付积分购买
	public static boolean payMoney(String username,String videoAuthor,int videoPrice) throws Exception{
		String sql="update 用户表 set 用户表.积分 = 用户表.积分 + ? where 用户名 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		PreparedStatement pstmt2=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setInt(1, videoPrice);
		pstmt.setString(2, videoAuthor);
		pstmt2.setInt(1, -videoPrice);
		pstmt2.setString(2, username);
		if(pstmt.executeUpdate() > 0 && pstmt2.executeUpdate() > 0 )
			return true;
		else
			return false;
	}
	
}

