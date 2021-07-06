package com.comment.readcomments.advice;

import com.comment.readcomments.databand.ResponseResult;
import com.comment.readcomments.exception.ValidationErrorException;
import com.example.demo1.code.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(ValidationErrorException.class)
	@ResponseBody
	public ResponseResult handleValidationException(ValidationErrorException e) {
		return new ResponseResult(ResponseStatus.VALIDATION_ERROR.getCode(), null, e.getErrorMsg());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseResult handleException(Exception e) {
		return new ResponseResult(ResponseStatus.ERROR.getCode(), null, null);
	}
}
