package cn.com.guet.service;
import cn.com.guet.bean.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUser();
    Users login(String username);
}
