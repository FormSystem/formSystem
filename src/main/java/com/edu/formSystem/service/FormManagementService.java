package com.edu.formSystem.service;

import com.edu.formSystem.model.domain.Form;
import com.edu.formSystem.model.domain.FormStructure;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 创建表单结构
     * @param formStructureId:表单结构ID
     * @param formId:表单ID
     * @param formFieldId:表单字段ID
     * @param formFieldName:表单字段名
     * @param fieldAttributesValue:表单字段属性值
     * @param formFieldOrder:表单字段顺序
     * @return Integer
     */
    Optional<Integer> createFormStructure(String formId, int formFieldId,String formFieldName,
                                String fieldAttributesValue, int formFieldOrder);

    /**
     * 查找表单结构
     * @param formId:表单ID
     * @return Form
     */
    Optional<List<FormStructure>> findFormStructureByFormId(String formId);

    /**
     * 更改表单结构
     * @param formStructureId:表单结构ID
     * @param formId:表单ID
     * @param formFieldId:表单字段ID
     * @param formFieldName:表单字段名
     * @param fieldAttributesValue:表单字段属性值
     * @param formFieldOrder:表单字段顺序
     * @return Integer
     */
    Optional<Integer> changeFormStructure(String formStructureId, String formId, int formFieldId,String formFieldName,
                                String fieldAttributesValue, int formFieldOrder);

    /**
     * 删除表单
     * @param formStructureId:表单字段ID
     * @return Integer
     */
    Optional<Integer> deleteFromStructureByFromStructureId(String formStructureId);


    /**
     * 查找表单字段属性值
     * @param formFieldId 表单字段id
     * @return
     */
    Optional<List<String>> findFormFieldAttributesByFormFieldId(int formFieldId);

}