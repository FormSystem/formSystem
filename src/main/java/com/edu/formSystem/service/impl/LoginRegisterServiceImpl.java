package com.edu.formSystem.service.impl;

import com.edu.formSystem.model.domain.User;
import com.edu.formSystem.repository.LoginRegisterDao;
import com.edu.formSystem.service.LoginRegisterService;
import com.edu.formSystem.utils.GetUidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Autowired
    private LoginRegisterDao loginRegisterDao;

    /**
     * 用户注册
     * @param name
     * @param password
     * @param email
     * @return
     */
    @Override
    public Integer register(String name, String password, String email) {
        String userId = GetUidUtils.getNewId();
        return loginRegisterDao.register(userId,name,password,email,1);
    }

    /**
     * 用户通过账号登陆或者通过邮箱登陆
     * @param name
     * @param email
     * @param password
     * @return
     */
    @Override
    public Optional<String> assertLogin(String name, String email, String password) {
        return Optional.ofNullable(
                loginRegisterDao.assertLogin(name,email,password));
    }

    /**
     * 系统通过账号和旧密码验证账号
     * @param userId
     * @param name
     * @param oldPassword
     * @return
     */
    @Override
    public Optional<User> assertOldPassword(String userId, String name, String oldPassword) {
        return Optional.ofNullable(
                loginRegisterDao.assertOldPassword(userId,name,oldPassword));
    }

    /**
     * 系统验证账号是否已被使用(也用来查找用户名对应ID)
     * @param name
     * @return
     */
    @Override
    public Optional<String> isNameUsed(String name) {
        return Optional.ofNullable(
                loginRegisterDao.isNameUsed(name));
    }

    /**
     * 用户通过邮箱验证账号
     * @param userId
     * @param email
     * @return
     */
    @Override
    public Optional<String> assertNameByEmail(String userId, String email) {
        return Optional.empty();
    }

    /**
     * 修改用户的密码
     * @param userId
     * @param newPassword
     * @return
     */
    @Override
    public boolean changePassword(String userId, String newPassword) {
        if(loginRegisterDao.changePassword(userId,newPassword)!=null)  return true;
        return false;
    }
}
