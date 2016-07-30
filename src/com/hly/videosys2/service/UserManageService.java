package com.hly.videosys2.service;

import java.util.List;

import com.hly.videosys2.entity.Userinfo;

public interface UserManageService extends BaseService<Userinfo>{
	
	public Userinfo loginVerify(Userinfo user);
	
	public List<Userinfo> getTeacherList() ;

	public String getRealName(String commentByUser);
}
