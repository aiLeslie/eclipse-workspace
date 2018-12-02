package com.leslie.mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeTest {
	/**
	 * 时间格式 yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @return
	 */
	public static Timestamp dateStringToLong(String date) {
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	public static void main(String[] args) throws SQLException {
		System.out.println("连接数据库");

		Connector connector = new Connector.Builder().host("localhost").port("3306").user("root").pwd("980517").build();

		connector.connection().setAutoCommit(false);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Date date = new Date(System.currentTimeMillis());
		

		// 批量操作 插入多行数据
		String sql = "INSERT INTO `mybase`.`info` (`name`, `age`, `desc`,`regTime` ) VALUES ('Leslie', '28', 'hello', ?);";
		PreparedStatement prepareStatement = null;
		prepareStatement = connector.connection().prepareStatement(sql);
		for (int i = 0; i < 1000; i++) {
			
			timestamp.setTime(System.currentTimeMillis());
			
			date.setTime(System.currentTimeMillis());
			
			prepareStatement.setObject(1, date);
			
			prepareStatement.execute();
		}
		
		prepareStatement.close();
		
		sql = "select * from mybase.info WHERE (regTime > ?);";
		prepareStatement = connector.connection().prepareStatement(sql);
		prepareStatement.setObject(1, dateStringToLong("2018-11-28 23:00:00"));
		ResultSet set = connector.statement().executeQuery(sql);
		
		while (set.next()) {
			System.out.println("11");
		}


		connector.connection().commit();
//		
//		connector.connection()
		
		

		connector.close();
	}
}
