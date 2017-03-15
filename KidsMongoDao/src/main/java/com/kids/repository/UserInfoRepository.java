package com.kids.repository;

import com.kids.model.UserInfo;

import java.util.List;

public interface UserInfoRepository {

    List<UserInfo> findAll();

    UserInfo findById(String id);

    UserInfo findByUserName(String userName);

}
