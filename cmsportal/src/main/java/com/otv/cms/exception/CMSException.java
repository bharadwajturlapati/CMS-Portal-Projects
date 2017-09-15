package com.otv.cms.exception;

import com.otv.cms.web.pojo.Response.AbstractResponseEntity;

public class CMSException extends Exception {

  private static final long serialVersionUID = 1L;
  private AbstractResponseEntity abstractResponseEntity;

  public CMSException(AbstractResponseEntity abstractResponseEntity) {
    this.abstractResponseEntity = abstractResponseEntity;
  }

  public AbstractResponseEntity getAbstractResponseEntity() {
    return this.abstractResponseEntity;
  }
}
