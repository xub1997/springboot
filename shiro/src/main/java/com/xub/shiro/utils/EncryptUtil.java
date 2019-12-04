package com.xub.shiro.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * @Description Sha-256加密工具
 */
public class EncryptUtil {

    /**
     * 私有构造器
     **/
    private EncryptUtil() {
    }

    ;

    /**
     * 加密算法
     **/
    public final static String HASH_ALGORITHM_NAME1 = "SHA-256";

    /**
     * 加密算法
     **/
    public final static String HASH_ALGORITHM_NAME2 = "md5";

    /**
     * 循环次数
     **/
    public final static int HASH_ITERATIONS = 15;

    /**
     * 执行加密-采用SHA256和盐值加密
     **/
    public static String encryptBySha256(String encryptString, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME1, encryptString, salt, HASH_ITERATIONS).toString();
    }

    /**
     * 执行加密-采用SHA256和盐值加密
     **/
    public static String encryptByMd5(String encryptString, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME2, encryptString, salt, HASH_ITERATIONS).toString();
    }

    public static void main(String[] args) {
        String salt = encryptByMd5("admin", UUID.randomUUID().toString().replace("-",""));
        String oldPwd = "123456";
        String pwd = encryptByMd5(oldPwd, salt);
        System.out.println(String.format("salt: %s,长度为 %d",salt,salt.length()));
        System.out.println(String.format("pwd密码: %s,加密后 %s",oldPwd,pwd));
    }
}
