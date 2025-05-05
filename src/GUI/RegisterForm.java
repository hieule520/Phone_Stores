package GUI;

import BLL.EmployeeBLL;
import DTO.EmployeeDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JTextField usernameField, phoneField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterForm() {
        ImageIcon favicon = new ImageIcon("img/other/newera-logo.png");
        setIconImage(favicon.getImage());
        setTitle("Sign up to start shopping");
        setSize(700, 420);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Left panel
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBackground(new Color(59, 228, 119));
        leftPanel.setPreferredSize(new Dimension(180, 550));
        add(leftPanel, BorderLayout.WEST);

        ImageIcon barcode = new ImageIcon("img/other/barcode.png");
        Image barcode1 = barcode.getImage().getScaledInstance(200, 900, Image.SCALE_SMOOTH);
        ImageIcon barcode2 = new ImageIcon(barcode1);
        JLabel leftImage = new JLabel(barcode2);
        leftImage.setBounds(-80, -200, 200, 900);
        leftPanel.add(leftImage);

        // Right panel
        JPanel rightPanel = new JPanel(null);
        rightPanel.setBackground(new Color(18, 18, 18));
        add(rightPanel, BorderLayout.CENTER);

        JLabel title = new JLabel("Sign up to start shopping");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(100, 30, 400, 30);
        rightPanel.add(title);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(60, 100, 100, 25);
        rightPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 100, 250, 30);
        rightPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(60, 160, 100, 25);
        rightPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 160, 250, 30);
        rightPanel.add(passwordField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setBounds(60, 220, 100, 25);
        rightPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(180, 220, 250, 30);
        rightPanel.add(phoneField);

        registerButton = new Roundbtn("Confirm");
        registerButton.setBounds(310, 280, 120, 35);
        registerButton.setBackground(new Color(30, 215, 96));
        registerButton.setForeground(Color.black);
        registerButton.setFocusable(false);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                registerAction(e);
            }
        });
        rightPanel.add(registerButton);

        JLabel question = new JLabel("Already have an account?");
        question.setForeground(new Color(188, 186, 186));
        question.setBounds(130, 330, 180, 25);
        rightPanel.add(question);

        JButton loginLink = new JButton("Log in here");
        loginLink.setBounds(260, 328, 120, 28);
        loginLink.setBorderPainted(false);
        loginLink.setForeground(new Color(35, 169, 242));
        loginLink.setContentAreaFilled(false);
        loginLink.setFocusPainted(false);
        loginLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginForm().setVisible(true);
            }
        });
        rightPanel.add(loginLink);
    }

    private void registerAction(ActionEvent e){
        try{
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String phone = phoneField.getText().trim();

            if(username.equals("") || password.equals("") || phone.equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
                return;
            }

            if(password.length() < 8){
                JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 8 ký tự trở lên");
                return;
            }

            if(phone.length() != 10){
                JOptionPane.showMessageDialog(this, "Số điện thoại phải đủ 10 số");
                return;
            }

            EmployeeDTO empl = new EmployeeDTO();
            empl.setUsername(username);
            empl.setPassword(password);
            empl.setPhone(phone);

            EmployeeBLL empBLL = new EmployeeBLL();
            String result = empBLL.addEmployee(empl);
            JOptionPane.showMessageDialog(this, result);

            if(result.equals("Đăng ký thành công")){
                dispose();
                new LoginForm().setVisible(true);
            }

        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Thông tin không hợp lệ");
        }
    }
}
