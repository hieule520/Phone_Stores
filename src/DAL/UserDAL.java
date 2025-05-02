package DAL;

import DTO.User;
import java.sql.*;

public class UserDAL {
    private Connection con;

    public UserDAL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_store", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public boolean login(User employees) {
        String sql = "SELECT * FROM employees WHERE Username=? AND Password=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employees.getUsername());
            ps.setString(2, employees.getPassword());
=======
    public boolean login(User user) {
        String sql = "SELECT * FROM users WHERE Username=? AND Password=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
>>>>>>> parent of 81bb9a3 (uppp)
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usernameExists(String username) {
<<<<<<< HEAD
        String sql = "SELECT * FROM employees WHERE Username=?";
=======
        String sql = "SELECT * FROM users WHERE Username=?";
>>>>>>> parent of 81bb9a3 (uppp)
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

<<<<<<< HEAD
    public boolean register(User employees) {
        String sql = "INSERT INTO employees(Username, Password) VALUES(?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employees.getUsername());
            ps.setString(2, employees.getPassword());
=======
    public boolean register(User user) {
        String sql = "INSERT INTO users(Username, Password) VALUES(?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
>>>>>>> parent of 81bb9a3 (uppp)
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}