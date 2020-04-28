package com.edu.formSystem.service;

import com.edu.formSystem.model.domain.User;

import java.util.Optional;

/**
 * @author zr
 * @program: formSystem
 * @Title: LoginRegisterController
 * @package: com.edu.formSystem.service
 * @description: 登陆/注册模块接口
 **/

public interface LoginRegisterService {
    /**
     * 用户注册账号
     *
     * @param name:用户名
     * @param password：密码
     * @param email：邮箱
     * @return
     */
    Integer register(String name, String password, String email);

    /**
     * 用户通过账号登陆或者通过邮箱登陆
     *
     * @param name:用户名
     * @param password：密码
     * @param email：邮箱
     * @return
     */
    Optional<String> assertLogin(String name, String email, String password);

    /**
     * 系统通过账号和旧密码验证账号
     *
     * @param userId：用户ID
     * @param name：用户名
     * @param oldPassword：旧密码
     * @return Optional用于检查
     */
    Optional<User> assertOldPassword(String userId, String name, String oldPassword);

    /**
     * 系统验证账号是否已被使用(也用来查找用户名对应ID)
     *
     * @param name：用户名
     * @return
     */
    Optional<String> isNameUsed(String name);

    /**
     * 用户通过邮箱验证账号
     *
     * @param userId：用户ID
     * @param email：用户邮箱
     * @return
     */
    Optional<String> assertNameByEmail(String userId, String email);

    /**
     * 修改用户的密码
     *
     * @param userId：用户ID
     * @param newPassword：旧密码
     * @return
     */
    boolean changePassword(String userId, String newPassword);

}
