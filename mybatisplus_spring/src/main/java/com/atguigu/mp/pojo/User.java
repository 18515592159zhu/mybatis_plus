package com.atguigu.mp.pojo;

import com.atguigu.mp.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @Author zhuchifeng
 * @Date 2022/10/21 3:13
 * @Version 1.0
 */
//通过@TableName解决实体类类型的类名和要操作的表的表名不一致的问题
//@TableName("t_user")
@Data
public class User {

    /**
     * 若实体类和表中表示主键的不是id，而是其他字段，例如uid，MyBatis-Plus会自动识别uid为主键列吗？
     * 我们实体类中的属性id改为uid，将表中的字段id也改为uid，测试添加功能
     * 程序抛出异常，Field 'uid' doesn't have a default value，说明MyBatis-Plus没有将uid作为主键赋值
     * 通过@TableId解决问题
     * 在实体类中uid属性上通过@TableId将其标识为主键，即可成功执行SQL语句
     *
     * @TableId的value属性 若实体类中主键对应的属性为id，而表中表示主键的字段为uid，此时若只在属性id上添加注解
     * @TableId，则抛出异常Unknown column 'id' in 'field list'，即MyBatis-Plus仍然会将id作为表的
     * 主键操作，而表中表示主键的是字段uid
     * 此时需要通过@TableId注解的value属性，指定表中的主键字段，@TableId("uid")或@TableId(value="uid")
     * @TableId的type属性 type属性用来定义主键策略
     * 常用的主键策略：
     * IdType.ASSIGN_ID（默认）：基于雪花算法的策略生成数据id，与数据库id是否设置自增无关
     * IdType.AUTO：使用数据库的自增策略，注意，该类型请确保数据库设置了id自增，否则无效
     * @TableField 经过以上的测试，我们可以发现，MyBatis-Plus在执行SQL语句时，要保证实体类中的属性名和表中的字段名一致
     * 如果实体类中的属性名和字段名不一致的情况，会出现什么问题呢？
     * 情况1
     * 若实体类中的属性使用的是驼峰命名风格，而表中的字段使用的是下划线命名风格
     * 如实体类属性userName，表中字段user_name
     * 此时MyBatis-Plus会自动将下划线命名风格转化为驼峰命名风格
     * 相当于在MyBatis中配置
     * 情况2
     * 若实体类中的属性和表中的字段不满足情况1
     * 例如实体类属性name，表中字段username
     * 此时需要在实体类属性上使用@TableField("username")设置属性所对应的字段名
     * @TableLogic 逻辑删除
     * 物理删除：真实删除，将对应数据从数据库中删除，之后查询不到此条被删除的数据
     * 逻辑删除：假删除，将对应数据中代表是否被删除字段的状态修改为“被删除状态”，之后在数据库中仍旧能看到此条数据记录
     * 使用场景：可以进行数据恢复
     */
    //@TableId(value = "uid",type = IdType.AUTO)
    private Long id;
    //@TableField("username")
    private String name;
    private Integer age;
    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;

    public User() {
    }


    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
