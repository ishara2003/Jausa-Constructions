package lk.sankalpa.tm;

public class OrderTm {

    private String Item_Id;
    private String Description;
    private int QTY_Used;
    private Double unitPrice;
    private Double Total;
    private String order_Set_Date;



    public String getItem_Id() {
        return Item_Id;
    }

    public void setItem_Id(String item_Id) {
        Item_Id = item_Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getQTY_Used() {
        return QTY_Used;
    }

    public void setQTY_Used(int QTY_Used) {
        this.QTY_Used = QTY_Used;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public String getOrder_Set_Date() {
        return order_Set_Date;
    }

    public void setOrder_Set_Date(String order_Set_Date) {
        this.order_Set_Date = order_Set_Date;
    }

    public OrderTm() {
    }

    public OrderTm(String item_Id, String description, int QTY_Used, Double unitPrice, Double total, String order_Set_Date) {
        this.Item_Id = item_Id;
        this.Description = description;
        this.QTY_Used = QTY_Used;
        this.unitPrice = unitPrice;
        this.Total = total;
        this.order_Set_Date = order_Set_Date;
    }
}
