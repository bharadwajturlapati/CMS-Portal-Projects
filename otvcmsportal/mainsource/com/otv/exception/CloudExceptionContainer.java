package com.otv.exception;

import com.amazonaws.AmazonServiceException.ErrorType;

public class CloudExceptionContainer extends Exception {
	private static final long serialVersionUID = 1L;

	private String httpStatusCode = "";
	private String errorCode = "";
	private String errorType = "";
	private String requestId = "";

	public CloudExceptionContainer(String exceptionMessage, String httpStatusCode, String errorCode, String errorType,
			String requestID, Throwable exception) {
		super(exceptionMessage, exception);
		this.httpStatusCode = httpStatusCode;
		this.errorCode = errorCode;
		this.errorType = errorType;
		this.requestId = requestID;
	}

	public CloudExceptionContainer(String exceptionMessage, int httpStatusCode, String errorCode,
			ErrorType errorTypeInstance, String requestID) {
		super(exceptionMessage);
		this.httpStatusCode = String.valueOf(httpStatusCode);
		this.errorCode = errorCode;
		this.errorType = errorTypeInstance.toString();
		this.requestId = requestID;
	}

	public String getErrorMessage() {
		return getMessage();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public String getErrorType() {
		return errorType;
	}

	public String getRequestId() {
		return requestId;
	}
}
