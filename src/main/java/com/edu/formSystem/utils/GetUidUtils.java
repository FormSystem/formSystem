package com.edu.formSystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author zr
 * @program: formSystem
 * @Title: GetUidUtils
 * @package: com.edu.formSystem
 * @description: 随机ID生成工具类
 **/

public class GetUidUtils {

    /**
     * 根据日期生成UserId
     * @return
     */
    public static String getNewUserId() {
        // TODO: 2018/10/27 代码待美化 
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        /**
         * 根据日期生成UUID
         */
        String uuid = time + "$" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        /**
         * 生成ID后缀
         */
        long suffix = Math.abs(uuid.hashCode() % 1000000);
        /**
         * 生成ID前缀
         */
        long prefix = Long.parseLong(time) * 1000000;
        String userId = String.valueOf(prefix + suffix);

        return userId;
    }

}
