package GUI;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import BLL.ProductsBLL;
import DTO.ProductsDTO;

public class WareHousePanel extends JPanel {
    private JTable table;
    private JTextField tfProductID, tfProductName, tfStock, tfPrice;
    private JComboBox<String> cbType, cbBrand, cbStatus;

    ProductsBLL productsBLL = new ProductsBLL();
    Vector<ProductsDTO> productList = productsBLL.getAllProducts();

    public WareHousePanel() {
        setLayout(null);
        setBackground(new Color(18, 18, 18)); 

        // Table
        String[] columns = {"ProductID", "Product Name", "Type", "Brand", "Stock", "Prices", "Status", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0){
           
       @Override
        public boolean isCellEditable(int row, int column) {
        return false; // Tất cả các ô đều không thể chỉnh sửa
    }
};

// Lặp qua danh sách sản phẩm và thêm dữ liệu vào bảng
for (ProductsDTO product : productList) {
    Object[] row = new Object[9]; 
    row[0] = product.getProductID();
    row[1] = product.getProductName();
    row[2] = product.getType();
    row[3] = product.getBrand();
    row[4] = product.getStock();
    row[5] = product.getPrices();
    row[6] = product.getStatus();
    row[7] = product.getDate();
    model.addRow(row); 
}


        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 15, 1040, 350);
        add(scrollPane);

        // Separator
        JSeparator separator = new JSeparator();
        separator.setBounds(15, 384, 1040, 1);
        separator.setForeground(new Color(57, 219, 114));
        add(separator);

        // Labels & Fields
        addLabel("ID sản Phẩm:", 145, 414);
        tfProductID = addTextField(255, 412);
        tfProductID.setEditable(false);

        addLabel("Tên Sản Phẩm:", 130, 477);
        tfProductName = addTextField(255, 475);

        addLabel("Hệ Điều Hành:", 137, 538);
        cbType = addComboBox(new String[]{"Ios", "Android"}, 255, 536);

        addLabel("Hãng:", 190, 594);
        cbBrand = addComboBox(new String[]{"Apple", "Samsung", "Xiaomi", "Realme", "Huawei", "Vinsmart"}, 255, 592);

        addLabel("Số Lượng:", 670, 414);
        tfStock = addTextField(756, 412);
        tfStock.setText("0");

        addLabel("Giá:", 710, 477);
        tfPrice = addTextField(756, 475);
        tfPrice.setText("0");

        addLabel("Trạng Thái:", 670, 538);
        cbStatus = addComboBox(new String[]{"Còn Hàng", "Hết Hàng"}, 756, 536);

// Sự kiện click vào bảng
table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tfProductID.setText(table.getValueAt(selectedRow, 0).toString());
            tfProductName.setText(table.getValueAt(selectedRow, 1).toString());
            cbType.setSelectedItem(table.getValueAt(selectedRow, 2).toString());
            cbBrand.setSelectedItem(table.getValueAt(selectedRow, 3).toString());
            tfStock.setText(table.getValueAt(selectedRow, 4).toString());
            tfPrice.setText(table.getValueAt(selectedRow, 5).toString());
            cbStatus.setSelectedItem(table.getValueAt(selectedRow, 6).toString());        
        }
    }
});

        // Buttons
        String[] buttonLabels = { "Thêm", "Cập Nhật", "Reset", "Xóa"};
        int[] xPositions = { 247, 405, 559, 713};
        int[] yPositions = { 685, 685, 685, 685};
        for (int i = 0; i < buttonLabels.length; i++) {
            Roundbtn btn = new Roundbtn(buttonLabels[i]);
            btn.setBounds(xPositions[i], yPositions[i], 122, 50);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(57, 219, 114));
            btn.setFont(new Font("SansSerif", Font.BOLD, 14));
            add(btn);
            
btn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (btn.getText().equals("Thêm")) {
            addProduct();
        }
        else if (btn.getText().equals("Cập Nhật")) {
            updateProduct();
        }        
        else if (btn.getText().equals("Xóa")) {
            deleteSelectedProduct();
        }
        
        else if (btn.getText().equals("Reset")) {
            tfProductID.setText("");
            tfProductName.setText("");
            tfStock.setText("0");
            tfPrice.setText("0");
            cbType.setSelectedIndex(0);
            cbBrand.setSelectedIndex(0);
            cbStatus.setSelectedIndex(0);

        }
        
    }
});

        }
        setPreferredSize(new Dimension(1080, 800));
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(label);
    }

    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 200, 26);
        tf.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(tf);
        return tf;
    }

    private JComboBox<String> addComboBox(String[] items, int x, int y) {
        JComboBox<String> cb = new JComboBox<>(items);
        cb.setBounds(x, y, 211, 26);
        cb.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(cb);
        return cb;
    }
    private void updateProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để cập nhật.");
            return;
        }
    
        try {
            int id = Integer.parseInt(tfProductID.getText().trim());
            String name = tfProductName.getText().trim();
            String type = (String) cbType.getSelectedItem();
            String brand = (String) cbBrand.getSelectedItem();
            int stock = Integer.parseInt(tfStock.getText().trim());
            BigDecimal price = new BigDecimal(tfPrice.getText().trim());
            if (stock == 0) {
                cbStatus.setSelectedItem("Hết Hàng");
            } else {
                cbStatus.setSelectedItem("Còn Hàng");
            }
            String status = (String) cbStatus.getSelectedItem();
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
    
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống.");
                return;
            }
    
            ProductsDTO product = new ProductsDTO();
            product.setProductID(id);
            product.setProductName(name);
            product.setType(type);
            product.setBrand(brand);
            product.setStock(stock);
            product.setPrices(price);
            product.setStatus(status);
            product.setDate(date);
    
            String result = productsBLL.updateProduct(product);
            JOptionPane.showMessageDialog(this, result);
    
            if (result.equals("Cập nhật sản phẩm thành công!")) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setValueAt(product.getProductID(), selectedRow, 0);
                model.setValueAt(product.getProductName(), selectedRow, 1);
                model.setValueAt(product.getType(), selectedRow, 2);
                model.setValueAt(product.getBrand(), selectedRow, 3);
                model.setValueAt(product.getStock(), selectedRow, 4);
                model.setValueAt(product.getPrices(), selectedRow, 5);
                model.setValueAt(product.getStatus(), selectedRow, 6);
                model.setValueAt(product.getDate(), selectedRow, 7);
            }
    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật sản phẩm: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void deleteSelectedProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int productId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                    String result = productsBLL.deleteProduct(productId);
                    JOptionPane.showMessageDialog(this, result);
    
                    if (result.equals("Xóa sản phẩm thành công!")) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(selectedRow); 
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa.");
        }
    }
    
    private void addProduct() {
        try {
            String name = tfProductName.getText().trim();
            String type = (String) cbType.getSelectedItem();
            String brand = (String) cbBrand.getSelectedItem();
            int stock = Integer.parseInt(tfStock.getText().trim());
            BigDecimal price = new BigDecimal(tfPrice.getText().trim());
            String status = (String) cbStatus.getSelectedItem();
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

            if(name.isEmpty() ){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                        return;
            }
            if (stock == 0) {
                status = "Hết Hàng";
                cbStatus.setSelectedItem("Hết Hàng");
            }else if(stock >0) {
                status = "Còn Hàng";
                cbStatus.setSelectedItem("Còn Hàng");
            } else if(stock <0){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ!");
                return;
            }
            
    
            ProductsDTO product = new ProductsDTO();
            product.setProductName(name);
            product.setType(type);
            product.setBrand(brand);
            product.setStock(stock);
            product.setPrices(price);
            product.setStatus(status);
            product.setDate(date);
    
            ProductsBLL bll = new ProductsBLL();
String result = bll.addProduct(product);
JOptionPane.showMessageDialog(this, result);

if (result.equals("Thêm sản phẩm thành công!")) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[]{
        product.getProductID(),
        product.getProductName(),
        product.getType(),
        product.getBrand(),
        product.getStock(),
        product.getPrices(),
        product.getStatus(),
        product.getDate().toString(),
    });
}}catch(Exception ex) {
    JOptionPane.showMessageDialog(this, "Lỗi khi thêm sản phẩm");
    ex.printStackTrace(); 
        }
    }
    
}
