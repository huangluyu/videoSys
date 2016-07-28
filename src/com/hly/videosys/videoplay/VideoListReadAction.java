package com.hly.videosys.videoplay;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys.common.CommonJdbc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VideoListReadAction extends ActionSupport {
	private List videoList = new ArrayList();
	private String videoAuthor;
	private String videoAuthorName;
	private String gradeSearchSelect;
	private String subjectSearchSelect;
	private String authorSelect;
	private String videoName;
	//for action
	private String message;
	private int page = 1;
	private int pageSum;
	private int key = 0;

	public String execute() throws Exception {
		//获取session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		//根据session中存储的authority判断
		int authority = (Integer)session.get("authority");
		//如果key为1,则进入老师的管理界面
		if(key == 1)
			authorSelect = (String)session.get("username");
		//读取视频列表
		ResultSet rs = VideoJdbc.videoListRead(authorSelect, gradeSearchSelect, subjectSearchSelect, videoName, page);
		pageSum = VideoJdbc.videoListNumRead(authorSelect, gradeSearchSelect, subjectSearchSelect, videoName);
		
		
        try{
        	if((key == 2 && authority != 3) || (key == 1 && authority != 2))
        	{
        		message = "没有相关权限!";
        	} else
        	{
	    		while(rs.next())
	    		{
	    			//如果key为0,则为基础读取,跳过审核未通过及上传者隐藏的视频
	    			if(!(key == 0 && rs.getInt("视频价格") < 0))
	    			{
			            VideoList vlist = new VideoList();
			            vlist.setVideoName(rs.getString("视频名称"));
			            vlist.setVideoAuthor(rs.getString("上传者"));
			            videoAuthorName = CommonJdbc.getRealName(rs.getString("上传者"));
			            vlist.setVideoAddTime(rs.getString("上传时间"));
			            vlist.setVideoTime(rs.getInt("视频时长")/60 + "分" + rs.getInt("视频时长")%60);
			            vlist.setVideoNum(rs.getString("视频编号"));
			            vlist.setVideoPlayTimes(rs.getString("播放数") + 1);
			            vlist.setVideoPrice(rs.getString("视频价格"));
			            vlist.setGrade(rs.getString("视频年级"));
			            vlist.setSubject(rs.getString("视频科目"));
			            vlist.setExamineState(rs.getString("审核状态"));
			            videoList.add(vlist);
	    			}
	        	} 
        	}
        }catch(Exception ex){
        	System.out.println("error!");
            ex.printStackTrace();
        }
        System.out.println(key);
        if(key == 1)
        	return "tVideoList";
        else if(key == 2)
        	return "aVideoList";
        else 
        	return "videoList";
    }
    
    public String getVideoAuthor() {
    	return videoAuthor;
    }
 
    public void setVideoAuthor(String id) {
        this.videoAuthor = id;
    }

	public String getVideoAuthorName() {
		return videoAuthorName;
	}

	public void setVideoAuthorName(String videoAuthorName) {
		this.videoAuthorName = videoAuthorName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public String getAuthorSelect() {
		return authorSelect;
	}

	public void setAuthorSelect(String authorSelect) {
		this.authorSelect = authorSelect;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public List getVideoList() {
		return videoList;
	}

	public void setVideoList(List videoList) {
		this.videoList = videoList;
	}

	public String getGradeSearchSelect() {
		return gradeSearchSelect;
	}

	public void setGradeSearchSelect(String gradeSearchSelect) {
		this.gradeSearchSelect = gradeSearchSelect;
	}

	public String getSubjectSearchSelect() {
		return subjectSearchSelect;
	}

	public void setSubjectSearchSelect(String subjectSearchSelect) {
		this.subjectSearchSelect = subjectSearchSelect;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
