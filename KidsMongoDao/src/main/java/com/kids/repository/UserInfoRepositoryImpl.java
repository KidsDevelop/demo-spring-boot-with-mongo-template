package com.kids.repository;

import com.kids.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserInfo> findAll() {
        return mongoTemplate.findAll(UserInfo.class);
    }

    @Override
    public UserInfo findById(String id) {
        return mongoTemplate.findById(id,UserInfo.class);
    }

    @Override
    public UserInfo findByUserName(String userName) {

        Criteria criteria = new Criteria();
        criteria.where("userName").is(userName);

        Query query = new Query();
        query.addCriteria(criteria);

        return mongoTemplate.findOne(query,UserInfo.class);
    }
}
