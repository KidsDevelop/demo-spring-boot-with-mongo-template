package com.kids.repository;

import com.kids.model.ErrorInfo;

import java.util.List;

public interface ErrorInfoRepository {

    List<ErrorInfo> findAll();

    ErrorInfo findByErrorCode(String errorCode);

    ErrorInfo update(ErrorInfo errorInfo);

    void save(ErrorInfo errorInfo);

    void saveAll(List<ErrorInfo> errorInfoList);

    void delete(ErrorInfo errorInfo);

    void deleteAll();

}
