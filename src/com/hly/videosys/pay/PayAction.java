package com.hly.videosys.pay;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.hly.videosys.videoplay.VideoJdbc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PayAction extends ActionSupport {

	private String videoNum;
	//for action
	private String message;
	private String videoAuthor;
	
	public String execute() throws Exception {
		String username;
		int videoPrice;
		String payTime;
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		username = session.get("username").toString();
		ResultSet rs = VideoJdbc.videoRead(videoNum);
		if(rs.next())
		{
			videoAuthor = rs.getString("上传者");
			videoPrice = rs.getInt("视频价格");
			if(PayJdbc.payMoney(username, videoAuthor, videoPrice))
			{
				message = "视频购买成功!扣除" + videoPrice + "积分!";
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				payTime = df.format(new Date());
				PayJdbc.commentAdd(username, videoNum, videoPrice, payTime);
				return SUCCESS;
			} else 
			{
				message = "视频购买失败!";
				return ERROR;
			}
		}else
		{
			message = "该视频不存在!";
			return ERROR;
		}
	}

	public String getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVideoAuthor() {
		return videoAuthor;
	}

	public void setVideoAuthor(String videoAuthor) {
		this.videoAuthor = videoAuthor;
	}
}
