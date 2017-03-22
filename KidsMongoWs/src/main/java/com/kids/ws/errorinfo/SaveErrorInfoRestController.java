package com.kids.ws.errorinfo;

import com.kids.model.ErrorInfo;
import com.kids.repository.ErrorInfoRepository;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveErrorInfoRestController {

    @Autowired
    private ErrorInfoRepository errorInfoRepository;


    @GetMapping("saveError")
    public ResponseEntity<Void> doProcess(){

        /*ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode("10002");
        errorInfo.setErrorMessageEn("ErrorMSG");
        errorInfo.setErrorMessageTh("พลาดแล้วไอน้อง");
        errorInfo.setCreateDate(LocalDateTime.now().toDate());
        errorInfo.setCreateBy("Admin");

        errorInfoRepository.save(errorInfo);*/


        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setId("58b407d7061b9a22745a87cf");
        errorInfo.setErrorCode("1222");
        errorInfo.setErrorMessageTh("มานะจ๊ะGG");
        errorInfo.setErrorMessageEn("mana Ja GG");
        errorInfo.setModifyDate(LocalDateTime.now().toDate());
        errorInfo.setModifyBy("Ten Admin GG");

        ErrorInfo errorInfo1 = errorInfoRepository.update(errorInfo);

        System.out.println(errorInfo1.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
