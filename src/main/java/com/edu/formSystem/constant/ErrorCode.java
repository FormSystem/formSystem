package com.edu.formSystem.constant;

/**
 * @author zr
 * @program: formSystem
 * @Title: ErrorCode
 * @package: com.edu.formSystem.controller
 * @description: 错误异常Code表
 **/

public class ErrorCode {

    /**
     * loginRegisterController
     */
    public static final int USER_ACCOUNT_ISUSED = 1000;
    public static final int OLD_PASSWORD_WRONG = 1001;
    public static final int ASSERT_ACCOUNT_WRONG = 1002;

    /**
     * ExamManagementController
     */
    public static final int EXAM_IS_CLOSED = 1003;
    public static final int EXAM_NOT_QUERY = 1004;
    public static final int EXAM_DOES_NOT_EXIST = 1005;

    /**
     * 公有构造函数
     */
    public ErrorCode() {

    }
}
