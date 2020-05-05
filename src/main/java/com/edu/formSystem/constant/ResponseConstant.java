package com.edu.formSystem.constant;

/**
 * @author zr
 * @program: formSystem
 * @Title: ResponseConstant
 * @package: com.edu.formSystem.controller
 * @description: 响应消息常量
 **/

public class ResponseConstant {

    /**
     * loginRegisterController 200
     */

    public static final String NAME_REGISTER_SUCCESS = "注册账号成功！";
    public static final String CHANGE_PASSWORD_SUCCESS = "修改密码成功";
    public static final String ASSERT_LOGIN_SUCCESS = "登陆成功！";

    /**
     * FormManagementController 200
     */
    public static final String FORM_CREATE_SUCCESS = "注册表成功!";
    public static final String FORM_UPDATE_SUCCESS = "修改表成功!";
    public static final String FORM_DELETE_SUCCESS = "删除表成功!";
    public static final String FORM_STRUCTURE_CREATE_SUCCESS = "添加表结构成功！";
    public static final String FORM_STRUCTURE_CREATE_FAILURE = "添加表结构失败！请重新添加！";
    public static final String FORM_STRUCTURE_UPDATE_SUCCESS = "更新表结构成功！";
    public static final String FORM_STRUCTURE_UPDATE_FAILURE = "更新表结构失败！请重新添加！";
    public static final String FORM_STRUCTURE_DELETE_SUCCESS = "删除表结构成功！";
    public static final String FORM_STRUCTURE_DELETE_FAILURE = "删除表结构失败！请确认表单结构ID！";
    public static final String FORM_FIND_FAILURE = "不存在这个表！";

    /**
     * loginRegisterController 400
     */
    public static final String NAME_IS_USED = "该用户名已被占用，请重新选择用户名！";
    public static final String OLD_PASSWORD_WRONG = "验证失败！请重新输入！";
    public static final String ACCOUNT_OR_PWD_WRONG = "登陆失败！请重试！";


    /**
     * 公有构造函数
     */
    public ResponseConstant() {

    }
}
