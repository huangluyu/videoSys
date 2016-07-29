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
	
	//
	@Override
	public void update(Videoinfo videoinfo) {
		Session session = getSession();
		session.beginTransaction(); //关键1
        session.update(videoinfo);
		session.getTransaction().commit(); //关键2
	}
	
	public int uploadVideo(Videoinfo videoinfo){
		
		
		return 0;
		
	}
	
	//新增一条Videoinfo表的记录
	@Override
	public int videoInfoAdd(String videoName,String videoUrl,String username,String uploadtime,String videoTime,String grade,String subject)throws Exception{
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
	
	//
	public static int addUploadState(String videoUrl,String uploadState) throws SQLException{
		String sql="insert into 视频上传表 values(?,?)";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoUrl);
		pstmt.setString(2, uploadState);
		return pstmt.executeUpdate();
	}
	
	//更新视频上传状态信息
	public int updateUploadState(String videoUrl,String uploadState){
		/*String sql="update video set 上传状态 = ? where 视频地址 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(2, videoUrl);
		pstmt.setString(1, uploadState);
		return pstmt.executeUpdate();*/
		String hql = "update Videoinfo v set v.videoUploadInfo = :videoUploadInfo where v.videoUrl = :videoUrl";
		return getSession().createQuery(hql).executeUpdate();
	}
	
	//设置视频转码成功
	public int updateVideoState(String videoUrl){
		/*String sql="update 视频表 set 视频价格 = 0 where 视频地址 = ?";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		pstmt.setString(1, videoUrl);
		return pstmt.executeUpdate();*/
		return 0;
	}
}
