package com.atguigu.mp.test;

import com.atguigu.mp.mapper.UserMapper;
import com.atguigu.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在Spring整合MyBatis中加入了MyBatis-Plus后，我们就可以使用MyBatis-Plus所提供的BaseMapper实现CRUD，并不需要编写映射文件以及SQL语句
 * 但是若要自定义SQL语句，仍然可以编写映射文件而不造成任何影响
 * 因为MyBatis-Plus只做增强，而不做改变
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMyBatisPlus() {
        //根据id查询用户信息
        System.out.println(userMapper.selectById(1));
    }

    //插入
    @Test
    public void testInsert() {
        User user = new User(null, "张三", 23, "zhangsan@atguigu.com");
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("受影响行数：" + result);
        //id自动获取：1583192438909186049，这是因为MyBatis-Plus在实现插入数据时，会默认基于雪花算法的策略生成id
        System.out.println("id自动获取：" + user.getId());
    }

    //删除
    @Test
    public void testDeleteById() {
        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        //使用逻辑删除：UPDATE t_user SET is_deleted=1 WHERE id=? AND is_deleted=0
        int result = userMapper.deleteById(1583197112114622465L);
        System.out.println("受影响行数：" + result);
    }

    //通过id批量删除记录
    @Test
    public void testDeleteBatchIds() {
        //通过多个id批量删除 //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("受影响行数：" + result);
    }

    //通过map条件删除记录
    @Test
    public void testDeleteByMap() {
        //根据map集合中所设置的条件删除记录 //DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 23);
        map.put("name", "张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数：" + result);
    }

    //修改
    @Test
    public void testUpdateById() {
        User user = new User(4L, "admin", 22, null);
        //UPDATE user SET name=?, age=? WHERE id=?
        int result = userMapper.updateById(user);
        System.out.println("受影响行数：" + result);
    }

    //查询
    //根据id查询用户信息
    @Test
    public void testSelectById() {
        //根据id查询用户信息
        // SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }

    //根据多个id查询多个用户信息
    @Test
    public void testSelectBatchIds() {
        //根据多个id查询多个用户信息
        // SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
    }

    //通过map条件查询用户信息
    @Test
    public void testSelectByMap() {
        //通过map条件查询用户信息
        // SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 22);
        map.put("name", "admin");
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
}
