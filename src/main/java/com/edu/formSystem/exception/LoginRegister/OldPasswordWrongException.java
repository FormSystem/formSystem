package com.edu.formSystem.exception.LoginRegister;


import com.edu.formSystem.constant.ResponseConstant;

/**
 * @author zr
 * @program: formSystem
 * @Title: OldPasswordWrongException
 * @package: com.edu.formSystem.controller
 * @description: 旧密码错误异常
 **/

public class OldPasswordWrongException extends RuntimeException{


    private static final long serialVersionUID = 160981668364802256L;

    public OldPasswordWrongException() {
    }


    @Override
    public String getMessage(){
        return ResponseConstant.OLD_PASSWORD_WRONG;
    }
}
