package com.atguigu.mp.mapper;

import com.atguigu.mp.pojo.User;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/21 3:14
 * @Version 1.0
 */
public interface TestMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();
}