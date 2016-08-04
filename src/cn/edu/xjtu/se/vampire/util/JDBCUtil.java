package cn.edu.xjtu.se.vampire.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	private static String  DB_DRIVER = null;
	private static String  DB_USER = null;
	private static String  DB_URL = null;
	private static String  DB_PASSWORD = null;
	
	static{
		DB_DRIVER = DBConfig.getInstance().getValues("db_driver");
		DB_USER = DBConfig.getInstance().getValues("db_userName");
		DB_URL = DBConfig.getInstance().getValues("db_url");
		DB_PASSWORD = DBConfig.getInstance().getValues("db_password");
	}
	public static Connection getConnection() throws Exception{
		// 流  输入 InputStream
		Class.forName(DB_DRIVER);
		//获得连接
		return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	
		
	}
	
	public static void closes(ResultSet rs ,Statement st,Connection conn){
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
}
	
	
	

