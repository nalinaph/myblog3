package com.myblog.myblog3;

public class TestLogin {
    private String userName;
    private String passWord;

    public TestLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
