package com.hly.videosys2.action;

import java.util.Map;

import com.hly.videosys2.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserManageAction extends BaseAction<Userinfo> implements ModelDriven<Userinfo> {
	
	private Userinfo userinfo;
	
	public String login(){
		System.out.println("进入登陆状态");
		System.out.println("账号：" + model.getUsername());
		System.out.println("密码：" + model.getPassword());
		if(userManageService.loginVerify(model)!=null)
		{
			userinfo = userManageService.loginVerify(model);
			session.put("userinfo", userinfo);
			System.out.println("状态：登陆成功！");
		}
		else
			System.out.println("登录失败！");
		return "index";
	}
	
	public String logout() {
        session.put("userinfo", null);
        System.out.println("退出登录成功！");
        return "index";
	}
	
	
/*   private String username;
   private String password;
   private String name;
   private int authority;
   // for action
   private String message;
   private String device = "";
   private String testAccount = "";

	public String login() {
		
		return device;
	   
	}
   
   
   public String execute() {
      String ret = ERROR;
      Connection conn = null;

      if (testAccount.equals("test"))
      {
    	  username = "test";
    	  password = "test";
      }
      try {
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
   }*/
}