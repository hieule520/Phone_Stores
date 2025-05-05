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
    public Vector<StatisticalDTO> getTopem(){
        return dal.getTopem();
    }
    public Vector<String[]> getRevenueGrowthRate() {
        Vector<StatisticalDTO> stats = getMonthlyStatistics();
        Vector<String[]> result = new Vector<>();
    
        for (int i = 1; i < stats.size(); i++) {
            double prev = stats.get(i - 1).getTotalRevenue();
            double curr = stats.get(i).getTotalRevenue();
    
            double rate = ((curr - prev) / prev) * 100;
            String formattedRate = (rate >= 0 ? "+" : "") + String.format("%.2f", rate) + "%";
            result.add(new String[]{"Tháng " + stats.get(i).getMonth(), formattedRate});
        }
    
        return result;
    }
    
    
}
