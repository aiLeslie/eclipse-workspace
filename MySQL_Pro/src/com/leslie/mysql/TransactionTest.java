package com.leslie.mysql;

import java.sql.SQLException;

public class TransactionTest {
	public static void main(String[] args) throws SQLException {
		System.out.println("�������ݿ�");

		Connector connector = new Connector.Builder().host("localhost").port("3306").user("root").pwd("980517").build();
		//  Ĭ���Զ��ύ jdbc
		connector.connection().setAutoCommit(false);
		
		// �������� �����������
		
		for (int i = 0; i < 1000; i++) {
			connector.statement().addBatch("INSERT INTO `mybase`.`info` (`name`, `age`, `desc`) VALUES ('Leslie', '28', 'hello');");
		}
		// ������� (�������ݿ�ع�) connector.connection().rollback();
//		connector.statement().addBatch("INSERT INTO `mybase`.`info` (`name`, `age`, `desc`) VALUES ( '28', 'hello');");
		
		connector.statement().executeBatch();
		
		connector.connection().commit();
		
		connector.close();
	}
}
