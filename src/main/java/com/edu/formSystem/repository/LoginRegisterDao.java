package com.edu.formSystem.repository;

import com.edu.formSystem.model.domain.User;
import com.edu.formSystem.repository.provider.LoginRegisterDaoProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author zr
 * @program: formSystem
 * @Title: LoginRegisterDao
 * @package: com.edu.formSystem
 * @description: 登录注册模块接口
 */
@Mapper
@Repository
public interface LoginRegisterDao {

    /**
     * 用户注册
     * @param userId
     * @param userName
     * @param userPassword
     * @param userEmail
     * @param userPower
     * @return
     */
    @Insert("INSERT INTO user (user_id, user_name,user_password,user_email,user_power) VALUES (#{userId},#{userName},#{userPassword},#{userEmail},#{userPower})")
    Integer register(@Param("userId")String userId, @Param("userName") String userName, @Param("userPassword") String userPassword,
                          @Param("userEmail") String userEmail, @Param("userPower") int userPower);


    /**
     * 用户登录
     * @param name
     * @param email
     * @param password
     * @return
     */
    @SelectProvider(type = LoginRegisterDaoProvider.class, method = "assertLogin")
    String assertLogin(@Param("name") String name, @Param("email") String email, @Param("password") String password);

    /**
     * 系统验证账号是否已被使用
     * @param userName
     * @return
     */
    @Select("SELECT user_name FROM user WHERE user_name = #{userName}")
    String isAccountUsed(String userName);

    /**
     * 系统通过账号和旧密码验证账号
     * @param userId
     * @param name
     * @param oldPassword
     * @return
     */
    @Select("SELECT user_id FROM user WHERE user_id = #{userId} AND user_name = #{name} AND user_password=#{oldPassword}")
    @Results(
            id = "userVerify",
            value = {
                    @Result(id = true, property = "userId", column = "userId")
            }
    )
    User assertOldPassword(@Param("userId") String userId, @Param("name") String name, @Param("oldPwd") String oldPassword);


    /**
     * 管理员/用户修改账号密码
     *
     * @param userId
     * @param newPassword
     * @return
     */
    @Update("UPDATE user SET user_password = #{newPassword} WHERE user_id=#{userId}")
    Integer changePassword(@Param("userId") String userId, @Param("newPassword") String newPassword);

}
