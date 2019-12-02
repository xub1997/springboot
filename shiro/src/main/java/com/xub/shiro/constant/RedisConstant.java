package com.xub.shiro.constant;

/**
 * @description: redis全局属性
 * @author: 黎清许
 * @create: 2019-12-02 11:55
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
public class RedisConstant {

    /**
     * TOKEN前缀
     */
    public static final String REDIS_PREFIX_LOGIN = "token_%s";

    /**
     * 缓存前缀
     */
    public static final String CACHE_KEY = "shiro:cache:";

    /**
     * session前缀
     */
    public static final String SESSION_KEY = "shiro:session:";

    /**
     * 过期时间2小时
     */
    public static final Integer REDIS_EXPIRE_TWO = 2 * 60 * 60;

    /**
     * 过期时间15分(eMail)
     */
    public static final Integer REDIS_EXPIRE_EMAIL = 15 * 60;

    /**
     * 过期时间30分(session)
     */
    public static final Integer REDIS_EXPIRE_SESSION = 30 * 60;

    /**
     * 过期时间5分钟(验证码)
     */
    public static final Integer REDIS_EXPIRE_CAPTCHA = 5 * 60;

    /**
     * 无过期时间
     */
    public static final Integer REDIS_EXPIRE_NULL = -1;
}
