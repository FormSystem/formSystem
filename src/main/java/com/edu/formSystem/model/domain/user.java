package com.edu.formSystem.model.domain;

/**
 * @author zr
 * @program: formSystem
 * @Title: user
 * @package: com.edu.formSystem
 * @description: 用户实体类
 */
public class user {
    /*用户id*/
    private String userId;
    /*用户名*/
    private String userName;
    /*用户密码*/
    private String userPassword;
    /*用户邮箱*/
    private String userEmail;
    /*用户等级:0（超级管理员）1（注册用户） */
    private String userPower;

    public user(String userId, String userName, String userPassword, String userEmail, String userPower) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPower = userPower;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPower='" + userPower + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower;
    }
}
