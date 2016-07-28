package com.hly.videosys2.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hly.videosys.common.JdbcMysql;
import com.hly.videosys2.entity.Videoinfo;

public interface IndexService extends BaseService<Videoinfo> {
	  
	  public List<Videoinfo> getVideoFreeList();
	  
	  public List<Videoinfo> getVideoPayList();
	  
	  public List<Videoinfo> getVideoNewList();
	  
	  public List<Videoinfo> getVideoGradeNewList(String grade);
		
}
