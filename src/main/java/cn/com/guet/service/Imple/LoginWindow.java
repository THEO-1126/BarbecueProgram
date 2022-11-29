package cn.com.guet.service.Imple;

import cn.com.guet.bean.Users;
import cn.com.guet.dao.Imple.UserDaoImpl;
import cn.com.guet.dao.UserDao;
import cn.com.guet.service.PasswordEncoder;
import cn.com.guet.service.UserService;
import cn.com.guet.ui.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LoginWindow extends JFrame implements UserService{
    // 层与层之间要依赖接口
    private UserDao userDao;
    private JPanel loginPanel,registerPanel,currentPanel,parentPanel;
    private JLabel label, usernameLable, passwordLable,accountType;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton consumerRbtn, storeRbtn;
    private ButtonGroup buttonGroup;
    private ImageIcon backgroundIcon = new ImageIcon("src/main/resources/picture/back.png");
    private ImageIcon titleIcon=new ImageIcon("src/main/resources/picture/烧烤.png");
    private JButton  loginBtn,resetBtn,exitBtn,registerBtn,backloginBtn,sureRegisterBtn;
    private Font ChineseFont = new Font("宋体", Font.BOLD, 20);
    private Font EnglishFont=new Font("Times New Roman",Font.PLAIN,20);
    private Color color1=new Color(255, 92, 54);
    private boolean loginFlag;

    public LoginWindow(){
        userDao = new UserDaoImpl();
        /* 设置标题和图标 */
        setTitle("烧烤店");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(titleIcon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        /* 设置窗口背景色 */
        parentPanel=(JPanel) getContentPane();
        label = new JLabel(backgroundIcon);
        getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        label.setBounds(0, 0, backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
        parentPanel.setOpaque(false); // contentPane设置成透明的
        currentPanel=displayLoginPanel();
        parentPanel.add(currentPanel);
        setVisible(true);
    }

    /* 显示登录面板 */
    JPanel displayLoginPanel(){
        loginPanel=new JPanel();
        loginPanel.setOpaque(false);//将面板设置为透明
        loginPanel.setLayout(null);

        /* 副标题 */
        JLabel SutitleLabel = new JLabel("烧烤店 登录界面");
        SutitleLabel.setBounds(130,30,300,50);
        SutitleLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
        SutitleLabel.setForeground(color1);
        loginPanel.add(SutitleLabel);
        /* 账户类型 单选按钮*/
        accountType = new JLabel("账户类型:");
        accountType.setBounds(120, 100, 100, 28);
        accountType.setForeground(color1);
        accountType.setFont(ChineseFont);
        loginPanel.add(accountType);

        consumerRbtn = new JRadioButton("消费者", true);
        consumerRbtn.setBounds(220, 107, 20, 15);
        consumerRbtn.setBackground(new Color(250,211,161));
        JLabel consumerLable = new JLabel("消费者");
        consumerLable.setForeground(Color.red);
        consumerLable.setBounds(240, 107, 40, 15);
        loginPanel.add(consumerLable);

        storeRbtn = new JRadioButton("店家");
        storeRbtn.setBounds(300, 107, 20, 15);
        storeRbtn.setBackground(new Color(250,211,161));
        JLabel storeLable = new JLabel("店家");
        storeLable.setBounds(320, 107, 30, 15);
        storeLable.setForeground(Color.red);
        loginPanel.add(storeLable);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(storeRbtn);
        buttonGroup.add(consumerRbtn);
        loginPanel.add(storeRbtn);
        loginPanel.add(consumerRbtn);

        /* 用户名和密码输入部分 */
        //用户名
        usernameLable = new JLabel("用户名:");
        usernameLable.setForeground(color1);
        usernameLable.setBounds(120, 140, 100, 28);
        usernameLable.setFont(ChineseFont);
        loginPanel.add(usernameLable);

        usernameField = new JTextField();
        usernameField.setBounds(200, 140, 150, 23);
        usernameField.setFont(ChineseFont);
        loginPanel.add(usernameField);

        //密码
        passwordLable = new JLabel("密  码:");
        passwordLable.setBounds(120, 180, 100, 28);
        passwordLable.setForeground(color1);
        passwordLable.setFont(ChineseFont);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 182, 150, 23);
        loginPanel.add(passwordLable);
        loginPanel.add(passwordField);

        /* 登录按钮 */
        loginBtn = new JButton("登录");
        loginBtn.setBackground(color1);
        loginBtn.setForeground(Color.YELLOW);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(ChineseFont);
        loginBtn.setBounds(100, 250, 75, 32);
        loginPanel.add(loginBtn);
        loginBtn.addActionListener(
                e->{
                    String username=usernameField.getText(); // 拿到输入框的用户名
                    /*
                        1. 拿到用户名和密码
                        2. 把用户名和密码传入Service的login
                        3. service 的login 中调用

                     */

                }
        );

        /* 重置按钮 */
        resetBtn = new JButton("重置");
        resetBtn.setBackground(color1);
        resetBtn.setForeground(Color.YELLOW);
        resetBtn.setFocusPainted(false);
        resetBtn.setFont(ChineseFont);
        resetBtn.setBounds(200, 250, 75, 32);
        loginPanel.add(resetBtn);
        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {setCursor(new Cursor(12));}

            @Override
            public void mouseExited(MouseEvent e) {setCursor(new Cursor(0));}
            public void mousePressed(MouseEvent e)  {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        /* 退出按钮 */
        exitBtn=new JButton("退出");
        exitBtn.setBackground(color1);
        exitBtn.setForeground(Color.YELLOW);
        exitBtn.setFocusPainted(false);
        exitBtn.setFont(ChineseFont);
        exitBtn.setBounds(200, 300, 75, 32);
        loginPanel.add(exitBtn);
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(12));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(0));
            }
            public void mousePressed(MouseEvent e)  {
                System.exit(0);// 退出系统
            }
        });
        /* 注册按钮 */
        registerBtn = new JButton("注册");
        registerBtn.setBackground(color1);
        registerBtn.setForeground(Color.YELLOW);
        registerBtn.setFocusPainted(false);
        registerBtn.setFont(ChineseFont);
        registerBtn.setBounds(300, 250, 75, 32);
        loginPanel.add(registerBtn);
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(12));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(0));
            }
            /* 点击注册，进入注册面板 */
            public void mousePressed(MouseEvent e)  {
                System.out.println("注册面板");
                parentPanel.remove(loginPanel);
                currentPanel=displayRegisterPanel();
                parentPanel.add(currentPanel);
                parentPanel.revalidate();
                parentPanel.repaint();
            }
        });
        return loginPanel;
    }
    /* 显示注册面板 */
    JPanel displayRegisterPanel(){
        registerPanel = new JPanel();
        registerPanel.setOpaque(false);//将面板设置为透明
        registerPanel.setLayout(null);

        /* 副标题 */
        JLabel SutitleLabel = new JLabel("烧烤店 注册界面");
        SutitleLabel.setBounds(130,30,300,50);
        SutitleLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
        SutitleLabel.setForeground(color1);
        registerPanel.add(SutitleLabel);

        /* 用户名和密码输入部分 */
        //用户名
        usernameLable = new JLabel("用户名:");
        usernameLable.setForeground(color1);
        usernameLable.setBounds(120, 140, 100, 28);
        usernameLable.setFont(ChineseFont);
        registerPanel.add(usernameLable);

        usernameField = new JTextField();
        usernameField.setBounds(200, 140, 150, 23);
        usernameField.setFont(ChineseFont);
        registerPanel.add(usernameField);

        //密码
        passwordLable = new JLabel("密  码:");
        passwordLable.setBounds(120, 180, 100, 28);
        passwordLable.setForeground(color1);
        passwordLable.setFont(ChineseFont);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 182, 150, 23);
        registerPanel.add(passwordLable);
        registerPanel.add(passwordField);

        /* 确认注册按钮 */
        sureRegisterBtn = new JButton("确认注册");
        sureRegisterBtn.setBackground(color1);
        sureRegisterBtn.setForeground(Color.YELLOW);
        sureRegisterBtn.setFocusPainted(false);
        sureRegisterBtn.setFont(ChineseFont);
        sureRegisterBtn.setBounds(180, 250, 120, 32);
        registerPanel.add(sureRegisterBtn);
        sureRegisterBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(12));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(0));
            }
            /* 点击确认注册按钮 */
            public void mousePressed(MouseEvent e)  {
                String username=usernameField.getText();
                String password=passwordField.getText();
                if(register(username,password)){
                    System.out.println(username+","+password);
                    System.out.println("注册成功！");
                }else {
                    System.out.println("注册失败");
                }
            }
        });

        /* 回到登录面板按钮 */
        backloginBtn = new JButton("回到登录页面");
        backloginBtn.setBackground(color1);
        backloginBtn.setForeground(Color.YELLOW);
        backloginBtn.setFocusPainted(false);
        backloginBtn.setFont(ChineseFont);
        backloginBtn.setBounds(150, 300, 180, 32);
        registerPanel.add(backloginBtn);
        backloginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(12));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(0));
            }
            /* 点击回到登录页面按钮 */
            public void mousePressed(MouseEvent e)  {
                System.out.println("返回登录界面");
                parentPanel.remove(registerPanel);
                currentPanel=displayLoginPanel();
                parentPanel.add(currentPanel);
                parentPanel.revalidate();
                parentPanel.repaint();
            }
        });

        return registerPanel;
    }

    @Override
    public List<Users> getAllUser() {
        return null;
    }

    @Override
    public Users login(String username) {
        return null;
    }

    public boolean register(String username, String password) {
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

