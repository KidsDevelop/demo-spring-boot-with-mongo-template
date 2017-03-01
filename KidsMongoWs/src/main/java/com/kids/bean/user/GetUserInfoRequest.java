package com.kids.bean.user;

import java.io.Serializable;

public class GetUserInfoRequest implements Serializable {

    private static final long serialVersionUID = -6998292738570563570L;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
