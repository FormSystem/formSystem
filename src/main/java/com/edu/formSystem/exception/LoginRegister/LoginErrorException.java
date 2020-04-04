package com.edu.formSystem.exception.LoginRegister;


import com.edu.formSystem.constant.ResponseConstant;

/**
 * @author ydq
 * @program: beitasystem
 * @Title: LoginErrorException
 * @package: studio.beita.hdxg.beitasystem.exception.LoginRegister
 * @description: 登陆异常，账号或者密码错误
 **/

public class LoginErrorException extends RuntimeException {

    private static final long serialVersionUID = -8921970173439068042L;

    public LoginErrorException() {
    }

    @Override
    public String getMessage() {
        return ResponseConstant.ACCOUNT_OR_PWD_WRONG;
    }
}
