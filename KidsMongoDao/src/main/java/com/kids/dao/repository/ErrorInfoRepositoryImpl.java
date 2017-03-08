package com.kids.dao.repository;

import com.kids.dao.model.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ErrorInfoRepositoryImpl implements ErrorInfoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<ErrorInfo> findAll() {
        return mongoTemplate.findAll(ErrorInfo.class);
    }

    @Override
    public ErrorInfo findByErrorCode(String errorCode) {

        Query query = new Query();
        query.addCriteria(Criteria.where("errorCode").is(errorCode));

        return mongoTemplate.findOne(query,ErrorInfo.class);
    }

    @Override
    public ErrorInfo update(ErrorInfo errorInfo) {

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(errorInfo.getId()));

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Update update = new Update();
        update.set("errorCode",errorInfo.getErrorCode());
        update.set("errorMessageTh",errorInfo.getErrorMessageTh());
        update.set("errorMessageEn",errorInfo.getErrorMessageEn());
        update.set("modifyDate", errorInfo.getModifyDate());
        update.set("modifyBy", errorInfo.getModifyBy());

        return mongoTemplate.findAndModify(query,update,options,ErrorInfo.class);
    }

    @Override
    public void save(ErrorInfo errorInfo) {
        mongoTemplate.insert(errorInfo);
    }

    @Override
    public void saveAll(List<ErrorInfo> errorInfoList) {
        mongoTemplate.insertAll(errorInfoList);
    }

    @Override
    public void delete(ErrorInfo errorInfo) {
        mongoTemplate.remove(errorInfo);
    }

    @Override
    public void deleteAll() {
        Query query = new Query();
        mongoTemplate.remove(query,ErrorInfo.class);
    }


}
