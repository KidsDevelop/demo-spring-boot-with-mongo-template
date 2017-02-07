package com.kids.dao.repository;

import com.kids.dao.model.UserInfo;
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
    public UserInfo findByField(String field, Object value) {

        Criteria criteria = new Criteria();

        Query query = new Query();
        query.addCriteria(criteria);

        return mongoTemplate.findById(query,UserInfo.class);
    }
}
