package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BLL.StatisticalBLL;
import DTO.StatisticalDTO;

import java.awt.*;
import java.util.Vector;

public class statistical extends JPanel {

    private JTable tableRevenue, tableTopCustomers, tableTopProducts, tableCategoryRevenue, tableRevenueRate,tableTopEmployees;
    private JLabel totalSalesLabel, totalOrdersLabel, totalRevenueLabel;
private StatisticalBLL bll = new StatisticalBLL();

    public statistical() {
        initComponents();
        loadMonthlyRevenueData();
        loadTopCustomers();
        loadTopProducts();
        loadBrandRevenue();
        loadRevenueGrowthRate();
        loadTopEmployees();
    }
    public void initComponents() {
        setBackground(new Color(31, 31, 31));
        setLayout(new BorderLayout());

        // Tiêu đề
        JLabel titleLabel = new JLabel("THỐNG KÊ", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(57, 219, 114));
        tabbedPane.setFocusable(false);

        // Doanh thu theo tháng
        tableRevenue = createTable(
                new String[]{"Tháng", "Số đơn hàng", "Sản phẩm bán", "Doanh thu"},
                new Object[][]{
                        {"Tháng 1", 120, 400, 15000000},
                        {"Tháng 2", 95, 350, 12500000}
                }
        );
        tabbedPane.add("Doanh thu theo tháng", createTitledPanel("Doanh thu theo tháng", tableRevenue));


        // Top khách hàng
        tableTopCustomers = createTable(
                new String[]{"Khách hàng", "Số đơn", "Tổng chi (VNĐ)"},
                new Object[][]{
                        {"Nguyễn Văn A", 15, 12000000},
                        {"Trần Thị B", 13, 11000000}
                }
        );
        tabbedPane.add("Top 5 khách hàng", createTitledPanel("Top 5 khách hàng mua nhiều nhất", tableTopCustomers));

        //top nhân viên
        tableTopEmployees = createTable(
                new String[]{"Nhân viên", "Số đơn", "Tổng bán (VNĐ)"},
                new Object[][]{
                        {"Nguyễn Văn A", 15, 12000000},
                        {"Trần Thị B", 13, 11000000}
                }
        );
        tabbedPane.add("Top 5 nhân viên", createTitledPanel("Top 5 nhân viên bán nhiều nhất", tableTopEmployees));

        // Top sản phẩm
        tableTopProducts = createTable(
                new String[]{"Sản phẩm", "Số lượng bán", "Doanh thu (VNĐ)"},
                new Object[][]{
                        {"Áo thun", 150, 4500000},
                        {"Giày", 130, 7800000}
                }
        );
        tabbedPane.add("Top 5 sản phẩm", createTitledPanel("Top 5 sản phẩm bán chạy", tableTopProducts));

       

        // Doanh thu theo danh mục
        tableCategoryRevenue = createTable(
                new String[]{"Hãng sản phẩm", "Doanh thu (VNĐ)"},
                new Object[][]{
                        {"Thời trang", 25000000},
                        {"Công nghệ", 32000000}
                }
        );
        tabbedPane.add("Theo hãng", createTitledPanel("Doanh thu theo hãng sản phẩm", tableCategoryRevenue));

        // Tỷ lệ tăng/giảm
        tableRevenueRate = createTable(
                new String[]{"Tháng", "So với tháng trước (%)"},
                new Object[][]{
                        {"Tháng 4", "+5%"},
                        {"Tháng 5", "-3%"}
                }
        );
        tabbedPane.add("Tăng/Giảm doanh thu", createTitledPanel("Tỷ lệ tăng/giảm doanh thu", tableRevenueRate));

        add(tabbedPane, BorderLayout.CENTER);

        // Panel thống kê tổng
        JPanel summaryPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        summaryPanel.setBackground(new Color(31, 31, 31));

        totalOrdersLabel = new JLabel("Tổng đơn hàng: ", JLabel.CENTER);
        totalOrdersLabel.setForeground(Color.white);
        totalSalesLabel = new JLabel("Tổng sản phẩm bán: ", JLabel.CENTER);
        totalSalesLabel.setForeground(Color.white);
        totalRevenueLabel = new JLabel("Tổng doanh thu: ", JLabel.CENTER);
        totalRevenueLabel.setForeground(Color.white);

        Font summaryFont = new Font("Arial", Font.BOLD, 16);
        totalOrdersLabel.setFont(summaryFont);
        totalSalesLabel.setFont(summaryFont);
        totalRevenueLabel.setFont(summaryFont);
        

        summaryPanel.add(totalOrdersLabel);
        summaryPanel.add(totalSalesLabel);
        summaryPanel.add(totalRevenueLabel);

        add(summaryPanel, BorderLayout.SOUTH);
   
        }
        

    private JTable createTable(String[] columns, Object[][] data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô nào cả
            }
        };
    
        JTable table = new JTable(model);
        table.setEnabled(false); // Tùy chọn: cũng ngăn chọn ô nếu bạn muốn bảng chỉ để hiển thị
        return table;
    }
    
    private JPanel createTitledPanel(String title, JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
    private void loadTopCustomers() {
        Vector<StatisticalDTO> customers = bll.getTopCus();
    
        String[] columns = {"Khách hàng", "Số đơn", "Tổng chi (VNĐ)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
    
        for (StatisticalDTO dto : customers) {
            Object[] row = new Object[]{
                dto.getFullName(),
                dto.getOrderCount(),
                String.format("%,.0f VNĐ", dto.getTotalSpent())
            };
            model.addRow(row);
        }
    
        tableTopCustomers.setModel(model);
    }
    
    
    private void loadMonthlyRevenueData() {
    Vector<StatisticalDTO> stats = bll.getMonthlyStatistics();

    String[] columns = {"Tháng", "Số đơn hàng", "Sản phẩm bán", "Doanh thu"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);

    int totalOrders = 0;
    int totalProducts = 0;
    double totalRevenue = 0;

    for (StatisticalDTO dto : stats) {
        Object[] row = new Object[]{
                "Tháng " + dto.getMonth(),
                dto.getTotalOrders(),
                dto.getTotalProductsSold(),
                String.format("%,.0f VNĐ", dto.getTotalRevenue())
        };
        model.addRow(row);

        totalOrders += dto.getTotalOrders();
        totalProducts += dto.getTotalProductsSold();
        totalRevenue += dto.getTotalRevenue();
    }

    tableRevenue.setModel(model);

    // Cập nhật tổng doanh thu
    totalOrdersLabel.setText("Tổng đơn hàng: " + totalOrders);
    totalSalesLabel.setText("Tổng sản phẩm bán: " + totalProducts);
    totalRevenueLabel.setText("Tổng doanh thu: " + String.format("%,.0f VNĐ", totalRevenue));
    
}
private void loadTopEmployees() {
        Vector<StatisticalDTO> employees = bll.getTopem();
    
        String[] columns = {"Nhân viên", "Số đơn", "Tổng bán (VNĐ)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
    
        for (StatisticalDTO dto : employees) {
            Object[] row = new Object[]{
                    dto.getUserName(),
                    dto.getOrderCount(),
                    String.format("%,.0f VNĐ", dto.getTotalSpent())
            };
            model.addRow(row);
        }
    
        tableTopEmployees.setModel(model);
    }
    
private void loadTopProducts() {
        Vector<StatisticalDTO> products = bll.getToppro();
    
        String[] columns = {"Sản phẩm", "Số lượng bán", "Doanh thu (VNĐ)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
    
        for (StatisticalDTO dto : products) {
            Object[] row = new Object[]{
                    dto.getProductName(),
                    dto.getQuantitySold(),
                    String.format("%,.0f VNĐ", dto.getRevenue())
            };
            model.addRow(row);
        }
    
        tableTopProducts.setModel(model);
    }
    private void loadBrandRevenue() {
        Vector<StatisticalDTO> brands = bll.getBrandre();
    
        String[] columns = {"Hãng sản phẩm", "Doanh thu (VNĐ)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
    
        for (StatisticalDTO dto : brands) {
            Object[] row = new Object[]{
                    dto.getBrand(),
                    String.format("%,.0f VNĐ", dto.getRevenue())
            };
            model.addRow(row);
        }
    
        tableCategoryRevenue.setModel(model);
    }
    private void loadRevenueGrowthRate() {
        Vector<String[]> growthRates = bll.getRevenueGrowthRate();
    
        String[] columns = {"Tháng", "So với tháng trước (%)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
    
        for (String[] row : growthRates) {
            model.addRow(row);
        }
    
        tableRevenueRate.setModel(model);
    }
    
    
    

}
