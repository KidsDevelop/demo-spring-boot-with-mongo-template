package com.kids.dao.repository;

import com.kids.dao.model.UserInfo;

import java.util.List;

public interface UserInfoRepository {

    List<UserInfo> findAll();

    UserInfo findById(String id);

    UserInfo findByUserName(String userName);

}
