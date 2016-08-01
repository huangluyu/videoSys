package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Videoinfo;
import com.hly.videosys2.service.VideoManageService;

public class VideoManageServiceImpl extends BaseServiceImpl<Videoinfo>
		implements VideoManageService {

	//根据videoNum查找视频信息
	@Override
	public Videoinfo getInfoByVideoNum(Integer videoNum) {
		String hql = "from Videoinfo v where v.videoNum = :videoNum";
		return (Videoinfo) getSession().createQuery(hql)
				.setInteger("videoNum", videoNum)
				.uniqueResult();
	}
	
	//根据videoUrl查找视频信息
	@Override
	public Videoinfo getInfoByVideoUrl(String videoUrl) {
		String hql = "from Videoinfo v where v.videoUrl = :videoUrl";
		return (Videoinfo) getSession().createQuery(hql)
				.setString("videoUrl", videoUrl)
				.uniqueResult();
	}
	
	//更新视频状态
	@Override
	public int updateVideoinfo(Videoinfo model ,Videoinfo videoinfo){
		System.out.println("videoNum:" + model.getVideoNum() + " grade:" + model.getVideoGrade() + " subject:" + model.getVideoSubject());

		if(model.getVideoName() != null && !model.getVideoName().equals(""))
			videoinfo.setVideoName(model.getVideoName());
		if(model.getVideoGrade() != null && !model.getVideoGrade().equals(""))
			videoinfo.setVideoGrade(model.getVideoGrade());
		if(model.getVideoSubject() != null && !model.getVideoSubject().equals(""))
			videoinfo.setVideoSubject(model.getVideoSubject());
		if(new Integer(model.getVideoPrice()) >= 0)
			videoinfo.setVideoPrice(model.getVideoPrice());
		update(videoinfo);
		return 1;
	}
	
	//设置审核状态,通过为1,拒绝为-1
	@Override
	public void updateVideoExamineState(Integer videoNum, String videoExamineState, String videoPrice) {
		String hql = "update Videoinfo v set v.videoExamineState = :videoExamineState , v.videoPrice = :videoPrice where v.videoNum = :videoNum";
		getSession().createQuery(hql)
			.setInteger("videoNum", videoNum)
			.setString("videoExamineState", videoExamineState)
			.setString("videoPrice", videoPrice)
			.executeUpdate();
	}
}
