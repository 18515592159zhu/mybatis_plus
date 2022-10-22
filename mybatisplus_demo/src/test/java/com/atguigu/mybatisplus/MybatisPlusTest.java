package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 2:50
 * @Version 1.0
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        //selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        //SELECT id,name,age,email FROM user
        userMapper.selectList(null).forEach(System.out::println);
    }

    //插入
    @Test
    public void testInsert() {
        //实现新增用户信息
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        //user.setId(100L);
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println("受影响行数：" + result);
        System.out.println("result:" + result);
        //1583557224171929619
        //这是因为MyBatis-Plus在实现插入数据时，会默认基于雪花算法的策略生成id
        System.out.println("id自动获取：" + user.getId());
    }

    /**
     * 删除
     */
    //通过id删除记录
    @Test
    public void testDeleteById() {
        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1583557224171929619L);
        System.out.println("受影响行数：" + result);
    }

    //通过多个id实现批量删除
    @Test
    public void testDeleteBatchIds() {
        //通过多个id批量删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("受影响行数：" + result);
    }

    //通过map条件删除记录
    @Test
    public void testDeleteByMap() {
        //根据map集合中所设置的条件删除记录
        //DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 23);
        map.put("user_name", "张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数：" + result);
    }

    //修改用户信息
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);
        //UPDATE user SET name=?, age=? WHERE id=?
        System.out.println("受影响行数：" + result);
    }

    /**
     * 查询
     */
    //根据id查询用户信息
    @Test
    public void testSelectById() {
        //根据id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }

    //根据多个id查询多个用户信息
    @Test
    public void testSelectBatchIds() {
        //根据多个id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
    }

    //通过map条件查询用户信息
    @Test
    public void testSelectByMap() {
        //通过map条件查询用户信息
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 22);
        map.put("user_name", "admin");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    //查询所有数据
    @Test
    public void testSelectList() {
        //查询所有用户信息
        //SELECT id,name,age,email FROM user
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    /**
     * 通过观察BaseMapper中的方法，大多方法中都有Wrapper类型的形参，此为条件构造器
     * 可针对于SQL语句设置不同的条件，若没有条件，则可以为该形参赋值null，即查询（删除/修改）所有数据
     */
}