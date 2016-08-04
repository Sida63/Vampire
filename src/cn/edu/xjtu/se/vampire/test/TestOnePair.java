package cn.edu.xjtu.se.vampire.test;

import java.sql.Connection;

import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;

public class TestOnePair {
	public static void main(String[] args) throws Exception{
		Connection conn = JDBCUtil.getConnection();
		
		assert conn != null : "Connection to database failed";
		
		OnePair op = OnePair.Retrive("AdminGroupInfo", 1);
		assert op != null : "Can't retrive a OnePair";
	}
}
