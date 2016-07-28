package com.hly.videosys.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonJdbc {
	public static String getRealName(String author) throws Exception {
		String sql="select realName from userinfo where username = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, author);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			return rs.getString("realName");
		else
			return "null";
	}
	
	public static ResultSet getTeacherList()  throws Exception {
		String sql="select * from userinfo where userAuthority = 2";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}
}