package com.xub.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-25 16:23
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Data
//实体类跟表名称不对应时，添加@TableName注解
//@TableName
//描述：表名注解
//属性	类型	必须指定	默认值	描述
//value	String	否	""	表名
//schema	String	否	""	schema(@since 3.1.1)
//keepGlobalPrefix	boolean	否	false	是否保持使用全局的 tablePrefix 的值(如果设置了全局 tablePrefix 且自行设置了 value 的值)(@since 3.1.1)
//resultMap	String	否	""	xml 中 resultMap 的 id
//autoResultMap	boolean	否	false	是否自动构建 resultMap 并使用(如果设置 resultMap 则不会进行 resultMap 的自动构建并注入)(@since 3.1.2)
@TableName("user")
public class UserPO {

    //@TableId 描述：主键注解
    //属性	类型	必须指定	默认值	描述
    //value	String	否	""	主键字段名
    //type	Enum	否	IdType.NONE	主键类型

    //#IdType
    //值	描述
    //AUTO	数据库自增
    //INPUT	自行输入
    //ID_WORKER	分布式全局唯一ID 长整型类型
    //UUID	32位UUID字符串
    //NONE	无状态
    //ID_WORKER_STR	分布式全局唯一ID 字符串类型
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "email")
    private String email;
}
