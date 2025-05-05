package BLL;

import DAL.StatisticalDAL;
import DTO.StatisticalDTO;
import java.util.Vector;

public class StatisticalBLL {
    private StatisticalDAL dal;

    public StatisticalBLL() {
        dal = new StatisticalDAL();
    }

    public Vector<StatisticalDTO> getMonthlyStatistics() {
        return dal.getMonthlyRevenue();
    }
    public Vector<StatisticalDTO> getTopCus() {
        return dal.getTopCus();
    }
    public Vector<StatisticalDTO> getToppro(){
        return dal.getToppro();
    }
    public Vector<StatisticalDTO> getBrandre(){
        return dal.getBrandre();
    }
    
}
