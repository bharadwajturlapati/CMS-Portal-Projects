package com.otv.cms.web.pojo.Response;

public class SuccessResponseEntity extends AbstractResponseEntity {

  private Object responseContent = "";

  public Object getResponseContent() {
    return responseContent;
  }

  public void setResponseContent(Object responseContent) {
    this.responseContent = responseContent;
  }
}
