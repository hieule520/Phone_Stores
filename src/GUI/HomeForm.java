package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import DTO.EmployeeDTO;
import java.awt.*;
import java.awt.event.*;
import GUI.StorePanel;
import GUI.WareHousePanel;

public class HomeForm extends JFrame {
    private JPanel contentPanel;  
    private EmployeeDTO currEmployee;


    public HomeForm(EmployeeDTO emp) {
        this.currEmployee=emp;
        initComponents();
    }
    private void initComponents(){
        Border border = BorderFactory.createLineBorder(new Color(176, 253, 224),5);
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
        ImageIcon menuIcon = new ImageIcon("img/other/newera-icon2.png");
        Image menuIcon1 = menuIcon.getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
        ImageIcon menuIcon2 = new ImageIcon(menuIcon1);
        menuPanel.setPreferredSize(new Dimension(150, 700));
        menuPanel.setLayout(null);
        menuPanel.setBackground(new Color(176, 253, 224));
        JLabel logoLabel = new JLabel(menuIcon2);
        logoLabel.setBounds(25, 30, 100, 50); // điều chỉnh vị trí cho hợp lý
        menuPanel.add(logoLabel);
        

        menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton storeBtn = new JButton("Cửa hàng");
        ImageIcon storeIcon = new ImageIcon("img/other/store.png");
        Image storeIcon1 = storeIcon.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH);
        ImageIcon storeIcon2 = new ImageIcon(storeIcon1);
        storeBtn.setIcon(storeIcon2);
        storeBtn.setIconTextGap(10);
        storeBtn.setBounds(1, 130, 148, 50);
        storeBtn.setFocusable(false);
        storeBtn.setBorder(border);
        storeBtn.setFont(new Font("Arial", Font.BOLD, 13));
        storeBtn.setBackground(new Color(176, 253, 224));
        storeBtn.setForeground(new Color(51, 56, 54));
        JButton employeeBtn = new JButton("Nhân Viên");
        employeeBtn.setBounds(1, 300, 120, 50);
        JButton customerBtn = new JButton("Khách hàng");
        customerBtn.setBounds(1, 500, 120, 50);





        JButton warehouseBtn = new JButton("Kho");
        ImageIcon warehouseIcon = new ImageIcon("img/other/warehouse.png");
        Image warehouseIcon1 = warehouseIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon warehouseIcon2 = new ImageIcon(warehouseIcon1);
        warehouseBtn.setIcon(warehouseIcon2);
        warehouseBtn.setIconTextGap(10);
        warehouseBtn.setBounds(1, 230, 148, 50);
        warehouseBtn.setFocusable(false);
        warehouseBtn.setBorder(border);
        warehouseBtn.setFont(new Font("Arial", Font.BOLD, 13));
        warehouseBtn.setBackground(new Color(176, 253, 224));
        warehouseBtn.setForeground(new Color(51, 56, 54));
        JButton accountBtn = new JButton("Tài khoản");
        ImageIcon accountIcon = new ImageIcon("img/other/accounting.png");
        Image accountIcon1 = accountIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon accountIcon2 = new ImageIcon(accountIcon1);
        accountBtn.setIcon(accountIcon2);
        accountBtn.setIconTextGap(10);
        accountBtn.setBounds(1, 330, 148, 50);
        accountBtn.setFocusable(false);
        accountBtn.setBorder(border);
        accountBtn.setFont(new Font("Arial", Font.BOLD, 13));
        accountBtn.setBackground(new Color(176, 253, 224));
        accountBtn.setForeground(new Color(51, 56, 54));
        JButton statsBtn = new JButton("Thống kê");
        ImageIcon statsIcon = new ImageIcon("img/other/description.png");
        Image statsIcon1 = statsIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon statsIcon2 = new ImageIcon(statsIcon1);
        statsBtn.setIcon(statsIcon2);
        statsBtn.setIconTextGap(10);
        statsBtn.setBounds(1, 430, 148, 50);
        statsBtn.setFocusable(false);
        statsBtn.setBorder(border);
        statsBtn.setFont(new Font("Arial", Font.BOLD, 13));
        statsBtn.setBackground(new Color(176, 253, 224));
        statsBtn.setForeground(new Color(51, 56, 54));
        JButton exitBtn = new JButton("Thoát");
        ImageIcon exitIcon = new ImageIcon("img/other/exit.png");
        Image exitIcon1 = exitIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon exitIcon2 = new ImageIcon(exitIcon1);
        exitBtn.setIcon(exitIcon2);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 15));
        exitBtn.setBounds(1,705,148,50);
        exitBtn.setFocusable(false);
        exitBtn.setBorder(border);
        exitBtn.setBackground(new Color(176, 253, 224));
        exitBtn.setIconTextGap(7);
        exitBtn.setForeground(new Color(51, 56, 54));
        
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
        contentPanel.add(new StorePanel(currEmployee), "store");
        contentPanel.add(new WareHousePanel(), "warehouse");
        contentPanel.add(new EmployeePanel(), "employee");
        contentPanel.add(new CustomerPanel(), "customer");
        contentPanel.add(new statistical(), "stats");

        // Sự kiện nút chuyển panel
        storeBtn.addActionListener(e -> switchPanel("store"));
        warehouseBtn.addActionListener(e -> switchPanel("warehouse"));
        employeeBtn.addActionListener(e -> switchPanel("employee"));
        statsBtn.addActionListener(e -> switchPanel("stats"));
        customerBtn.addActionListener(e -> switchPanel("customer"));

        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    

    private void switchPanel(String name) {
        CardLayout cl = (CardLayout) (contentPanel.getLayout());
        cl.show(contentPanel, name);
    }
}
