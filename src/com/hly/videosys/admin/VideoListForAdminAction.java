package com.hly.videosys.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hly.videosys.common.CommonJdbc;
import com.hly.videosys.videoplay.VideoJdbc;
import com.hly.videosys.videoplay.VideoList;
import com.opensymphony.xwork2.ActionSupport;

public class VideoListForAdminAction extends ActionSupport {
	private List videoListForAdmin = new ArrayList();
	private List authorList = new ArrayList();
	private String gradeSelect;
	private String subjectSelect;
	private String authorSelect;
	private String videoName;
	private int page = 1;
	private int pageSum;
	
	public String execute() throws Exception {
		ResultSet rs = VideoJdbc.videoListRead(authorSelect, gradeSelect, subjectSelect, videoName, page);
		pageSum = VideoJdbc.videoListNumRead(authorSelect, gradeSelect, subjectSelect, videoName);
		ResultSet rs1 = CommonJdbc.getTeacherList();
		while(rs.next()){
            VideoList vlist = new VideoList();
            vlist.setVideoName(rs.getString("视频名称"));
            vlist.setVideoAuthor(CommonJdbc.getRealName(rs.getString("上传者")));
            vlist.setVideoAddTime(rs.getString("上传时间"));
            vlist.setVideoTime(rs.getInt("视频时长")/60 + "分" + rs.getInt("视频时长")%60);
            vlist.setVideoNum(rs.getString("视频编号"));
            vlist.setVideoPlayTimes(rs.getString("播放数") + 1);
            vlist.setVideoPrice(rs.getString("视频价格"));
            vlist.setGrade(rs.getString("视频年级"));
            vlist.setSubject(rs.getString("视频科目"));
            videoListForAdmin.add(vlist);
        }
        while(rs1.next()){
        	AuthorList alist = new AuthorList();
        	alist.setAuthorName(rs1.getString("真实姓名"));
        	alist.setAuthor(rs1.getString("用户名"));
        	authorList.add(alist);
        }
		return SUCCESS;
		
	}
	
	class AuthorList{
		private String authorName;
		private String author;

		public String getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List getVideoListForAdmin() {
		return videoListForAdmin;
	}

	public void setVideoListForAdmin(List videoListForAdmin) {
		this.videoListForAdmin = videoListForAdmin;
	}

	public String getGradeSelect() {
		return gradeSelect;
	}

	public void setGradeSelect(String gradeSelect) {
		this.gradeSelect = gradeSelect;
	}

	public String getSubjectSelect() {
		return subjectSelect;
	}

	public void setSubjectSelect(String subjectSelect) {
		this.subjectSelect = subjectSelect;
	}

	public String getAuthorSelect() {
		return authorSelect;
	}

	public void setAuthorSelect(String authorSelect) {
		this.authorSelect = authorSelect;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public List getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List authorList) {
		this.authorList = authorList;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
}
