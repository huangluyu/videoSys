package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Videoinfo;
import com.hly.videosys2.service.IndexService;

public class IndexServiceImpl extends BaseServiceImpl<Videoinfo> implements IndexService {

	//找出免费热门排行前十
	@Override
	public List<Videoinfo> getVideoFreeList() {
		String hql = "from Videoinfo v where v.videoPrice = 0 order by v.videoPlayTimes desc";
		return getSession().createQuery(hql).setMaxResults(10).list(); 
	}
	
	//找出付费热门排行前十
	@Override
	public List<Videoinfo> getVideoPayList() {
		String hql = "from Videoinfo v where v.videoPrice > 0 order by v.videoPlayTimes desc";
		return getSession().createQuery(hql).setMaxResults(10).list();
	}
	
	//找出最新的五个视频
	@Override
	public List<Videoinfo> getVideoNewList() {
		String hql = "from Videoinfo v where v.videoPrice >= 0 order by v.videoNum desc";
		return getSession().createQuery(hql).setMaxResults(4).list();
	}
	
	//找出某年级的五个最近热门视频
	@Override
	public List<Videoinfo> getVideoGradeNewList(String grade) {
		String hql = "from Videoinfo v where v.videoPrice >= 0 and v.videoGrade = :grade order by v.videoPlayTimes desc";
		return getSession().createQuery(hql).setString("grade", grade).setMaxResults(4).list();
	}
}
