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

	//找出所有待审核的视频
	@SuppressWarnings("unchecked")
	@Override
	public List<Videoinfo> videoListWaitVerify(int Page){
		String hql = "from Videoinfo v where v.videoExamineState = 0";
		return getSession().createQuery(hql)
		        .setFirstResult((Page - 1) * 10)
		        .setMaxResults(Page * 10)
		        .list();
	}

	//找出一个老师的视频列表
	@Override
	public List<Integer> getVideoListByUser(String username) {
		String hql = "select v.videoNum from Videoinfo v where v.uploadByUser = :uploadByUser";
		return getSession().createQuery(hql)
				.setString("uploadByUser", username)
				.list();
	}
}
