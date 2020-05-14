package com.edu.formSystem.repository;

import com.edu.formSystem.model.domain.FormNumber;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author zr
 * @program: formSystem
 * @Title: FormNumberDao
 * @package: com.edu.formSystem
 * @description: 表单数据模块接口
 */
@Mapper
@Repository
public interface FormNumberDao {

    /**
     * 添加表单数据
     * @param formNumberId 表单数据id
     * @param formId 表单名
     * @param formNumberContent 数据内容
     * @param userId 填表人（游客为null）
     * @return
     */
    @Insert("INSERT INTO form_number (form_number_id, form_id,form_number_content,user_id) " +
            "VALUES (#{formNumberId},#{formId},#{formNumberContent},#{userId})")
    Integer insertFormNumber(@Param("formNumberId")String formNumberId, @Param("formId") String formId, @Param("formNumberContent") String formNumberContent,@Param("userId") String userId);


    /**
     * 更改表单数据
     * @param formNumberId 表单数据id
     * @param formId 表单名
     * @param formNumberContent 数据内容
     * @param userId 填表人（游客为null）
     * @return
     */
    @Update("UPDATE form_number SET form_number_id = #{formNumberId}, form_id = #{formId} ,form_number_content = #{formNumberContent} ,user_id = #{userId} WHERE form_number_id=#{formNumberId}")
    Integer changeFormNumber(@Param("formNumberId")String formNumberId, @Param("formId") String formId, @Param("formNumberContent") String formNumberContent,@Param("userId") String userId);


    /**
     * 搜索指定的表单数据
     * @param formNumberId：表单数据id
     * @return Form
     */
    @Select("SELECT form_number_id, form_id,form_number_content,user_id" +
            " FROM form_number WHERE form_number_id = #{formNumberId}")
    FormNumber findFormNumberByFormNumberId(@Param("formNumberId")String formNumberId);

    /**
     * 删除表单数据
     * @param formNumberId:表单数据ID
     * @return Integer
     */
    @Delete("DELETE FROM form_number WHERE form_number_id = #{formNumberId}")
    Integer deleteFormNumberByFormNumberId(@Param("formNumberId")String formNumberId);

    /**
     * 查询指定表单的所有数据
     * @param formNumberId:表单数据ID
     * @return List<Form>
     */
    @Select("SELECT form_number_id, form_id,form_number_content,user_id" +
            " FROM form_number WHERE form_id = #{formId} ORDER BY form_number_id ASC ")
    List<FormNumber> findAllFormNumber(@Param("formId")String formId);

}