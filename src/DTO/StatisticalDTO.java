package DTO;

public class StatisticalDTO {
    private int month;
    private int totalOrders;
    private int totalProductsSold;
    private double totalRevenue;
    private String fullName;
    private int orderCount;
    private double totalSpent;
    private String productName;
    private int quantitySold;
    private double revenue;
    private String brand;


    // Getters
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getTotalOrders() {
        return totalOrders;
    }
    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getTotalProductsSold() {
        return totalProductsSold;
    }
    public void setTotalProductsSold(int totalProductsSold) {
        this.totalProductsSold = totalProductsSold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public int getOrderCount(){
        return orderCount;
    }
    public void setOrderCount(int orderCount){
        this.orderCount = orderCount;
    }
    public Double getTotalSpent(){
        return totalSpent;
    }
    public void setTotalSpent(double totalSpent){
        this.totalSpent = totalSpent;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }
    public int getQuantitySold(){
        return quantitySold;
    }
    public void setQuantitySold(int quantitySold){
        this.quantitySold=quantitySold;
    }
    public double getRevenue(){
        return revenue;
    }
    public void setRevenue(double revenue){
        this.revenue = revenue;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

}
