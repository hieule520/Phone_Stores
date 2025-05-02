package GUI;

import BLL.UserBLL;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private final UserBLL bll = new UserBLL();



    public LoginForm() {
        setTitle("Đăng nhập - New Era");
        setSize(1043, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(29, 29, 29)); // #1D1D1D

        // Ảnh bên trái
        ImageIcon img1 = new ImageIcon("src/img/NewEra-icon.png");
        Image img11 = img1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel img12 = new JLabel(new ImageIcon(img11));
        img12.setBounds(14, 33, 482, 509);
        add(img12);
        // Panel đăng nhập bên phải
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(18, 18, 18)); // #121212
        panel.setBounds(496, -13, 532, 885);
        add(panel);

        // Logo
        ImageIcon logoIcon = new ImageIcon("src/img/newera-logo.png");
        Image logoImg = logoIcon.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(logoImg));
        logo.setBounds(219, 54, 94, 50);
        panel.add(logo);

        // Tiêu đề
        JLabel lblTitle = new JLabel("Log in to New Era");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setBounds(182, 115, 200, 27);
        panel.add(lblTitle);

        // Trường username
        txtUser = new JTextField();
        txtUser.setBounds(125, 189, 282, 31);
        txtUser.setToolTipText("Email or username");
        panel.add(txtUser);

        // Trường password
        txtPass = new JPasswordField();
        txtPass.setBounds(124, 256, 282, 31);
        txtPass.setToolTipText("Password");
        panel.add(txtPass);

        // Nút đăng nhập
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnLogin.setBounds(125, 332, 282, 27);
        btnLogin.setBackground(new Color(30, 215, 96));
        panel.add(btnLogin);

        // Nhãn “chưa có tài khoản”
        JLabel lblNoAccount = new JLabel("Don't have an account?");
        lblNoAccount.setForeground(new Color(188, 186, 186));
        lblNoAccount.setBounds(180, 387, 150, 20);
        panel.add(lblNoAccount);

        // Nút đăng ký
        JButton btnSignUp = new JButton("Sign up");
        btnSignUp.setBorderPainted(false);
        btnSignUp.setOpaque(false);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setForeground(Color.CYAN.darker());
        btnSignUp.setBounds(304, 384, 80, 25);
        panel.add(btnSignUp);

        // Sự kiện nút đăng nhập
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword());
            if (bll.validateLogin(user, pass)) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                dispose();
                new HomeForm(user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
            }
        });

        // Sự kiện nút đăng ký
        btnSignUp.addActionListener(e -> {
            dispose();
            new RegisterForm().setVisible(true);
        });
    }
}
