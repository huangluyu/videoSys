package com.hly.videosys.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hly.videosys.common.JdbcMysql;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
   private String username;
   private String password;
   private String name;
   private int authority;
   // for action
   private String message;
   private String device = "";
   private String testAccount = "";

   public String execute() {
      String ret = ERROR;
      Connection conn = null;

      if (testAccount.equals("test"))
      {
    	  username = "test";
    	  password = "test";
      }
      try {
    	  System.out.println("@2");
         conn = JdbcMysql.conn();
         String sql = "SELECT * FROM 用户表 WHERE 用户名 = ? AND 密码 = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, username);
         ps.setString(2, password);
         
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
        	 ActionContext actionContext = ActionContext.getContext();
             Map session = actionContext.getSession();
             session.put("username", username);
             authority = rs.getInt("用户权限");
             session.put("authority", authority);
             session.put("realName", rs.getString("真实姓名"));
             session.put("money", rs.getString("积分"));
             if(device.equals("mobile"))
            	 ret = "mIndex";
        	 else
        		 ret = "index";
         } else 
        	 message = "错误的登录名或密码";
      } catch (Exception e) {
    	  message = "未知的错误发生了,请联系管理员!错误码:loginAction!";
      } finally {
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
            }
         }
      }
      
      return ret;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAuthority() {
      return authority;
   }

   public void setAuthority(int authority) {
      this.authority = authority;
   }

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getTestAccount() {
		return testAccount;
	}

	public void setTestAccount(String testAccount) {
		this.testAccount = testAccount;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
}