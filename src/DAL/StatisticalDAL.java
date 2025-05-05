package DAL;

import DTO.StatisticalDTO;
import java.sql.*;
import java.util.Vector;

public class StatisticalDAL {
    public Vector<StatisticalDTO> getMonthlyRevenue() {
        Vector<StatisticalDTO> arr = new Vector<StatisticalDTO>();
        Connection con = DBConnection.openConnect();
       try {
        String sql = "SELECT " +
                "MONTH(SaleDate) AS month, " +
                "COUNT(DISTINCT si.InvoiceID) AS totalOrders, " +
                "SUM(sid.Quantity) AS totalProductsSold, " +
                "SUM(sid.TotalPrices) AS totalRevenue " +
                "FROM salesinvoices si " +
                "JOIN salesinvoicedetails sid ON si.InvoiceID = sid.InvoiceID " +
                "GROUP BY MONTH(SaleDate) " +
                "ORDER BY MONTH(SaleDate)";

        
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                StatisticalDTO dto = new StatisticalDTO();
                dto.setMonth(rs.getInt("month"));
                dto.setTotalOrders(rs.getInt("totalOrders"));
                dto.setTotalProductsSold(rs.getInt("totalProductsSold"));
                dto.setTotalRevenue(rs.getDouble("totalRevenue"));
                arr.add(dto);
            }

        } catch(SQLException ex){
            System.out.println("Lỗi cơ sở dữ liệu "+ex.getMessage());
        }finally{
            DBConnection.closeConnect(con);
        }
        return arr;
    }
    public Vector<StatisticalDTO> getTopCus(){
        Vector<StatisticalDTO> arr = new Vector<StatisticalDTO>();
        Connection con = DBConnection.openConnect();
        try {
            String sql = """
                SELECT c.FullName, COUNT(si.InvoiceID) AS OrderCount, SUM(si.TotalAmount) AS TotalSpent
                FROM salesinvoices si
                JOIN customers c ON si.CustomerID = c.CustomerID
                GROUP BY c.FullName
                ORDER BY TotalSpent DESC
                LIMIT 5;
            """;
            Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    StatisticalDTO dto = new StatisticalDTO();
                    dto.setFullName(rs.getString("fullName"));
                    dto.setOrderCount(rs.getInt("orderCount"));
                    dto.setTotalSpent(rs.getDouble("totalSpent"));
                    arr.add(dto);
                }
    }catch(SQLException ex){
        System.out.println("Lỗi cơ sở dữ liệu "+ex.getMessage());
    }finally{
        DBConnection.closeConnect(con);
    }
    return arr;
}
public Vector<StatisticalDTO> getToppro(){
    Vector<StatisticalDTO> arr = new Vector<StatisticalDTO>();
    Connection con = DBConnection.openConnect();
    try{
        String sql = """
            SELECT p.ProductName AS productName,
                   SUM(sid.Quantity) AS quantitySold,
                   SUM(sid.TotalPrices) AS revenue
            FROM salesinvoicedetails sid
            JOIN products p ON sid.ProductID = p.ProductID
            GROUP BY p.ProductName
            ORDER BY quantitySold DESC
            LIMIT 5;
        """;
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            StatisticalDTO dto = new StatisticalDTO();
            dto.setProductName(rs.getString("productName"));
            dto.setQuantitySold(rs.getInt("quantitySold"));
            dto.setRevenue(rs.getDouble("revenue"));
            arr.add(dto);
        }

    }catch(SQLException ex){
        System.out.println("Lỗi cơ sở dữ liệu "+ex.getMessage());
    }finally{
        DBConnection.closeConnect(con);
    }
    return arr;
}
    public Vector<StatisticalDTO> getBrandre(){
        Vector<StatisticalDTO> arr = new Vector<StatisticalDTO>();
        Connection con = DBConnection.openConnect();
        try{ String sql = """
            SELECT p.Brand AS brand, SUM(sid.TotalPrices) AS revenue
            FROM products p
            JOIN salesinvoicedetails sid ON p.ProductID = sid.ProductID
            JOIN salesinvoices s ON sid.InvoiceID = s.InvoiceID
            GROUP BY p.Brand
                """;
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    StatisticalDTO dto = new StatisticalDTO();
                    dto.setBrand(rs.getString("brand"));
                    dto.setRevenue(rs.getDouble("revenue"));
                    arr.add(dto);
                }

        }catch(SQLException ex){
            System.out.println("Lỗi cơ sở dữ liệu"+ex.getMessage());
        }finally{
            DBConnection.closeConnect(con);
        }
        return arr;
    }
    public Vector<StatisticalDTO> getTopem(){
        Vector<StatisticalDTO> arr = new Vector<StatisticalDTO>();
        Connection con =DBConnection.openConnect();
        try{
            String sql = """
              
                       SELECT e.EmployeeID, e.Username, 
                       COUNT(DISTINCT si.InvoiceID) AS OrderCount, 
                       SUM(sid.TotalPrices) AS TotalSpent
                       FROM employees e
                       JOIN salesinvoices si ON e.EmployeeID = si.EmployeeID
                       JOIN salesinvoicedetails sid ON si.InvoiceID = sid.InvoiceID
                       GROUP BY e.EmployeeID, e.Username
                       ORDER BY TotalSpent DESC
                       LIMIT 5
                    """;
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql);
                    while(rs.next()){
                        StatisticalDTO dto = new StatisticalDTO();
                        dto.setUserName(rs.getString("userName"));
                        dto.setOrderCount(rs.getInt("orderCount"));
                        dto.setTotalSpent(rs.getDouble("totalSpent"));
                        arr.add(dto);

                    }
        }catch(SQLException ex){
            System.out.println("lỗi"+ ex.getMessage());
        }finally{
            DBConnection.closeConnect(con);
        }
        return arr;
    }
  
}
