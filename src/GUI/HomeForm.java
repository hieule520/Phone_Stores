package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import GUI.StorePanel;
import GUI.WareHousePanel;

public class HomeForm extends JFrame {
    private JPanel contentPanel;  


    public HomeForm() {
        ImageIcon favicon = new ImageIcon("img/other/newera-logo.png");
        setIconImage(favicon.getImage());
        setTitle("Trang chính");
        setSize(1240, 790);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
       
        // Panel menu trái
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(150, 700));
        menuPanel.setLayout(null);
        menuPanel.setBackground(new Color(58, 83, 96));

        menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton storeBtn = new JButton("Cửa hàng");
        storeBtn.setBounds(1, 130, 148, 50);
        storeBtn.setFocusable(false);
        storeBtn.setBackground(new Color(84, 106, 117));
        storeBtn.setForeground(Color.white);
        JButton warehouseBtn = new JButton("Kho");
        warehouseBtn.setBounds(1, 230, 148, 50);
        warehouseBtn.setFocusable(false);
        warehouseBtn.setBackground(new Color(84, 106, 117));
        warehouseBtn.setForeground(Color.white);
        JButton accountBtn = new JButton("Tài khoản");
        accountBtn.setBounds(1, 330, 148, 50);
        accountBtn.setFocusable(false);
        accountBtn.setBackground(new Color(84, 106, 117));
        accountBtn.setForeground(Color.white);
        JButton statsBtn = new JButton("Thống kê");
        statsBtn.setBounds(1, 430, 148, 50);
        statsBtn.setFocusable(false);
        statsBtn.setBackground(new Color(84, 106, 117));
        statsBtn.setForeground(Color.white);
        JButton exitBtn = new JButton("Thoát");
        exitBtn.setBounds(1,705,148,50);
        exitBtn.setFocusable(false);
        exitBtn.setBackground(new Color(84, 106, 117));
        exitBtn.setForeground(Color.white);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               int a = JOptionPane.showConfirmDialog(HomeForm.this,"có muốn không","thoát về màn hình đăng nhập", JOptionPane.YES_NO_OPTION);
               if (a == JOptionPane.YES_OPTION) {
                dispose();
                new LoginForm().setVisible(true);
            }
            }
        });

        menuPanel.add(exitBtn);
        menuPanel.add(storeBtn);
        menuPanel.add(warehouseBtn);
        menuPanel.add(accountBtn);
        menuPanel.add(statsBtn);

        // Panel nội dung trung tâm với CardLayout
        contentPanel = new JPanel(new CardLayout());
        contentPanel.add(new StorePanel(), "store");
        contentPanel.add(new WareHousePanel(), "warehouse");
        contentPanel.add(new JLabel("Giao diện Tài khoản"), "account");
        contentPanel.add(new statistical(), "stats");

        // Sự kiện nút chuyển panel
        storeBtn.addActionListener(e -> switchPanel("store"));
        warehouseBtn.addActionListener(e -> switchPanel("warehouse"));
        accountBtn.addActionListener(e -> switchPanel("account"));
        statsBtn.addActionListener(e -> switchPanel("stats"));

        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    

    private void switchPanel(String name) {
        CardLayout cl = (CardLayout) (contentPanel.getLayout());
        cl.show(contentPanel, name);
    }
}
