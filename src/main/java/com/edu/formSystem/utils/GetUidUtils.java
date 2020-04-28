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
    public static String getNewId() {
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
        String id = String.valueOf(prefix + suffix);

        return id;
    }

    public static String getTime(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时
        return df.format(new Date());
    }

}
