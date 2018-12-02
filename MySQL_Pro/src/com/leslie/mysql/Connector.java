package com.leslie.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private Connection mConnection;
	private Statement mStatement;
	
	
	private Connector(Connection Connection) {
		
		try {
			mConnection = Connection;
			mStatement = mConnection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Statement statement() {
		return mStatement;
	}

	public Connection connection() {
		return mConnection;
	}
	
	public void close() {
		
		try {
			if (mStatement != null && !mStatement.isClosed()) {
				mStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try {
//			if (mConnection != null && !mConnection.isClosed()) {
//				mConnection.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	


	public static class Builder{
		private String host;
		private String port;
		private String user;
		private String pwd;
		public String getHost() {
			return host;
		}
		public Builder host(String host) {
			this.host = host;
			return this;
		}
		public String getPort() {
			return port;
		}
		public Builder port(String port) {
			this.port = port;
			return this;
		}
		public String getUser() {
			return user;
		}
		public Builder user(String user) {
			this.user = user;
			return this;
		}
		public String getPwd() {
			return pwd;
		}
		public Builder pwd(String pwd) {
			this.pwd = pwd;
			return this;
		}
		public Connector build() {
			return new Connector(prepareDriver());
		}
		
		private Connection prepareDriver()  {
			Connection connection = null;
			try {
				// ����������
				Class.forName("com.mysql.cj.jdbc.Driver");
				// ��ȡ���ݿ�����Ӷ��� (���� ����·�ɵ�ַ �˿ں� �û��� ����)
				connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s?serverTimezone=UTC", host,port),user,pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return connection;
		}
	}
}
