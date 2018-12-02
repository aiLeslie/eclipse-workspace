package com.leslie.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryTest {
	public static void main(String[] args) throws SQLException {
		System.out.println("连接数据库");

		Connector connector = new Connector.Builder().host("localhost").port("3306").user("root").pwd("980517").build();

		ResultSet results = connector.statement().executeQuery("select * from mybase.info;");

		System.out.println(results.toString());

		while (results.next()) {
			String id = results.getString("name");
			System.out.println(id);
		}
		
		connector.close();
	}
}
