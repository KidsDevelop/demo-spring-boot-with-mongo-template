package com.kids.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class DefaultModel implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    @JsonIgnore
    private Date createDate;

    @JsonIgnore
    private Date modifyDate;

    @JsonIgnore
    private String createBy;

    @JsonIgnore
    private String modifyBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public String toString() {
        return "DefaultModel{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", createBy='" + createBy + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                '}';
    }
}
