package com.otv.cms.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class ConnectionPool {
  private static DataSource dataSource;

  private ConnectionPool() {

  }

  public static DataSource getDataSource() {
    if (dataSource == null) {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl("jdbc:mysql://localhost:3306/cmsdb");
      config.setUsername("root");
      config.setPassword("kony@1234");
      config.setMaximumPoolSize(10);
      config.setAutoCommit(false);
      config.addDataSourceProperty("prepStmtCacheSize", "250");
      config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
      config.addDataSourceProperty("cachePrepStmts", "true");

      dataSource = new HikariDataSource(config);
    }
    return dataSource;
  }

  /**
   * Move this to try catch block using error response entity handler throws
   * CMSException
   * 
   * @return
   * @throws SQLException
   */
  public static Connection getConnection() throws SQLException {
    return getDataSource().getConnection();
  }
}
