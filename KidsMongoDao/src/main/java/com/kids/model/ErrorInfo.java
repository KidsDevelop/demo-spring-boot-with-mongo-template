package com.kids.dao.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ErrorInfo extends DefaultModel {

    private static final long serialVersionUID = 5300770146236915183L;

    //@Indexed(unique = true)
    private String errorCode;
    private String errorMessageTh;
    private String errorMessageEn;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageTh() {
        return errorMessageTh;
    }

    public void setErrorMessageTh(String errorMessageTh) {
        this.errorMessageTh = errorMessageTh;
    }

    public String getErrorMessageEn() {
        return errorMessageEn;
    }

    public void setErrorMessageEn(String errorMessageEn) {
        this.errorMessageEn = errorMessageEn;
    }

    @Override
    public String toString() {
        return  super.toString() + "ErrorInfo{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessageTh='" + errorMessageTh + '\'' +
                ", errorMessageEn='" + errorMessageEn + '\'' +
                '}';
    }
}
