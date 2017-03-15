/*
package com.kids.exception;

import DefaultResponse;
import com.kids.service.exception.BusinessException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class KidsExceptionHandler {

    static final Logger logger = Logger.getLogger("kidscontroller");



    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ResponseEntity<DefaultResponse> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        DefaultResponse responseObj = new DefaultResponse();
        responseObj.setErrorCode("10000");
        responseObj.setErrorMessageEn(mobileError.getEnErrorMessage());
        responseObj.setErrorMessageTh(mobileError.getThErrorMessage());
        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
}
*/
