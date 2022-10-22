package com.atguigu.mybatisx;

import com.atguigu.mybatisx.mapper.UserMapper;
import com.atguigu.mybatisx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 7:28
 * @Version 1.0
 */
@SpringBootTest
class MybatisxDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsertSelective() {
        User user = new User();
        user.setUserName("小丽");
        user.setAge(21);
        user.setEmail("xiaoli@123.com");
        user.setSex(0);
        //insert into t_user ( user_name, age, email, sex ) values ( ?, ?, ?, ? )
        int result = userMapper.insertSelective(user);
        System.out.println("result = " + result);
    }

    @Test
    public void testDeleteByUidAndUserName() {
        //delete from t_user where uid = ? AND user_name = ?
        int result = userMapper.deleteByUidAndUserName(1583557224171929620L, "小丽");
        System.out.println("result = " + result);
    }

    @Test
    public void testUpdateAgeAndSexByUid() {
        //update t_user set age = ?, sex = ? where uid = ?
        int result = userMapper.updateAgeAndSexByUid(22, 1, 1583557224171929621L);
        System.out.println("result = " + result);
    }

    @Test
    public void testSelectAgeAndSexByAgeBetween() {
        //select age, sex from t_user where age between ? and ?
        List<User> userList = userMapper.selectAgeAndSexByAgeBetween(20, 30);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectAllOrderByAgeDesc() {
        //select uid,user_name,age, email,sex,is_deleted from t_user order by age desc
        List<User> userList = userMapper.selectAllOrderByAgeDesc();
        userList.forEach(System.out::println);
    }
}
