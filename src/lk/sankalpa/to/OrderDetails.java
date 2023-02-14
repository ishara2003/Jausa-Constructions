package lk.sankalpa.to;

public class OrderDetails {

    private String item_Id;
    private String Order_Id;
    private String P_Id;
    private int qty;
    private double cost;
    private String date;

    public String getItem_Id() {
        return item_Id;
    }

    public void setItem_Id(String item_Id) {
        this.item_Id = item_Id;
    }

    public String getOrder_Id() {
        return Order_Id;
    }

    public void setOrder_Id(String order_Id) {
        Order_Id = order_Id;
    }

    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String p_Id) {
        P_Id = p_Id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderDetails() {
    }

    public OrderDetails(String item_Id, String order_Id, String p_Id, int qty, double cost, String date) {
        this.item_Id = item_Id;
        this.Order_Id = order_Id;
        this.P_Id = p_Id;
        this.qty = qty;
        this.cost = cost;
        this.date = date;
    }
}
