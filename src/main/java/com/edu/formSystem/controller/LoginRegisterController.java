package com.edu.formSystem.controller;

import com.edu.formSystem.constant.ResponseConstant;
import com.edu.formSystem.exception.LoginRegister.LoginErrorException;
import com.edu.formSystem.exception.LoginRegister.OldPasswordWrongException;
import com.edu.formSystem.model.domain.User;
import com.edu.formSystem.service.LoginRegisterService;
import com.edu.formSystem.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author zr
 * @program: formSystem
 * @Title: LoginRegisterController
 * @package: com.edu.formSystem.controller
 * @description: 登陆/注册模块控制器
 **/
@Api(value = "LoginRegisterController")
@RestController
public class LoginRegisterController {

    @Autowired
    private LoginRegisterService loginRegisterService;

    @ApiOperation(value = "用户注册账号", notes = "user register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "string", paramType = "query", required = true)
    })
    @PostMapping("/user/register")
    public ResponseEntity<?> register(String name, String password, String email) {
        // 验证账号名是否已经被占用
        Optional<String> userId = loginRegisterService.isNameUsed(name);
        if (userId.isPresent()) {
            return ResponseEntity.ok("用户名已存在！请重新输入！");
        }
        //注册账号
        loginRegisterService.register(name, password, email);
        return ResponseEntity.ok(ResponseConstant.NAME_REGISTER_SUCCESS);
    }

    @ApiOperation(value = "用户登陆账号", notes = "user login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "string", paramType = "query")
    })
    @GetMapping("/user/login")
    public ResponseEntity<?> assertLogin(String name, String email, String password) {
        //验证登陆信息
        String id = assertLoginName(name, email, password);

        String jwt = JwtUtil.generateToken(name);

        HashMap<String, Object> results = new HashMap<>();
        results.put("token", jwt);
        results.put("id", id);
        // TODO: 2018/10/27 添加JWT到Redis
        results.put("message", ResponseConstant.ASSERT_LOGIN_SUCCESS);

        //登陆成功
        return ResponseEntity.ok(results);
    }

    @ApiOperation(value = "管理员登陆验证", notes = "admin login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "string", paramType = "query")
    })
    @GetMapping("/admin/login")
    public ResponseEntity<?> adminAssertLogin(String name, String email, String password) {
        //验证登陆信息
        String id = assertLoginName(name, email, password);
        //返回信息
        HashMap<String, Object> results = new HashMap<>();
        results.put("id", id);
        results.put("name", name);
        // TODO: 2018/10/27 添加JWT
        //登陆成功
        return ResponseEntity.ok(results);
    }

    @ApiOperation(value = "用户修改密码", notes = "user change password")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "oldPwd", value = "旧密码", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "newPwd", value = "新密码", dataType = "string", paramType = "query", required = true)
    })
    @GetMapping("/user/password/change")
    public ResponseEntity<?> changeUserPwd(@RequestParam("name") String name,@RequestParam("oldPwd") String oldPwd,
                                           @RequestParam("newPwd") String newPwd) {
        //查询name对应的ID
        Optional<String> userId = loginRegisterService.isNameUsed(name);
        if (!userId.isPresent()) {
            return ResponseEntity.ok("用户名不存在！请重新输入！");
        }

        //验证账号信息是否正确
        assertOldPwd(userId.get(), name, oldPwd);

        //修改密码成功
        loginRegisterService.changePassword(userId.get(), newPwd);
        return ResponseEntity.ok(
                ResponseConstant.CHANGE_PASSWORD_SUCCESS);
    }

    /********************************** HELPER METHOD **********************************/

    /**
     * 修改密码验证账号是否正确
     *
     * @param userId
     * @param name
     * @param oldPwd
     */
    private Optional<User> assertOldPwd(String userId, String name, String oldPwd) {
        return Optional.ofNullable(loginRegisterService
                .assertOldPassword(userId, name, oldPwd)
                .orElseThrow(
                        () -> new OldPasswordWrongException()));
    }

    /**
     * 验证登陆信息
     *
     * @param name
     * @param email
     * @param password
     */
    private String assertLoginName(String name, String email, String password) {
        return loginRegisterService
                .assertLogin(name, email, password)
                .orElseThrow(
                        () -> new LoginErrorException());
    }

}
