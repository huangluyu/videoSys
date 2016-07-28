package com.hly.videosys.videoplay;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hly.videosys.comment.CommentJdbc;
import com.hly.videosys.comment.CommentList;
import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys.common.CommonJdbc;
import com.hly.videosys.pay.PayJdbc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VideoPlayAction extends ActionSupport {
	private String videoUrl;
	private String videoNum;
	private String authority;
	private String username;

	private List videoInfo = new ArrayList();
	private List commentList = new ArrayList();
	
	//for action
	private String message;
	private String videoAuthor;
	private String device = "";
	
	public String execute()
	{
		String videoPrice;
		
		//获取session authority&username
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        authority = session.get("authority").toString();
        username = session.get("username").toString();
		try {
			ResultSet rs = VideoJdbc.videoRead(videoNum);
			if(rs.next())
			{
				VideoList vlist = new VideoList();
	            vlist.setVideoName(rs.getString("视频名称"));
	            vlist.setVideoAddTime(rs.getString("上传时间"));
	            vlist.setVideoAuthor(rs.getString("上传者"));
	            videoAuthor = vlist.getVideoAuthor();
	            vlist.setVideoAuthorName(CommonJdbc.getRealName(rs.getString("上传者")));
	            vlist.setVideoTime(rs.getInt("视频时长")/60 + "分" + rs.getInt("视频时长")%60);
	            vlist.setVideoNum(rs.getString("视频编号"));
	            vlist.setVideoPlayTimes(rs.getString("播放数"));
	            vlist.setVideoPrice(rs.getString("视频价格"));
	            vlist.setGrade(rs.getString("视频年级"));
	            vlist.setSubject(rs.getString("视频科目"));
	            videoInfo.add(vlist);
				videoUrl = rs.getString("视频地址") + ".mp4";
				videoPrice = rs.getString("视频价格");
				//视频权限检测 没有购买且视频价格不为0时退出
				if(!username.equals(rs.getString("上传者")))
				{
					if(!PayJdbc.checkVideoReadAuthority(username, videoNum).next() && !videoPrice.equals("0"))
					{
						message = "您没有该视频读取权限!使用积分兑换后才能观看!";
						return ERROR;
					} else
						VideoJdbc.addPlayTimes(videoNum);
				}
			} else 
			{
				message = "视频不存在或者已被删除,请联系管理员!";
				return ERROR;
			}
			//播放数++
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//获得评论列表
        try{
        	ResultSet rs = CommentJdbc.commentRead(videoNum);
	        while(rs.next()){
	            CommentList clist = new CommentList();
	            clist.setVideoComment(rs.getString("留言内容"));
	            clist.setCommentTime(rs.getString("留言时间"));
	            clist.setCommentUser(CommonJdbc.getRealName(rs.getString("留言用户")));
	            commentList.add(clist);
	        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(device);
        if(device.equals("mobile"))
        	return "mPlay";
        else
        	return "play";
	}
	
	public String getVideoNum() {
		return videoNum;
	}
	
	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}
	
	public String getVideoUrl() {
		return videoUrl;
	}
	
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	public List getCommentList() {
		return commentList;
	}
	
	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public List getVideoInfo() {
		return videoInfo;
	}
	public void setVideoInfo(List videoInfo) {
		this.videoInfo = videoInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVideoAuthor() {
		return videoAuthor;
	}

	public void setVideoAuthor(String videoAuthor) {
		this.videoAuthor = videoAuthor;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
}
