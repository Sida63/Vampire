package cn.edu.xjtu.se.vampire.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {
	
	private static DBConfig dbConfig = null;
	private Properties pro = new Properties();
	private DBConfig(){
		readConfig();
		
	}
	
	public synchronized static DBConfig getInstance(){
		if(dbConfig == null){
			dbConfig = new DBConfig();
		}
		return dbConfig;
	}
	
	private  void readConfig(){
		try {
			pro.load(new FileInputStream("dbinfo.properties"));
			//pro.load(DBConfig.class.getClassLoader().getResourceAsStream("./dbinfo.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValues(String key){
			return pro.getProperty(key);
	}
}