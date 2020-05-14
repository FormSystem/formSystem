package com.edu.formSystem.controller;

import com.edu.formSystem.constant.ResponseConstant;
import com.edu.formSystem.model.domain.Form;
import com.edu.formSystem.model.domain.FormNumber;
import com.edu.formSystem.service.FormManagementService;
import com.edu.formSystem.service.FormNumberService;
import com.edu.formSystem.utils.GetUidUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.edu.formSystem.constant.ResponseConstant.FORM_NUMBER_DELETE_FAILURE;
import static com.edu.formSystem.constant.ResponseConstant.FORM_NUMBER_DELETE_SUCCESS;

/**
 * @author zr
 * @program: formSystem
 * @Title: FormNumberController
 * @package: com.edu.formSystem.controller
 * @description: 表单数据模块控制器
 **/
@Api(value = "FormNumberController")
@RestController
public class FormNumberController {

    @Autowired
    private FormNumberService formNumberService;

    @Autowired
    private FormManagementService formManagementService;

    @ApiOperation(value = "添加表单数据", notes = "add formNumber")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formId", value = "表单ID", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formNumberContent", value = "数据内容", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "填表人", dataType = "string", paramType = "query")
    })
    @GetMapping("/form/number/add")
    public ResponseEntity<?> insertFormNumber(String formId, String formNumberContent, String userId) {
        Optional<Form> form = formManagementService.findForm(formId);
        if (!form.isPresent()) {
            return ResponseEntity.ok("表单名不存在！请重新输入！");
        }
        String formNumberId = GetUidUtils.getNewId();
        Integer formNumber = formNumberService.insertFormNumber(formNumberId,formId,formNumberContent,userId).orElse(0);
        if(formNumber==0){
            return ResponseEntity.ok(ResponseConstant.FORM_NUMBER_CREATE_FAILURE);
        }
        //表单数据增加
        formManagementService.addFormNumber(formId);
        return ResponseEntity.ok(ResponseConstant.FORM_NUMBER_CREATE_SUCCESS);
    }

    @ApiOperation(value = "更改表单数据", notes = "update formNumber")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formNumberId", value = "表单数据ID", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formId", value = "表单ID", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "formNumberContent", value = "数据内容", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "填表人", dataType = "string", paramType = "query")
    })
    @PutMapping("/form/number/update")
    public ResponseEntity<?> changeFormNumber(String formNumberId,String formId, String formNumberContent, String userId) {
        Optional<FormNumber> formNumber = formNumberService.findFormNumberByFormNumberId(formNumberId);
        if (!formNumber.isPresent()) {
            return ResponseEntity.ok("表单数据不存在！请重新输入！");
        }

        Integer changeFormNumber = formNumberService.changeFormNumber(formNumberId,formId,formNumberContent,userId).orElse(0);
        if(changeFormNumber==0){
            return ResponseEntity.ok(ResponseConstant.FORM_NUMBER_UPDATE_FAILURE);
        }
        return ResponseEntity.ok(ResponseConstant.FORM_NUMBER_UPDATE_SUCCESS);
    }

    @ApiOperation(value = "查询一条表单数据", notes = "find formNumber")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formNumberId", value = "表单数据ID", dataType = "string", paramType = "query", required = true)
    })
    @GetMapping("/form/number/findById")
    public ResponseEntity<?> findFormNumberByFormNumberId(String formNumberId) {
        Optional<FormNumber> formNumber = formNumberService.findFormNumberByFormNumberId(formNumberId);
        if (!formNumber.isPresent()) {
            return ResponseEntity.ok("表单数据不存在！请重新输入！");
        }
        return ResponseEntity.ok(formNumber);
    }

    @ApiOperation(value = "删除表单数据", notes = "find formNumber")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formNumberId", value = "表单数据ID", dataType = "string", paramType = "query", required = true)
    })
    @DeleteMapping("/form/number/delete")
    public ResponseEntity<?> deleteFormNumberByFormNumberId(String formNumberId) {
        Optional<FormNumber> formNumber = formNumberService.findFormNumberByFormNumberId(formNumberId);
        if (formNumber.isPresent()||formNumberService.deleteFormNumberByFormNumberId(formNumberId).orElse(0)==0) {
            return ResponseEntity.ok(FORM_NUMBER_DELETE_FAILURE);
        }
        FormNumber formNumber1 = new FormNumber();
        formManagementService.deleteFormNumber(formNumber.orElse(formNumber1).getFormId());
        return ResponseEntity.ok(FORM_NUMBER_DELETE_SUCCESS);
    }

    @ApiOperation(value = "查询表单数据", notes = "find All formNumber")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formId", value = "表单ID", dataType = "string", paramType = "query", required = true)
    })
    @PostMapping("/form/number/find/all")
    public ResponseEntity<?> findAllFormNumber(String formId) {
        Optional<List<FormNumber>> formNumber = formNumberService.findAllFormNumber(formId);
        if (!formNumber.isPresent()) {
            return ResponseEntity.ok("表单数据不存在！请重新输入！");
        }
        return ResponseEntity.ok(formNumber);
    }

}
