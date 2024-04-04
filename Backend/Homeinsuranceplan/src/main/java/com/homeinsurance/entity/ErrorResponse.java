package com.homeinsurance.entity;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	public String apiPath;
	private HttpStatus errorCode;
	private String errorMsg;
	private LocalDateTime errorTime;
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(String apiPath, HttpStatus errorCode, String errorMsg, LocalDateTime errorTime) {
		super();
		this.apiPath = apiPath;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorTime = errorTime;
	}
	public String getApiPath() {
		return apiPath;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public LocalDateTime getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}
	@Override
	public String toString() {
		return "ErrorResponse [apiPath=" + apiPath + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg
				+ ", errorTime=" + errorTime + "]";
	}
}
