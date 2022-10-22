package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 3:11
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;

    //测试查询总记录数
    @Test
    public void testGetCount() {
        //查询总记录数
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    //测试批量插入
    @Test
    public void testInsertMore() {
        //SQL长度有限制，海量数据插入单条SQL无法实行，
        //因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        //批量添加
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("zcf" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        //SQL:INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        boolean b = userService.saveBatch(list);
        System.out.println(b);//true
    }
}
