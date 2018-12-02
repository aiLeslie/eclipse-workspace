package com.leslie.mysql;

import java.sql.SQLException;

public class BatchTest {
	public static void main(String[] args) throws SQLException {
		System.out.println("�������ݿ�");

		Connector connector = new Connector.Builder().host("localhost").port("3306").user("root").pwd("980517").build();

		connector.connection().setAutoCommit(false);
		
		

		// �������� �����������

		for (int i = 0; i < 1000; i++) {
			connector.statement()
					.addBatch("INSERT INTO `mybase`.`info` (`name`, `age`, `desc`,`regTime` ) VALUES ('Leslie', '28', 'hello', timestamp);");
		}

		connector.statement().executeBatch();

		connector.connection().commit();
//		
//		connector.connection()
		
		

		connector.close();
	}
}
