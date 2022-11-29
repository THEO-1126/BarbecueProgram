package cn.com.guet.service.Imple;

import cn.com.guet.bean.Users;
import cn.com.guet.dao.Imple.UserDaoImpl;
import cn.com.guet.dao.UserDao;
import cn.com.guet.service.UserService;

import java.security.MessageDigest;
import java.util.List;

public class UserServiceImpl implements UserService {
    // 层与层之间要依赖接口
    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public List<Users> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Users login(String username) {
        return null;
    }
}
