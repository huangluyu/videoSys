package com.hly.videosys2.service.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	@Override
	public List<Userinfo> getTeacherList() {
		String hql = "from Userinfo u where u.userAuthority = 2";
		return getSession().createQuery(hql).list();
	}
	
	//获得真实姓名
	@Override
	public String getRealName(String username) {
		String hql = "select u.realName from Userinfo u where u.username = :username";
		return (String) getSession().createQuery(hql)
				.setString("username", username)
				.uniqueResult();
	}
	
	//获得用户列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> getUserList(String username, String realName, String email, String mobilePhoneNum, String userAuthority, int page) {
		String hql = "from Userinfo u where u.username = :username "
				+ "or u.realName = :realName "
				+ "or u.email = :email "
				+ "or u.mobilePhoneNum = :mobilePhoneNum "
				+ "or u.userAuthority like :userAuthority";
		return getSession().createQuery(hql)
				.setString("username", username)
				.setString("realName",realName )
				.setString("email",email )
				.setString("mobilePhoneNum", mobilePhoneNum)
				.setString("userAuthority", userAuthority)
		        .setFirstResult((page - 1) * 10)
		        .setMaxResults(page * 10)
				.list();
	}
}
