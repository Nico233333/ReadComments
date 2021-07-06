package com.example.demo1.code;

public enum ResponseStatus {
	SUCCESS("success","请求成功"),
	VALIDATION_ERROR("validationError","check失败"),
	ERROR("error","内部错误");

	private final String code;
	private final String descreption;
	
	ResponseStatus(String code, String descreption) {
		this.code = code;
		this.descreption = descreption;
	}

	public String getCode() {
		return code;
	}

	public String getDescreption() {
		return descreption;
	}
}
