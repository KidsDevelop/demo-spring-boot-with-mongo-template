package com.kids.dao.repository;

import com.kids.dao.model.UserInfo;

import java.util.List;

public interface UserInfoRepository {

    List<UserInfo> findAll();

    UserInfo findByField(String field,Object value);

}
