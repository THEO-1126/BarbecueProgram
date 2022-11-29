package cn.com.guet.dao;

import cn.com.guet.bean.Users;

import java.util.List;

public interface UserDao {
    List<Users> getAllUser();
    Users login(String username);
}
