package com.edu.formSystem.repository;

import com.edu.formSystem.model.domain.Form;
import com.edu.formSystem.model.domain.FormStructure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author zr
 * @program: formSystem
 * @Title: formManagementDao
 * @package: com.edu.formSystem
 * @description: 表单管理模块接口
 */
@Mapper
@Repository
public interface FormManagementDao {

    /**
     * 创建表单
     * @param formId:表单ID
     * @param formName：表单名
     * @param formUserId：表单创建者
     * @param formTime：表单创建时间
     * @param formNumber：表单数
     * @param formWidth：表单宽度
     * @param formAlignment：表单排列方式
     * @return Integer
     */
    @Insert("INSERT INTO form (form_id, form_name,form_user_id,form_time,form_number,form_width,form_alignment) " +
            "VALUES (#{formId},#{formName},#{formUserId},#{formTime},#{formNumber},#{formWidth},#{formAlignment})")
    Integer createForm(@Param("formId")String formId, @Param("formName") String formName, @Param("formUserId") String formUserId,@Param("formTime") String formTime,
                       @Param("formNumber") int formNumber,@Param("formWidth") int formWidth,@Param("formAlignment") String formAlignment);


    /**
     * 更改表单
     * @param formId:表单ID
     * @param formName：表单名
     * @param formUserId：表单创建者
     * @param formTime：表单创建时间
     * @param formNumber：表单数
     * @param formWidth：表单宽度
     * @param formAlignment：表单排列方式
     * @return Integer
     */
    @Update("UPDATE form SET form_id = #{formId}, form_name = #{formName} , form_user_id = #{formUserId} ,form_time = #{formTime}," +
            " form_number = #{formNumber}, form_width = #{formWidth}, form_alignment = #{formAlignment} WHERE form_id=#{formId}")
    Integer changeForm(@Param("formId")String formId, @Param("formName") String formName, @Param("formUserId") String formUserId,@Param("formTime") String formTime,
                                @Param("formNumber") int formNumber,@Param("formWidth") int formWidth,@Param("formAlignment") String formAlignment);

    /**
     * 增加表单数据数
     * @param formId:表单ID
     * @return
     */
    @Update("UPDATE form SET  form_number = form_number +1 WHERE form_id=#{formId]")
    Integer addFormNumber(@Param("formId")String formId);

    /**
     * 系统验证表单名是否已被使用(也用来查找表单对应ID)
     * @param formName：表单名
     * @return Form
     */
    @Select("SELECT form_id, form_name,form_user_id,form_time,form_number,form_width,form_alignment" +
            " FROM form WHERE form_name = #{formName}")
    Form isFormNameUsed(@Param("formName")String formName);

    /**
     * 删除表单
     * @param formId:表单ID
     * @return Integer
     */
    @Delete("DELETE FROM form WHERE form_id = #{formId}")
    Integer deleteFromByFromId(@Param("formId")String formId);

    /**
     * 查询所有表单
     * @return List<Form>
     */
    @Select("SELECT form_id, form_name,form_user_id,form_time,form_number,form_width,form_alignment" +
            " FROM form ORDER BY form_id ASC ")
    List<Form> findAllForm();

    /**
     * 系统验证表单是否存在(也用来查找表单对应ID)
     * @param formId:表单ID
     * @return Form
     */
    @Select("SELECT form_id, form_name,form_user_id,form_time,form_number,form_width,form_alignment" +
            " FROM form WHERE form_id = #{formId}")
    Form findForm(@Param("formId")String formId);


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
    @Insert("INSERT INTO form_structure (form_structure_id, form_id,form_field_id,form_field_name,field_attributes_value,form_field_order) " +
            "VALUES (#{formStructureId},#{formId},#{formFieldId},#{formFieldName},#{fieldAttributesValue},#{formFieldOrder})")
    Integer createFormStructure(@Param("formStructureId")String formStructureId, @Param("formId") String formId, @Param("formFieldId") int formFieldId,
                                @Param("formFieldName") String formFieldName,@Param("fieldAttributesValue") String fieldAttributesValue,@Param("formFieldOrder") int formFieldOrder);


    /**
     * 查找表单结构
     * @param formId:表单ID
     * @return List<FormStructure>
     */
    @Select("SELECT fs.form_structure_id, fs.form_id,fs.form_field_id,fs.form_field_name,fs.field_attributes_value," +
            "fs.form_field_order,ff.form_field_type " +
            "FROM form_structure fs " +
            "LEFT JOIN form_field ff on fs.form_field_id = ff.form_field_id WHERE form_id = #{formId}")
    List<FormStructure> findFormStructureByFormId(@Param("formId")String formId);

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
    @Update("UPDATE form_structure SET form_structure_id = #{formStructureId}, form_id = #{formId} , form_field_id = #{formFieldId} ,form_field_name = #{formFieldName}," +
            " field_attributes_value = #{fieldAttributesValue}, form_field_order = #{formFieldOrder} WHERE form_structure_id=#{formStructureId}")
    Integer changeFormStructure(@Param("formStructureId")String formStructureId, @Param("formId") String formId, @Param("formFieldId") int formFieldId,
                                @Param("formFieldName") String formFieldName,@Param("fieldAttributesValue") String fieldAttributesValue,@Param("formFieldOrder") int formFieldOrder);

    /**
     * 删除表单
     * @param formStructureId:表单字段ID
     * @return Integer
     */
    @Delete("DELETE FROM form_structure WHERE form_structure_id = #{formStructureId}")
    Integer deleteFromStructureByFromStructureId(@Param("formStructureId")String formStructureId);

    /**
     * 查找表单字段属性值
     * @param formFieldId:表单字段ID
     * @return List<FormStructure>
     */
    @Select("select ffa.form_field_attributes_name " +
            "from rel_fi_at rfa LEFT JOIN form_field_attributes ffa ON ffa.form_field_attributes_id = rfa.form_field_attributes_id " +
            "WHERE form_field_id = #{formFieldId}")
    List<String> findFormFieldAttributesByFormFieldId(@Param("formFieldId")int formFieldId);

}