package com.atguigu.mybatisx.service.impl;

import com.atguigu.mybatisx.mapper.UserMapper;
import com.atguigu.mybatisx.pojo.User;
import com.atguigu.mybatisx.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 7:20
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
