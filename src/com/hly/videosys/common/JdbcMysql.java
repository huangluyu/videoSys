package com.hly.videosys.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMysql {
	public static Connection conn(){
		Connection conn = null;
		while(conn==null){
		String URL = "jdbc:mysql://localhost:3306/videosys?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "abc2384985");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		/*//创建数据源对象
		BasicDataSource dataSource = new BasicDataSource();
		
		//必要数据
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/videosys?useUnicode=true&characterEncoding=utf-8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("abc2384985");
		
		//设置一些额外的属性
		//初始化连接数
		//dataSource.setInitialSize(10);
		//设置最大连接数
		//dataSource.setMaxActive(50);
		//设置最小连接数
		//dataSource.setMinIdle(10);
		//设置超时自动关闭连接
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(1000);
		conn = dataSource.getConnection();*/
		return conn;
	}
}
