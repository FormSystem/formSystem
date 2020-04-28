package com.edu.formSystem.service;

import com.edu.formSystem.model.domain.Form;

import java.util.List;
import java.util.Optional;

/**
 * @author zr
 * @program: formSystem
 * @Title: FormManagementService
 * @package: com.edu.formSystem.service
 * @description: 表单管理接口
 **/
public interface FormManagementService {

    /**
     * 创建表单
     * @param formName：表单名
     * @param formUserId：表单创建者
     * @param formNumber：表单数
     * @param formWidth：表单宽度
     * @param formAlignment：表单排列方式
     * @return Optional<Integer>
     */
    Optional<Integer> createForm(String formName, String formUserId, int formNumber, int formWidth, String formAlignment);

    /**
     * 更改表单
     * @param formId:表单ID
     * @param formName：表单名
     * @param formUserId：表单创建者
     * @param formTime：表单创建时间
     * @param formNumber：表单数
     * @param formWidth：表单宽度
     * @param formAlignment：表单排列方式
     * @return Optional<Integer>
     */
    Optional<Integer> changeForm(String formId,String formName,String formUserId,String formTime,int formNumber,int formWidth,String formAlignment);

    /**
     * 增加表单数据数
     * @param formId:表单ID
     * @return Optional<Integer>
     */
    Optional<Integer> addFormNumber(String formId);

    /**
     * 系统验证表单名是否已被使用(也用来查找表单对应ID)
     * @param formName：表单名
     * @return Form
     */
    Optional<Form> isFormNameUsed(String formName);

    /**
     * 删除表单
     * @param formId:表单ID
     * @return Integer
     */
    Optional<Integer> deleteFromByFromId(String formId);

    /**
     * 查询所有表单
     * @return Optional<List<Form>>
     */
    Optional<List<Form>> findAllForm();

    /**
     * 通过id查找表单
     * @param formId 表单名
     * @return Optional<Form>
     */
    Optional<Form> findForm(String formId);

}