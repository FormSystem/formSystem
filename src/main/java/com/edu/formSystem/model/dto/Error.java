package com.edu.formSystem.model.dto;

import java.io.Serializable;

/**
 * @author zr
 * @program: formSystem
 * @Title: Error
 * @package: studio.beita.hdxg.beitaSystem.model.dto
 * @description: 错误对象实体类
 **/
public class Error implements Serializable{


    private static final long serialVersionUID = -395022661421767900L;
    private int code;
    private String message;

    public Error() {
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Error setCode(int code) {
        this.code = code;
        return this;
    }

    public Error setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }


}
