package com.otv.cms.builders;

import com.otv.cms.web.pojo.Response.SuccessResponseEntity;

public class SuccessResponseEntityBuilder {
  private SuccessResponseEntity successResponseEntity;

  public SuccessResponseEntityBuilder() {
    this.successResponseEntity = new SuccessResponseEntity();
  }

  public SuccessResponseEntityBuilder withReponseContent(Object responseContent) {
    this.successResponseEntity.setResponseContent(responseContent);
    return this;
  }

  public SuccessResponseEntityBuilder withHttpStatusCode(String httpStatusCode) {
    this.successResponseEntity.setHttpStatusCode(httpStatusCode);
    return this;
  }

  public SuccessResponseEntity build() {
    return this.successResponseEntity;
  }
}
