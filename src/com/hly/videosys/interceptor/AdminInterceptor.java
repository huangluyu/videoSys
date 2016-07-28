package com.hly.videosys.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hly.videosys2.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {
	private String message;

	public String intercept(ActionInvocation invocation) throws Exception 
	{
		ActionContext ac = invocation.getInvocationContext();
		Map session = (Map)ac.get(ServletActionContext.SESSION);

		if (session == null) {
			message = "该功能需要登录,请登录后再试!";
			return "login";
		} else {
			if ((Userinfo)session.get("userinfo") == null) {
				message = "该功能需要登录,请登录后再试!";
				return "login";
			} else if((Integer)((Userinfo)session.get("userinfo")).getUserAuthority() == 3){
				return invocation.invoke();
			} else {
				message = "您没有该功能的权限!";
				return "login";
			}
		}
	}
}
