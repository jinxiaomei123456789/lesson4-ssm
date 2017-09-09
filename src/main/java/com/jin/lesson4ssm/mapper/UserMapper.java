package com.jin.lesson4ssm.mapper;

import com.jin.lesson4ssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //查询所有用户
    public List<User> userList();
   //根据id查询用户
    public User findById(Integer id);
    //增加用户
    public void userAdd(String username,String password);
    //删除用户
    public void userDelete(Integer id);
    //更新用户
    public void userUpdate(User user);
}
