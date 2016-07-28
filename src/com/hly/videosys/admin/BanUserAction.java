package com.hly.videosys.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BanUserAction extends ActionSupport {
	private String username;
	private String executor;
	private String presentTime;
	private int durationTime = 1;
	private String level = "1";
	//for action
	private String message;

	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        presentTime = df.format(new Date());
        //获取当前操作人员
        executor = (String)session.get("username");
        
        if((level.equals("0") || level.equals("1") && (Integer)session.get("authority") != 3) || (level.equals("2") || level.equals("3") && (Integer)session.get("authority") != 3 && (Integer)session.get("authority") != 2 ))
        {
    		message = "您没有该操作的权限!";
    		System.out.println(message);
    		return ERROR;
        }
        int key = AdminJdbc.banUser(username, executor, presentTime, durationTime, level);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public int getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
