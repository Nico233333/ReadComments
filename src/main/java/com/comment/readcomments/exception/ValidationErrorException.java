package com.comment.readcomments.exception;

import org.springframework.stereotype.Component;

import java.util.List;

public class ValidationErrorException extends RuntimeException{
    private static final long serialVersionUID=1L;
    List<String> errorMsg;

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }
    public ValidationErrorException(List<String> errorMsg){
        this.errorMsg = errorMsg;
    }
}
