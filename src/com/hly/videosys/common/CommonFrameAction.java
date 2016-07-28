package com.hly.videosys.common;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommonFrameAction extends ActionSupport {
	private String info;
	private String realName;
	private String username;
	private String authority;
	private String money;
	
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if (session.get("username") == null)
        	info = "visitor";
        else {
            username = session.get("username").toString();
        	authority = session.get("authority").toString();
        	realName = session.get("realName").toString();
        	money = session.get("money").toString();
        	if (authority.equals("2"))
        		info = "teacher";
        	else if (authority.equals("1"))
        		info = "student";
        	else
        		info = "visitor";
        }
        return SUCCESS;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
}
