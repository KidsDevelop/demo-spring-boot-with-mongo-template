package com.kids.ws.user;

import com.kids.bean.user.GetUserInfoRequest;
import com.kids.dao.model.UserInfo;
import com.kids.dao.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class GetUserInfoRestController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping("getUser")
    public ResponseEntity<UserInfo> doProcess(
            @RequestHeader(value = "appId") String appID,
            @RequestBody GetUserInfoRequest requestBody,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
    ){

        UserInfo responseObj = userInfoRepository.findByUserName(requestBody.getUserName());

        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
}
