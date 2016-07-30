package com.hly.videosys2.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Map;

import com.hly.videosys2.entity.*;
import com.hly.videosys2.service.CommentListService;
import com.opensymphony.xwork2.ModelDriven;

public class CommentManageAction extends BaseAction<Commentlist> implements ModelDriven<Commentlist> {

	int page = 1;
	
	//获得老师的所有视频的评论列表
	public String getTeacherCommentList() {
		Userinfo myinfo = (Userinfo) session.get("userinfo");
		//List<Integer> videoNumList = videoListService.getVideoListByUser(myinfo.getUsername());
		List<Commentlist> commentList = commentListService.getTeacherCommentList(myinfo.getUsername(), model.getCommentByUser(), "1", page);
		/*		Object[] a = new Object[2]; 
		List<Object> b = new ArrayList();
		HashMap c = new HashMap();*/
		String realName;
		for(int i = 0; i < commentList.size(); i++) {
			realName = userManageService.getRealName(commentList.get(i).getCommentByUser());
			commentList.get(i).setCommentTarget(realName);//暂时用target来显示真实姓名
			/*a[0] = commentList.get(i);
			a[1] = realName;
			b.add(a);*/
		}
		
		/*		for(int i = 0; i < videoNumList.size(); i++)  
        {  
			List<Commentlist> commentList = commentListService.commentReadByCondition(videoNumList.get(i), model.getCommentByUser(), model.getCommentShowSet(), page);
        }  */
		request.put("commentList", commentList);
		return "teacher";
	}
	
	//获得管理员的所有视频的评论列表
	public String getAdminCommentList() { 
		Userinfo myinfo = (Userinfo) session.get("userinfo");
		if(myinfo.getUserAuthority() == 3) {
			List<Commentlist> commentList = commentListService.commentReadByCondition(model.getVideoNum(), model.getCommentByUser(), "1", page);
			for(int i = 0; i < commentList.size(); i++) {
				String realName = userManageService.getRealName(commentList.get(i).getCommentByUser());
				commentList.get(i).setCommentTarget(realName);//暂时用target来显示真实姓名
			}
			request.put("commentList", commentList);
			return "admin";
		}
		return "index";
	}
	
	//获得管理员的待确认删除的评论列表
	public String getAdminCommentDeleteList() {  
		Userinfo myinfo = (Userinfo) session.get("userinfo");
		if(myinfo.getUserAuthority() == 3) {
			List<Commentlist> commentList = commentListService.commentReadByCondition(model.getVideoNum(), model.getCommentByUser(), "0", page);
			for(int i = 0; i < commentList.size(); i++) {
				String realName = userManageService.getRealName(commentList.get(i).getCommentByUser());
				commentList.get(i).setCommentTarget(realName);//暂时用target来显示真实姓名
			}
			request.put("commentList", commentList);
			return "adminDelete";
		}
		return "index";
	}
	
	//评论隐藏
	public String commentHide() {
		Userinfo myinfo = (Userinfo) session.get("userinfo");
		commentManageService.commentShowSet(model.getCommentNum(), "0");
		if(myinfo.getUserAuthority() == 2)
			return "toTeacher";
		else
			return "toAdmin";
	}
	
	//评论恢复
	public String commentShow() {
		Userinfo myinfo = (Userinfo) session.get("userinfo");
		commentManageService.commentShowSet(model.getCommentNum(), "1");
		if(myinfo.getUserAuthority() == 2)
			return "toTeacherDelete";
		else
			return "toAdminDelete";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
