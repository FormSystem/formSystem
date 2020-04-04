package com.edu.formSystem.exception.LoginRegister;

import com.edu.formSystem.constant.ResponseConstant;

/**
 * @author ydq
 * @program: beitasystem
 * @Title: AccountIsUsedException
 * @package: studio.beita.hdxg.beitasystem.exception.LoginRegister
 * @description: 用户名已被占用异常
 **/
public class NameIsUsedException extends RuntimeException {

    private static final long serialVersionUID = 246414816752077639L;

    public NameIsUsedException() {
    }

    @Override
    public String getMessage() {
        return ResponseConstant.NAME_ISUSED;
    }
}
