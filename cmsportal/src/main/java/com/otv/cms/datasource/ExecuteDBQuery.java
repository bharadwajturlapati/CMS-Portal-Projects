package com.otv.cms.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.otv.cms.builders.SuccessResponseEntityBuilder;
import com.otv.cms.web.pojo.Response.SuccessResponseEntity;

public final class ExecuteDBQuery {
  private ExecuteDBQuery() {

  }

  public static SuccessResponseEntity executeLogin(String sql) {
    ResultSet resultSet = null;

    try {
      resultSet = getResultSetFromSql(sql);

      if (resultSet.next()) {
        return new SuccessResponseEntityBuilder()
            .withHttpStatusCode("200")
            .withReponseContent("{'authStatus':'success'}")
            .build();
      } else {
        return new SuccessResponseEntityBuilder()
            .withHttpStatusCode("200")
            .withReponseContent("{'authStatus':'failure'}")
            .build();
      }
    } catch (Exception e) {
      return new SuccessResponseEntityBuilder()
          .withHttpStatusCode("200")
          .withReponseContent("{'authStatus':'failure'}")
          .build();
    }
  }

  private static ResultSet getResultSetFromSql(String sql) {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = ConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return resultSet;
  }
}
