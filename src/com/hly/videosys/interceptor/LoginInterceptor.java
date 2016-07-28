package com.hly.videosys.interceptor;

import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	private String message;
	
	public String intercept(ActionInvocation invocation) throws Exception 
	{
		String name = invocation.getInvocationContext().getName();
		if (name.equals("loginAction")) {
			return invocation.invoke();
		} else {
			ActionContext ac = invocation.getInvocationContext();
			Map session = (Map)ac.get(ServletActionContext.SESSION);

			if (session == null) {
				message = "该功能需要登录,请登录后再试!";
				return "loginTest";
			} else {
				if (session.get("userinfo") == null) {
					message = "该功能需要登录,请登录后再试!";
					return "loginTest";
				} else {
					return invocation.invoke();
				}
			}
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
