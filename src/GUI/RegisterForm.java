package GUI;

import BLL.UserBLL;

import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;

public class RegisterForm extends JFrame {
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField emailField;
    private JTextField usernameField;
    private JTextField phonenumberField;
    private JTextField addressField;
    private JPasswordField passwordField;
=======

public class RegisterForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
>>>>>>> parent of 81bb9a3 (uppp)
    private UserBLL bll = new UserBLL();

    public RegisterForm() {
        setTitle("Đăng ký");
<<<<<<< HEAD
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(18, 18, 18));

        JLabel titleLabel = new JLabel("Sign up to start shopping");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(135, 32, 500, 40);
        add(titleLabel);

        // Logo placeholder
        JLabel logo = new JLabel();
        logo.setBounds(57, 28, 74, 73);
        logo.setIcon(new ImageIcon("src/images/logo.png")); // Adjust path as needed
        add(logo);

        firstnameField = createTextField("First Name", 63, 153);
        lastnameField = createTextField("Last Name", 512, 153);
        emailField = createTextField("Email", 63, 227);
        addressField = createTextField("Address", 512, 227);
        usernameField = createTextField("Username", 63, 301);
        phonenumberField = createTextField("Phone Number", 512, 301);

        passwordField = new JPasswordField();
        passwordField.setBounds(63, 375, 265, 25);
        passwordField.setToolTipText("Password");
        add(passwordField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(657, 449, 120, 30);
        confirmButton.setBackground(Color.decode("#3BE477"));
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(confirmButton);

        JLabel loginLabel = new JLabel("Already have an account?");
        loginLabel.setForeground(Color.LIGHT_GRAY);
        loginLabel.setBounds(325, 515, 200, 20);
        add(loginLabel);

        JButton loginLink = new JButton("Log in here");
        loginLink.setBorderPainted(false);
        loginLink.setContentAreaFilled(false);
        loginLink.setForeground(Color.CYAN);
        loginLink.setBounds(480, 512, 100, 25);
        loginLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(loginLink);

        confirmButton.addActionListener(e -> {
            String result = bll.validateRegister(
                usernameField.getText().trim(),
                new String(passwordField.getPassword())
            );
=======
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Username:")).setBounds(20, 60, 80, 20);
        txtUser = new JTextField();
        txtUser.setBounds(100, 60, 120, 20);
        add(txtUser);

        add(new JLabel("Password:")).setBounds(20, 100, 80, 20);
        txtPass = new JPasswordField();
        txtPass.setBounds(100, 100, 120, 20);
        add(txtPass);

        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(80, 140, 120, 30);
        add(btnRegister);

        JButton btnBack = new JButton("← Quay lại");
        btnBack.setBounds(80, 180, 120, 25);
        add(btnBack);

        btnRegister.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword());
            String result = bll.validateRegister(user, pass);
>>>>>>> parent of 81bb9a3 (uppp)
            if (result.equals("OK")) {
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                dispose();
                new LoginForm().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, result);
            }
        });

<<<<<<< HEAD
        loginLink.addActionListener(e -> {
=======
        btnBack.addActionListener(e -> {
>>>>>>> parent of 81bb9a3 (uppp)
            dispose();
            new LoginForm().setVisible(true);
        });
    }

    private JTextField createTextField(String placeholder, int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 265, 26);
        field.setToolTipText(placeholder);
        add(field);
        return field;
    }
}
