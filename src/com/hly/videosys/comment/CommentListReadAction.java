package com.hly.videosys.comment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hly.videosys.common.CommonJdbc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentListReadAction extends ActionSupport {
	private List commentListForAdmin = new ArrayList();
	private List authorList = new ArrayList();
	private String videoNum;
	private String username;
	private int page = 1;
	private int pageSum;
	private String keyIsShow;
	
	public String execute() throws Exception {
		//获取session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		//根据session中存储的authority判断
		int authority = (Integer)session.get("authority");
		//读取评论列表
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

}
