package com.edu.formSystem.repository.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class LoginRegisterDaoProvider{

    /**
     * 用户登陆验证
     *
     * @param uiMap
     * @return
     */
    public String assertLogin(Map<String, Object> uiMap) {
        String name = (String) uiMap.get("name");
        String email = (String) uiMap.get("email");
        String password = (String) uiMap.get("password");
        return new SQL() {
            {
                SELECT("user_id");
                FROM("user");
                WHERE("user_password='" + password + "'");
                if (name != null && !name.equals("")) {
                    AND();
                    WHERE("user_name='" + name + "'");
                }
                if (email != null && !email.equals("")) {
                    AND();
                    WHERE("user_email='" + email + "'");
                }
            }
        }.toString();
    }
}
