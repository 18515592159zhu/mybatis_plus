package com.atguigu.mp.test;

import com.atguigu.mp.pojo.User;
import com.atguigu.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @Author zhuchifeng
 * @Date 2022/10/21 4:39
 * @Version 1.0
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    //测试查询记录数
    @Test
    public void testGetCount() {
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    //测试批量插入
    @Test
    public void testSaveBatch() {
        // SQL长度有限制，海量数据插入单条SQL无法实行，
        // 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("zcf" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        // INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        userService.saveBatch(users);
    }
}