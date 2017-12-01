package cn.huhuiyu.dao;

import java.sql.Connection;

public abstract class BaseDAO {
	protected Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
