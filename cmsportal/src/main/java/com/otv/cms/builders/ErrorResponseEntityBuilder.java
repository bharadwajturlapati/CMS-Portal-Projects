package com.otv.cms.builders;

import com.otv.cms.web.pojo.Response.ErrorResponseEntity;

public class ErrorResponseEntityBuilder {

  private ErrorResponseEntity errorResponseEntity;

  public ErrorResponseEntityBuilder() {
    this.errorResponseEntity = new ErrorResponseEntity();
  }

  public ErrorResponseEntityBuilder withErrorMessage(String errorMessage) {
    this.errorResponseEntity.setErrorMessage(errorMessage);
    return this;
  }

  public ErrorResponseEntityBuilder withHttpStatusCode(String httpStatusCode) {
    this.errorResponseEntity.setHttpStatusCode(httpStatusCode);
    return this;
  }

  public ErrorResponseEntityBuilder withErrorCode(String errorCode) {
    this.errorResponseEntity.setErrorCode(errorCode);
    return this;
  }

  public ErrorResponseEntityBuilder withErrorType(String errorType) {
    this.errorResponseEntity.setErrorType(errorType);
    return this;
  }

  public ErrorResponseEntityBuilder withRequestId(String requestId) {
    this.errorResponseEntity.setRequestID(requestId);
    return this;
  }

  public ErrorResponseEntity build() {
    return this.errorResponseEntity;
  }
}
