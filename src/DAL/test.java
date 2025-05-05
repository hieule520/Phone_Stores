package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

import DTO.StatisticalDTO;

public class test {
    private Connection con;
    public test(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_store", "root", "");
        }catch(Exception ex)
{ex.printStackTrace();}
    
}
public Vector<StatisticalDTO> getTopem(){
    Vector<StatiscalDTO> arr = new Vector<StatisticalDTO>();
    Connection con = DBConnection.openConnect();

}
}
