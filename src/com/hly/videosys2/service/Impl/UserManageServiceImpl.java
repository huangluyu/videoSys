package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Userinfo;
import com.hly.videosys2.service.UserManageService;

public class UserManageServiceImpl extends BaseServiceImpl<Userinfo> implements UserManageService {

	//登陆验证
	@Override
	public Userinfo loginVerify(Userinfo user) {
		// TODO Auto-generated method stub
		String hql = "from Userinfo u where u.username=:username and u.password=:password";
		return (Userinfo) getSession().createQuery(hql) //  
		        .setString("username", user.getUsername()) //  
		        .setString("password", user.getPassword()) //  
		        .uniqueResult();
	}
	
	//获取所有老师列表
	public List<Userinfo> getTeacherList() {
		String hql = "from Userinfo u where u.userAuthority = 2";
		return getSession().createQuery(hql).list();
	}
	
	//获得真实姓名
	public String getRealName(String username) {
		String hql = "select u.realName from Userinfo u where u.username = :username";
		return (String) getSession().createQuery(hql)
				.setString("username", username)
				.uniqueResult();
	}
	
	/*public static ResultSet getTeacherList()  throws Exception {
		String sql="select * from userinfo where userAuthority = 2";
		PreparedStatement pstmt=JdbcMysql.conn().prepareStatement(sql);
		return pstmt.executeQuery();
	}*/
}
