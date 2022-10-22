package com.atguigu.mybatisx.mapper;

import com.atguigu.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 7:14
 * @Version 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}
