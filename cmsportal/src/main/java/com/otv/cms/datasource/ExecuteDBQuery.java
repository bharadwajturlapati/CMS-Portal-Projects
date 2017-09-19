package com.otv.cms.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otv.cms.builders.SuccessResponseEntityBuilder;
import com.otv.cms.web.pojo.Response.AuthFailureResponseContentEntity;
import com.otv.cms.web.pojo.Response.AuthSuccessResponseContentEntity;
import com.otv.cms.web.pojo.Response.SuccessResponseEntity;

public final class ExecuteDBQuery {
  private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

  private ExecuteDBQuery() {

  }

  /* Build this json string using google gson */
  public static SuccessResponseEntity executeLogin(String sql, String hashedCode) {

    AuthSuccessResponseContentEntity authSuccessResponseContentEntity = null;
    AuthFailureResponseContentEntity authFailureResponseContentEntity = null;

    try (Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();) {

      if (resultSet.next()) {
        authSuccessResponseContentEntity = new AuthSuccessResponseContentEntity();
        authSuccessResponseContentEntity.setAuthStatus("success");
        authSuccessResponseContentEntity.setHashedCode(hashedCode);
        return new SuccessResponseEntityBuilder()
            .withHttpStatusCode("200")
            .withReponseContent(gson.toJson(authSuccessResponseContentEntity,
                AuthSuccessResponseContentEntity.class))
            .build();
      } else {
        authFailureResponseContentEntity = new AuthFailureResponseContentEntity();
        authFailureResponseContentEntity.setAuthStatus("failure");
        return new SuccessResponseEntityBuilder()
            .withHttpStatusCode("200")
            .withReponseContent(gson.toJson(authFailureResponseContentEntity))
            .build();
      }
    } catch (Exception e) {
      authFailureResponseContentEntity = new AuthFailureResponseContentEntity();
      authFailureResponseContentEntity.setAuthStatus("failure");
      return new SuccessResponseEntityBuilder()
          .withHttpStatusCode("500")
          .withReponseContent(gson.toJson(authFailureResponseContentEntity))
          .build();
    }
  }
}
