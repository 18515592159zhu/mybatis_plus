package com.atguigu.mp.test;

import com.atguigu.mp.mapper.UserMapper;
import com.atguigu.mp.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/21 7:46
 * @Version 1.0
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    //MyBatis Plus自带分页插件，只要简单的配置即可实现分页功能
    @Test
    public void testPage() {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
        /*
        测试结果：
            当前页：1
            每页显示的条数：5
            总记录数：0
            总页数：0
            是否有上一页：false
            是否有下一页：false
        */
    }

    //xml自定义分页
    @Test
    public void testSelectPageVo() {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPageVo(page, 20);
        // 获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
        /*
        测试结果：
            当前页：1
            每页显示的条数：5
            总记录数：0
            总页数：0
            是否有上一页：false
            是否有下一页：false
         */
    }
}
