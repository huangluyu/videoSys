package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Userinfo;
import com.hly.videosys2.entity.Videoinfo;
import com.hly.videosys2.service.VideoListService;

public class VideoListServiceImpl extends BaseServiceImpl<Videoinfo> implements
		VideoListService {

	//按条件找出视频
	public List<?> videoListRead(String author, String grade, String subject, String videoName, int page){
		String hql = "from Videoinfo v where v.uploadByUser like :teacher and v.videoGrade like :grade and v.videoSubject like :subject and v.videoName like :videoName";
		if(author == null || author.equals("all"))
			author = "%";
		if(grade == null || grade.equals("all"))
			grade = "%";
		if(subject == null || subject.equals("all"))
			subject = "%";
		if(videoName == null || videoName.equals("all"))
			videoName = "%";
		else
			videoName = "%" + videoName + "%";
		return	getSession().createQuery(hql) //  
		        .setString("teacher", author) //  
		        .setString("grade", grade) //  
		        .setString("videoName", videoName) //  
		        .setString("subject", subject) //  
		        .setFirstResult((page - 1) * 10)
		        .setMaxResults(page * 10)
		        .list();
	}
	
	//计算符合条件的视频的总页数
	public int videoListNumRead(String author, String grade, String subject, String videoName) {
		/*String sql = "select count(*) as total from 视频表 where 上传者 like ? and 视频年级 like ? and 视频科目 like ? and 视频名称 like ?";
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
			return 0;*/
		String hql = "select count(v) from Videoinfo v where v.uploadByUser like :teacher and v.videoGrade like :grade and v.videoSubject like :subject and v.videoName like :videoName";
		if(author == null || author.equals("all"))
			author = "%";
		if(grade == null || grade.equals("all"))
			grade = "%";
		if(subject == null || subject.equals("all"))
			subject = "%";
		if(videoName == null || videoName.equals("all"))
			videoName = "%";
		else
			videoName = "%" + videoName + "%";
		return	(int) (((long)getSession().createQuery(hql) //  
		        .setString("teacher", author) //  
		        .setString("grade", grade) //  
		        .setString("videoName", videoName) //  
		        .setString("subject", subject) //  
		        .uniqueResult() - 1) / 10 + 1);
	}

}
