package com.kids.ws;

import com.kids.dao.model.UserInfo;
import com.kids.dao.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoRest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
    public ResponseEntity<List<UserInfo>> doProcess(){

        List<UserInfo> responseObj = userInfoRepository.findAll();

        System.out.println("MONGO DB");

        return new ResponseEntity<>(responseObj,HttpStatus.OK);
    }

}
