package cn.com.guet;

import cn.com.guet.service.PasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerTest {
    static boolean register(String username, String password) {
        //String sql = "INSERT INTO USER (username,password) values(?,?)";// 用Java去执行这条SQL语句来获取数据
        String sqlTest="INSERT INTO USER (username,password) SELECT ?,? FROM USER WHERE NOT EXISTS(SELECT 1 FROM USER WHERE username=? limit 1)";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn;// 表示数据库的连接对象
        PreparedStatement pstmt;// 表示SQL语句的对象
        try {
            conn = DriverManager.getConnection(url, "root", "THEO1126");
            pstmt = conn.prepareStatement(sqlTest);// pstmt和sql语句做关联
            password = PasswordEncoder.encryptToMD5(password);
            pstmt.setString(1,username); // username插入第一个？符中
            pstmt.setString(2,password);
            pstmt.setString(3,username);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
