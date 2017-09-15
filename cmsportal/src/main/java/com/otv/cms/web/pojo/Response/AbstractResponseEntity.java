package com.otv.cms.web.pojo.Response;

public abstract class AbstractResponseEntity {
  // default 500
  private String httpStatusCode = "500";

  public String getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(String httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }
}
