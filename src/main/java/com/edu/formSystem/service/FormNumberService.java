package com.edu.formSystem.service;

import com.edu.formSystem.model.domain.FormNumber;

import java.util.List;
import java.util.Optional;

/**
 * @author zr
 * @program: formSystem
 * @Title: FormManagementService
 * @package: com.edu.formSystem.service
 * @description: 表单管理接口
 **/
public interface FormNumberService {
    /**
     * 添加表单数据
     * @param formNumberId 表单数据id
     * @param formId 表单名
     * @param formNumberContent 数据内容
     * @param userId 填表人（游客为null）
     * @return  Optional<Integer>
     */
    Optional<Integer> insertFormNumber(String formNumberId, String formId, String formNumberContent, String userId);

    /**
     * 更改表单数据
     * @param formNumberId 表单数据id
     * @param formId 表单名
     * @param formNumberContent 数据内容
     * @param userId 填表人（游客为null）
     * @return Optional<Integer>
     */
    Optional<Integer> changeFormNumber(String formNumberId, String formId, String formNumberContent, String userId);

    /**
     * 搜索指定的表单数据
     * @param formNumberId 表单数据ID
     * @return Optional<FormNumber>
     */
    Optional<FormNumber> findFormNumberByFormNumberId(String formNumberId);

    /**
     * 删除表单数据
     * @param formNumberId:表单数据ID
     * @return Optional<Integer>
     */
    Optional<Integer> deleteFormNumberByFormNumberId(String formNumberId);

    /**
     * 查询指定表单的所有数据
     * @param formId 表单id
     * @return
     */
    Optional<List<FormNumber>> findAllFormNumber(String formId);





}
