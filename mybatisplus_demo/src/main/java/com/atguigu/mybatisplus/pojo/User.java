package com.atguigu.mybatisplus.pojo;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 2:49
 * @Version 1.0
 */
@Data//lombok注解
@NoArgsConstructor
@AllArgsConstructor
//设置实体类所对应的表名
//@TableName("t_user")
public class User {

    //将属性所对应的字段指定为主键
    //@TableId注解的value属性用于指定主键的字段
    //@TableId注解的type属性设置主键生成策略
    //@TableId(value = "uid", type = IdType.AUTO)
    @TableId(value = "uid")
    private Long id;

    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;

    private SexEnum sex;

    //逻辑删除
    @TableLogic
    private Integer isDeleted;
}