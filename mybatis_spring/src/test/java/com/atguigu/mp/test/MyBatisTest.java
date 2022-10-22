package com.atguigu.mp.test;

import com.atguigu.mp.mapper.TestMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 方式一：通过IOC容器
 */
public class MyBatisTest {
    @Test
    public void testMyBatis() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestMapper mapper = ac.getBean(TestMapper.class);
        mapper.getAllUser().forEach(user -> System.out.println(user));
    }
}
