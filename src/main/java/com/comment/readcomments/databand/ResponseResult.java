package com.comment.readcomments.databand;

import java.util.List;

public class ResponseResult {
	private String status;
	private Object body;
	private List<String> errMsgs;

	public ResponseResult(String status, Object body, List<String> errMsgs) {
		this.status = status;
		this.body = body;
		this.errMsgs = errMsgs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public List<String> getErrMsgs() {
		return errMsgs;
	}

	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}
	
}
