package com.atguigu.mp.test;

import com.atguigu.mp.enums.SexEnum;
import com.atguigu.mp.mapper.UserMapper;
import com.atguigu.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author zhuchifeng
 * @Date 2022/10/21 8:36
 * @Version 1.0
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisPlusEnumsTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSexEnum() {
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
        //INSERT INTO t_user ( name, age, sex ) VALUES ( ?, ?, ? )
        //Parameters：Enum(String), 20(Integer), 1(Integer)
        userMapper.insert(user);
    }
}
