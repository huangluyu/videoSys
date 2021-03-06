package com.hly.videosys2.service;

import java.util.List;

import com.hly.videosys2.entity.Userinfo;

public interface UserManageService extends BaseService<Userinfo>{
	
	Userinfo loginVerify(Userinfo user);
	
	List<Userinfo> getTeacherList() ;

	String getRealName(String commentByUser);
	
	List<Userinfo> getUserList(String username, String realName, String email,
			String mobilePhoneNum, String userAuthority, int page);
}
