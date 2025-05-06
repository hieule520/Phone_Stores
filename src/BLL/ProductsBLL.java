package BLL;

import DAL.ProductsDAL;
import DTO.ProductsDTO;
import java.util.Vector;

public class ProductsBLL {
    private ProductsDAL dal;

    public ProductsBLL() {
        dal = new ProductsDAL();
    }
    public String deleteProduct(int productID) {
        boolean success = dal.deleteProduct(productID);
        return success ? "Xóa sản phẩm thành công!" : "Xóa sản phẩm thất bại!";
    }
    
    public String updateProduct(ProductsDTO p) {
        boolean success = dal.updateProduct(p);
        return success ? "Cập nhật sản phẩm thành công!" : "Cập nhật sản phẩm thất bại!";
    }
    

    public Vector<ProductsDTO> getAllProducts() {
        return dal.getAllProducts();
    }

    public String addProduct(ProductsDTO p) {
        if (dal.isProductNameExists(p.getProductName())) {
            return "Tên sản phẩm đã tồn tại!";
        }
        
        boolean success = dal.insertProduct(p);
        return success ? "Thêm sản phẩm thành công!" : "Thêm sản phẩm thất bại!";
    }
    public ProductsDTO getProductsByName(String name){
        return dal.getProductsByName(name);
    }

    public void updateStockAfterSale(int productID, int quantitySold) {
        ProductsDTO product = dal.getProductByID(productID);
        if (product != null) {
            int newStock = product.getStock() - quantitySold;
            if (newStock < 0) newStock = 0;
            dal.updateStock(productID, newStock);
        }
    }
    
}
