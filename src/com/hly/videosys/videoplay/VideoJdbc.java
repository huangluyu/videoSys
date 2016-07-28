package com.hly.videosys.videoplay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hly.videosys.common.JdbcMysql;

public class VideoJdbc {
	
	//找出所有的视频
	public static ResultSet videoListRead()throws Exception{
		String sql="select * from 视频表";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	//按条件找出视频
	public static ResultSet videoListRead(String author, String grade, String subject, String videoName, int page) throws Exception {
		String sql = "select * from 视频表 where 上传者 like ? and 视频年级 like ? and 视频科目 like ? and 视频名称 like ? limit ?,?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		if(author == null || author.equals("all"))
			pstmt.setString(1, "%");
		else
			pstmt.setString(1, author);
		if(grade == null || grade.equals("all"))
			pstmt.setString(2, "%");
		else
			pstmt.setString(2, grade);
		if(subject == null || subject.equals("all"))
			pstmt.setString(3, "%");
		else
			pstmt.setString(3, subject);
		if(videoName == null || videoName.equals("all"))
			pstmt.setString(4, "%");
		else
			pstmt.setString(4, "%" + videoName + "%");
		pstmt.setInt(5, (page - 1) * 10);
		pstmt.setInt(6, page * 10);
		return pstmt.executeQuery();
	}
	
	//计算符合条件的视频的总页数
	public static int videoListNumRead(String author, String grade, String subject, String videoName) throws Exception {
		String sql = "select count(*) as total from 视频表 where 上传者 like ? and 视频年级 like ? and 视频科目 like ? and 视频名称 like ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		if(author == "" || author == null)
			pstmt.setString(1, "%");
		else
			pstmt.setString(1, author);
		if(grade == "" || grade == null)
			pstmt.setString(2, "%");
		else
			pstmt.setString(2, grade);
		if(subject == "" || subject == null)
			pstmt.setString(3, "%");
		else
			pstmt.setString(3, subject);
		if(videoName == null || videoName.equals("all"))
			pstmt.setString(4, "%");
		else
			pstmt.setString(4, "%" + videoName + "%");
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return (rs.getInt("total") - 1) / 10 + 1;
		else
			return 0;
	}
	
	//删除一个视频,涉及到三个表
	public static void videoDelete(String videoNum) throws Exception {
		String sql1 = "delete from 视频表 where 视频编号 = ?";
		String sql2 = "delete from 留言列表 where 视频编号 = ?";
		String sql3 = "delete from 视频标签 where 视频编号 = ?";
		PreparedStatement pstmt1 = JdbcMysql.conn().prepareStatement(sql1);
		PreparedStatement pstmt2 = JdbcMysql.conn().prepareStatement(sql2);
		PreparedStatement pstmt3 = JdbcMysql.conn().prepareStatement(sql3);
		pstmt1.setString(1, videoNum);
		pstmt2.setString(1, videoNum);
		pstmt3.setString(1, videoNum);
		if (pstmt1.executeUpdate() > 0)
			System.out.println("视频表删除成功!");
		if (pstmt2.executeUpdate() > 0)
			System.out.println("留言标签删除成功!");
		if (pstmt3.executeUpdate() > 0)
			System.out.println("视频标签删除成功!");
	}
	
	//更新视频的名字
	public static int updateVideoInfo(String videoNum,String newName,String newGrade,String newSubject,int newPrice) throws Exception {
		String sql="update 视频表 set 视频名称 = ?,视频年级 = ?,视频科目 = ?,视频价格 = ?  where 视频编号 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, newName);
		pstmt.setString(2, newGrade);
		pstmt.setString(3, newSubject);
		pstmt.setInt(4, newPrice);
		pstmt.setString(5, videoNum);
		return pstmt.executeUpdate();
	}
	
	//使播放数加1
	public static void addPlayTimes(String videoNum) throws SQLException, ClassNotFoundException {
		String sql="update 视频表 set 视频表.播放数 = 视频表.播放数 + 1 where 视频编号 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoNum);
		pstmt.executeUpdate();
	}
	
	//找出某一个视频的全部信息
	public static ResultSet videoRead(String videoNum)throws Exception{
		String sql="select * from 视频表 where 视频编号 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoNum);
		return pstmt.executeQuery();
	}

}
