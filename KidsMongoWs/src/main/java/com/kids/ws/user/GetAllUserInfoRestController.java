package com.kids.ws.user;

import com.kids.model.UserInfo;
import com.kids.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllUserInfoRestController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("getAllUser")
    public ResponseEntity<List<UserInfo>> doProcess(){

        List<UserInfo> responseObj = userInfoRepository.findAll();

        return new ResponseEntity<>(responseObj,HttpStatus.OK);
    }

}
