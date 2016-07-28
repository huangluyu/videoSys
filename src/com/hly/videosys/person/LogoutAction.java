package com.hly.videosys.person;

import java.sql.Connection;
import java.util.Map;

import com.hly.videosys.common.JdbcMysql;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	//for action
	public String device = "pc";
	
	public String execute() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("username", null);
        session.put("realName", null);
        session.put("authority", null);
        if(device.equals("mobile"))
        	return "mIndex";
        else
        	return "index";
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
}
