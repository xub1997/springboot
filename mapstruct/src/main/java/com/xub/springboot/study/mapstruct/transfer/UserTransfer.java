package com.xub.springboot.study.mapstruct.transfer;

import com.xub.springboot.study.mapstruct.pojo.dto.UserDTO;
import com.xub.springboot.study.mapstruct.pojo.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Date;
import java.util.List;

/**
 * @author liqingxu
 * @Description
 * @create 2022-06-30
 */
//假如识别到的映射类型与Converter定义的类型一致，则直接使用定义的方法进行转换
@Mapper(uses = Converter.class)
public interface UserTransfer {

    //设置逆反映射
    @InheritInverseConfiguration
    //设置忽略映射（字段名及类型一致会进行自动映射）
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            //指定不同字段
            @Mapping(target = "id", source = "userId"),
            //使用表达式
            @Mapping(target = "createTime", expression = "java(new java.util.Date())"),
            //使用定义的静态方法
            @Mapping(target = "realName", source = "userId", qualifiedByName = "userId2Str"),
            //设置忽略
            @Mapping(target = "password", ignore = true),
            //使用对象的get方法获取属性，调用默认方法
            @Mapping(target = "birthday", expression = "java(this.str2Date(userDTO.getBirthday()))"),
            @Mapping(target = "sex", source = "sex"),
            //嵌套实体的对象可使用"."+属性名进行指定
//            @Mapping(target = "sex.id", source = "sex.id")

    })
    User DTO2Entity(UserDTO userDTO);

    /**
     * 同种类型转换，会进行复用
     * @param userDTOs
     * @return
     */
    List<User> DTOs2Entities(List<UserDTO> userDTOs);

    //default方法可以实现多种逻辑（JSON对象转list、对象转string，list转单个对象）
    default Date str2Date(String timeStr) {
        return new Date();
    }

    @InheritConfiguration
    //枚举映射（需要实现IReadableEnum接口）
    @Mapping(target = "sexCN", source = "sex")
    UserDTO entity2DTO(User user);


    //多个对象映射处理成一个对象
    //设置忽略映射（字段名及类型一致会进行自动映射）
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "userDTO1.userId")
    @Mapping(target = "realName", source = "userDTO2.realName")
    User DTO2Entity(UserDTO userDTO1, UserDTO userDTO2);

}
