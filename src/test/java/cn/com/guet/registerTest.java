package cn.com.guet;

import cn.com.guet.service.PasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerTest {
    static boolean register(String username, String password) {
        //String sql = "INSERT INTO USER (username,password) values(?,?)";// ��Javaȥִ������SQL�������ȡ����
        String sqlTest="INSERT INTO USER (username,password) SELECT ?,? FROM USER WHERE NOT EXISTS(SELECT 1 FROM USER WHERE username=? limit 1)";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn;// ��ʾ���ݿ�����Ӷ���
        PreparedStatement pstmt;// ��ʾSQL���Ķ���
        try {
            conn = DriverManager.getConnection(url, "root", "THEO1126");
            pstmt = conn.prepareStatement(sqlTest);// pstmt��sql���������
            password = PasswordEncoder.encryptToMD5(password);
            pstmt.setString(1,username); // username�����һ��������
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
