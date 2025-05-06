package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import DTO.EmployeeDTO;
import DTO.ProductsDTO;
import BLL.ProductsBLL;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;

import GUI.StorePanel;
import GUI.WareHousePanel;

public class HomeForm extends JFrame {
    private JPanel contentPanel;  
    private EmployeeDTO currEmployee;
    ProductsBLL productsBLL = new ProductsBLL();
    Vector<ProductsDTO> productList = productsBLL.getAllProducts();


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
        ImageIcon employeeIcon = new ImageIcon("img/other/employees.png");
        Image employeeIcon1 = employeeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon employeeIcon2 = new ImageIcon(employeeIcon1);
        employeeBtn.setIcon(employeeIcon2);
        employeeBtn.setIconTextGap(10);
        employeeBtn.setBounds(1, 330, 148, 50);
        employeeBtn.setFocusable(false);
        employeeBtn.setBorder(border);
        employeeBtn.setFont(new Font("Arial", Font.BOLD, 13));
        employeeBtn.setBackground(new Color(176, 253, 224));
        employeeBtn.setForeground(new Color(51, 56, 54));
        JButton customerBtn = new JButton("Khách hàng");
        ImageIcon customerIcon = new ImageIcon("img/other/rating.png");
        Image customerIcon1 = customerIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon customerIcon2 = new ImageIcon(customerIcon1);
        customerBtn.setIcon(customerIcon2);
        customerBtn.setIconTextGap(10);
        customerBtn.setBounds(1, 430, 148, 50);
        customerBtn.setFocusable(false);
        customerBtn.setBorder(border);
        customerBtn.setFont(new Font("Arial", Font.BOLD, 13));
        customerBtn.setBackground(new Color(176, 253, 224));
        customerBtn.setForeground(new Color(51, 56, 54));
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
    
        JButton statsBtn = new JButton("Thống kê");
        ImageIcon statsIcon = new ImageIcon("img/other/description.png");
        Image statsIcon1 = statsIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon statsIcon2 = new ImageIcon(statsIcon1);
        statsBtn.setIcon(statsIcon2);
        statsBtn.setIconTextGap(10);
        statsBtn.setBounds(1, 530, 148, 50);
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
        menuPanel.add(employeeBtn);
        menuPanel.add(customerBtn);
        menuPanel.add(storeBtn);
        menuPanel.add(warehouseBtn);
        menuPanel.add(statsBtn);

        // Panel nội dung trung tâm với CardLayout
        contentPanel = new JPanel(new CardLayout());
        contentPanel.add(new StorePanel(currEmployee), "store");

        WareHousePanel warehousePanel = new WareHousePanel(); 
        contentPanel.add(warehousePanel, "warehouse");
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
    public void loadProductList(){
        //Tạo modelSP cho table chứa sản phẩm
        
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("ProductID");
        model.addColumn("ProductName");
        model.addColumn("Type");
        model.addColumn("Brand");
        model.addColumn("Stock");
        model.addColumn("Prices");
        model.addColumn("Status");
        model.addColumn("Date");
        model.addColumn("Images");
        table.setModel(model);

        Vector<ProductsDTO> arr = new Vector<ProductsDTO>();
        arr = productsBLL.getAllProducts();
        for(int i=0;i<arr.size();i++){
            ProductsDTO p = arr.get(i);
            int ma = p.getProductID();
            String ten = p.getProductName();
            String loai = p.getType();
            String hang = p.getBrand();
            int soLuong = p.getStock();
            BigDecimal gia = p.getPrices();
            String trangthai = p.getStatus();
            String anh = p.getImages();
            Date time = p.getDate();
            Object[] row = {ma, ten, loai, hang, soLuong, gia, trangthai, time, anh};
            model.addRow(row);
       }
   }
}
