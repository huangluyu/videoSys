package com.hly.videosys.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hly.videosys.comment.CommentJdbc;
import com.hly.videosys.comment.CommentList;
import com.hly.videosys.common.CommonJdbc;
import com.hly.videosys.videoplay.VideoList;
import com.opensymphony.xwork2.ActionSupport;

public class CommentListForAdminAction extends ActionSupport {
	private List commentListForAdmin = new ArrayList();
	private List authorList = new ArrayList();
	private String videoNum;
	private String username;
	private int page = 1;
	private int pageSum;
	private String keyIsShow;
	
	public String execute() throws Exception {
		ResultSet rs = CommentJdbc.commentListRead(videoNum, username, keyIsShow, page);
		pageSum = CommentJdbc.commentListRead(videoNum, username, keyIsShow);
        while(rs.next()){
            CommentList clist = new CommentList();
            clist.setVideoComment(rs.getString("留言内容"));
            clist.setCommentTime(rs.getString("留言时间"));
            clist.setCommentUserRealName(CommonJdbc.getRealName(rs.getString("留言用户")));
            clist.setCommentUser(rs.getString("留言用户"));
            clist.setVideoNum(rs.getString("视频编号"));
            clist.setCommentNum(rs.getString("留言编号"));
            commentListForAdmin.add(clist);
        }
        if(keyIsShow.equals("1"))
        	return "manage";
        else
        	return "verifyDelete";
		
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

	public List getCommentListForAdmin() {
		return commentListForAdmin;
	}

	public void setCommentListForAdmin(List commentListForAdmin) {
		this.commentListForAdmin = commentListForAdmin;
	}

	public List getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List authorList) {
		this.authorList = authorList;
	}

	public String getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public String getKeyIsShow() {
		return keyIsShow;
	}

	public void setKeyIsShow(String keyIsShow) {
		this.keyIsShow = keyIsShow;
	}

}
