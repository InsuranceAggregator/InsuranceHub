package com.homeinsurance.entity;

public class Response {
	private String statusCode;
	private String statusMsg;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", statusMsg=" + statusMsg + "]";
	}
	public Response() {
		super();
	}
	public Response(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}
}
