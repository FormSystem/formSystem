package com.edu.formSystem.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/**
 * @author zr
 * @program: formSystem
 * @Title: formManagementDao
 * @package: com.edu.formSystem
 * @description: 表单管理模块接口
 */
@Mapper
@Repository
public interface formManagementDao {

    /**
     * 创建表单
     * @param formId
     * @param formName
     * @param formStructure
     * @param formUserId
     * @param formTime
     * @param formNumber
     * @return
     */
    @Insert("INSERT INTO form (form_id, form_name,form_structure,form_user_id,form_time,form_number) VALUES (#{formId},#{formName},#{formStructure},#{formUserId},#{formTime},#{formNumber})")
    Integer createForm(@Param("formId")String formId, @Param("formName") String formName, @Param("formStructure") String formStructure,
                     @Param("formUserId") String formUserId, @Param("formTime") int formTime, @Param("formNumber") int formNumber);


    /**
     * 更改表单结构
     * @param formId
     * @param formStructure
     * @return
     */
    @Update("UPDATE form SET form_structure = #{formStructure} WHERE form_id=#{formId}")
    Integer changeFormStructure(@Param("formId") String formId, @Param("formStructure") String formStructure);


}
