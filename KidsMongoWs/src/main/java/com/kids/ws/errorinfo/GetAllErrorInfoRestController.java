package com.kids.ws.errorinfo;

import com.kids.model.ErrorInfo;
import com.kids.repository.ErrorInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllErrorInfoRestController {

    @Autowired
    private ErrorInfoRepository errorInfoRepository;

    @GetMapping("getAllError")
    public ResponseEntity<List<ErrorInfo>> doProcess(){

        List<ErrorInfo> responseObj = errorInfoRepository.findAll();

        return new ResponseEntity<>(responseObj,HttpStatus.OK);
    }

}
