package com.jin.lesson4ssm.controller;


import com.jin.lesson4ssm.mapper.UserMapper;
import com.jin.lesson4ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//返回jason
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //查询所有的用户
  @RequestMapping(value = "/ssm/userList")
    public List<User> userList(){
        return userMapper.userList();
    }

    //根据id查询用户
    @RequestMapping(value = "/ssm/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userMapper.findById(id);
    }

    //增加用户
    @RequestMapping(value = "/ssm/userAdd")
    public void userAdd(@RequestParam("username") String username, @RequestParam("password") String password){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        userMapper.userAdd(username,password);
    }

    //删除用户
    @RequestMapping(value = "/ssm/userDelete/{id}")
    public void userDelete(@PathVariable("id") Integer id){
            userMapper.userDelete(id);
    }

    //更新用户
    @RequestMapping(value = "/ssm/userUpdate/{id}")
    public void userDelete(@PathVariable("id") Integer id,@RequestParam("username") String username, @RequestParam("password") String password){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.userUpdate(user);

    }

}
