package com.hly.videosys.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hly.videosys.person.UserList;
import com.opensymphony.xwork2.ActionSupport;

public class UserListForAdminAction extends ActionSupport {
	private List userListForAdmin = new ArrayList();
	private String username;
	private String realName;
	private String authority;
	private int page = 1;
	private int pageSum;

	public String execute() throws Exception {
		ResultSet rs = AdminJdbc.userListRead(username, realName, authority, page);
		pageSum = AdminJdbc.userListNumRead(username, realName, authority);
		while(rs.next()){
			UserList ulist = new UserList();
			ulist.setUsername(rs.getString("用户名"));
			ulist.setRealName(rs.getString("真实姓名"));
			ulist.setAuthority(rs.getString("用户权限"));
			ulist.setMoney(rs.getString("积分"));
			userListForAdmin.add(ulist);
		}
		return SUCCESS;
	}

	public List getUserListForAdmin() {
		return userListForAdmin;
	}

	public void setUserListForAdmin(List userListForAdmin) {
		this.userListForAdmin = userListForAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
}
