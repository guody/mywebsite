/**
 * FileName: Utils
 * Author:   guody
 * Date:     2018/4/28 18:40
 * Description: MD5加密类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.util;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 〈MD5加密、token处理类〉
 *
 * @author guody
 * @create 2018/4/28
 * @since 1.0.0
 */
public class Utils {
    public static String createId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String createToken(){
        return createId().replaceAll("-", "");//去掉"-"
    }

    public static String md5(String str) {
        //基于摘要算法
        try {
            //将msg消息进行md5处理
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input = str.getBytes();
            byte[] output = md.digest(input);
            //加密后的字节数组转换成base64字符串
            return new sun.misc.BASE64Encoder().encode(output);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }



    }

    public static void main(String[] args){
//        System.out.println(createToken());
        System.out.println(md5("guodi3519"));
        System.out.println(md5("13241234123341234"));
    }
}