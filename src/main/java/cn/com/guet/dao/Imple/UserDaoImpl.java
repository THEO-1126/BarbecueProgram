package cn.com.guet.dao.Imple;

import cn.com.guet.bean.Users;
import cn.com.guet.dao.UserDao;
import cn.com.guet.service.PasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<Users> getAllUser() {
        return null;
    }

    @Override
    public Users login(String username) {
        return null;
    }

    /*
        注册功能: 相当于向数据库增加数据
    */

}
