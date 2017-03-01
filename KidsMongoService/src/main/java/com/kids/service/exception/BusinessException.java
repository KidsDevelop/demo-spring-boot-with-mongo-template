package com.kids.service.exception;

public class BusinessException extends RuntimeException{

    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg){
        super(new Exception(errorMsg));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
