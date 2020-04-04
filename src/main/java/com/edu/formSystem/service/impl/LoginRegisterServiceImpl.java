package com.edu.formSystem.service.impl;

import com.edu.formSystem.model.domain.User;
import com.edu.formSystem.repository.LoginRegisterDao;
import com.edu.formSystem.service.LoginRegisterService;
import com.edu.formSystem.utils.GetUidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
        String userId = GetUidUtils.getNewUserId();
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
        return Optional.empty();
    }

    /**
     * 系统通过账号和旧密码验证账号
     * @param userId
     * @param name
     * @param password
     * @return
     */
    @Override
    public Optional<User> assertOldPassword(String userId, String name, String password) {
        return Optional.empty();
    }

    /**
     * 系统验证账号名是否已被使用
     * @param name
     * @return
     */
    @Override
    public Optional<String> isnameUsed(String name) {
        return Optional.empty();
    }

    /**
     * 用户通过邮箱验证账号
     * @param userId
     * @param email
     * @return
     */
    @Override
    public Integer assertnameByEmail(String userId, String email) {
        return null;
    }

    /**
     * 修改用户的密码
     * @param userId
     * @param newPassword
     * @return
     */
    @Override
    public boolean changePassword(String userId, String newPassword) {
        return false;
    }
}
