package com.edu.formSystem.controller;

import com.edu.formSystem.constant.ResponseConstant;
import com.edu.formSystem.model.domain.Form;
import com.edu.formSystem.service.FormManagementService;
import com.edu.formSystem.service.LoginRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author zr
 * @program: formSystem
 * @Title: FormManagementController
 * @package: com.edu.formSystem.controller
 * @description: 登陆/注册模块控制器
 **/
@Api(value = "LoginRegisterController")
@RestController
public class FormManagementController {
    @Autowired
    private FormManagementService formManagementService;
    @Autowired
    private LoginRegisterService loginRegisterService;

    @ApiOperation(value = "管理员创建表单", notes = "user register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formName", value = "表单名", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "founder", value = "建表者名", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formWidth", value = "表单宽度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "formAlignment", value = "表单排列方式", dataType = "string", paramType = "query")
    })
    @PostMapping("/form/register")
    public ResponseEntity<?> register(String formName, String founder, int formWidth,String formAlignment) {
        // 验证表单名是否已经被占用
        Optional<Form> form = formManagementService.isFormNameUsed(formName);
        if (form.isPresent()) {
            return ResponseEntity.ok("表单名已存在！请重新输入！");
        }

        Optional<String> userId = loginRegisterService.isNameUsed(founder);
        if (!userId.isPresent()) {
            return ResponseEntity.ok("创建者不存在！请重新登录！");
        }
        formManagementService.createForm(formName,userId.get(),0,formWidth,formAlignment);
        return ResponseEntity.ok(ResponseConstant.FORM_CREATE_SUCCESS);
    }

    @ApiOperation(value = "管理员修改表单", notes = "Update Form")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formId", value = "表单id", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formName", value = "表单名", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formUserId", value = "创建者", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formTime", value = "表单创建时间", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formNumber", value = "表单数据量", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "formWidth", value = "表单宽度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "formAlignment", value = "表单排列方式", dataType = "string", paramType = "query")
    })
    @PostMapping("/form/update")
    public ResponseEntity<?> updateForm(String formId, String formName, String formUserId, String formTime, int formNumber, int formWidth, String formAlignment) {
        // 验证表单是否存在
        Optional<Form> form = formManagementService.isFormNameUsed(formName);
        if (form.isPresent()) {
            return ResponseEntity.ok("表单名已存在！请重新输入！！");
        }
        formManagementService.changeForm(formId, formName,  formUserId, formTime, formNumber, formWidth, formAlignment);
        return ResponseEntity.ok(ResponseConstant.FORM_UPDATE_SUCCESS);
    }

    @ApiOperation(value = "管理员删除表单", notes = "delete Form")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formId", value = "表单id", dataType = "string", paramType = "query", required = true)
    })
    @PostMapping("/form/delete")
    public ResponseEntity<?> deleteForm(String formId) {
        // 验证表单是否存在
        Optional<Form> form = formManagementService.findForm(formId);
        if (!form.isPresent()) {
            return ResponseEntity.ok("表单名不存在！请重新输入！！");
        }
        formManagementService.deleteFromByFromId(formId);

    return ResponseEntity.ok(ResponseConstant.FORM_DELETE_SUCCESS);
    }
    
    @ApiOperation(value = "管理员查询表单", notes = "delete Form")
    @PostMapping("/form/findAll")
    public ResponseEntity<?> findAllForm() {
        return ResponseEntity.ok(formManagementService.findAllForm());
    }
}