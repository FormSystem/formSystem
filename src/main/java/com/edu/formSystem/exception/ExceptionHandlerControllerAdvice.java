package com.edu.formSystem.exception;

import com.edu.formSystem.model.dto.Error;
import com.edu.formSystem.constant.ErrorCode;
import com.edu.formSystem.exception.LoginRegister.NameIsUsedException;
import com.edu.formSystem.exception.LoginRegister.LoginErrorException;
import com.edu.formSystem.exception.LoginRegister.OldPasswordWrongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ydq
 * @program: beitaSystem
 * @Title: ExceptionHandlerControllerAdvice
 * @package: com.edu.formSystem.exception
 * @description: 统一异常处理类
 **/

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(ExceptionHandlerControllerAdvice.class);

    /**
     * 用户账号被占用
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(NameIsUsedException.class)
    public ResponseEntity<?> userAccountIsUsedExceptionHandler(HttpServletRequest request, NameIsUsedException e) {
        logError(request, e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error()
                        .setCode(ErrorCode.USER_ACCOUNT_ISUSED)
                        .setMessage(e.getMessage()));
    }

    /**
     * 修改密码验证账号失败
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(OldPasswordWrongException.class)
    public ResponseEntity<?> oldPasswordWrongExceptionHandler(HttpServletRequest request, OldPasswordWrongException e) {
        logError(request, e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error()
                        .setCode(ErrorCode.OLD_PASSWORD_WRONG)
                        .setMessage(e.getMessage()));
    }

    /**
     * 登陆失败，请重试
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(LoginErrorException.class)
    public ResponseEntity<?> oldPasswordWrongExceptionHandler(HttpServletRequest request, LoginErrorException e) {
        logError(request, e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error()
                        .setCode(ErrorCode.ASSERT_ACCOUNT_WRONG)
                        .setMessage(e.getMessage()));
    }


    /********************************** HELPER METHOD **********************************/
    private void logError(HttpServletRequest request, Exception e) {
        log.error("[URI: " + request.getRequestURI() + "]"
                + "[error: " + e.getMessage() + "]");
    }
}
