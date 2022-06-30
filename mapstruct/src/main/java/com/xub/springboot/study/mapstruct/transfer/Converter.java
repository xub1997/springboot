package com.xub.springboot.study.mapstruct.transfer;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;


import java.util.Objects;

/**
 * @author liqingxu
 * @Description 常用转换可直接在此声明，通过@Mapper的uses属性使用
 * @create 2022-06-30
 */
public interface Converter {

    /**
     * 默认的String转String
     *
     * @return
     */
    static String originStr2Str(String str) {
        return Objects.isNull(str) ? null : str;
    }

    /**
     * 默认的Long转String
     *
     * @return
     */
    static String originLong2Str(Long val) {
        return Objects.isNull(val) ? null : String.valueOf(val);
    }

    /**
     * 默认的Integer转String
     *
     * @return
     */
    static String originInt2Str(Integer val) {
        return Objects.isNull(val) ? null : String.valueOf(val);
    }

    /**
     * 枚举类转换（枚举类型可实现IReadableEnum接口实现自动转换）
     *
     * @param readableEnum
     * @return
     */
    static String readableEnum2Str(IReadableEnum readableEnum) {
        return Objects.isNull(readableEnum) ? null : readableEnum.getReadableString();
    }

    /**
     * 用户id转用户名称（与originStr2Str入参类型与返回一样需要@Named指定名称）
     *
     * @return
     */
    @Named("userId2Str")
    static String userId2Str(String userId) {
        if (StringUtils.isBlank(userId)) {
            return StringUtils.EMPTY;
        }
        return "真实用户名";
    }

}
