package lk.sankalpa.dto;

public class OrderDTO {

    private String Item_Id;
    private String Description;
    private int QTY_Used;
    private Double unitPrice;
    private Double Total;
    private String order_Set_Date;
    private String O_Id;
    private Double Cost;
    private String P_Owner_NIC;
    private String P_Id;

    public OrderDTO(String o_id, String order_set_date, int qty_used, Double cost, String p_owner_nic, String p_id, String item_id, String description) {
        this.O_Id=o_id;
        this.order_Set_Date=order_set_date;
        this.QTY_Used=qty_used;
        this.Cost=cost;
        this.P_Owner_NIC=p_owner_nic;
        this.P_Id=p_id;
        this.Item_Id=item_id;
        this.Description=description;
    }

    public String getO_Id() {
        return O_Id;
    }

    public void setO_Id(String o_Id) {
        O_Id = o_Id;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    public String getP_Owner_NIC() {
        return P_Owner_NIC;
    }

    public void setP_Owner_NIC(String p_Owner_NIC) {
        P_Owner_NIC = p_Owner_NIC;
    }

    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String p_Id) {
        P_Id = p_Id;
    }

    public OrderDTO(String item_Id, String description, int QTY_Used, Double unitPrice, Double total, String order_Set_Date, String o_Id, Double cost, String p_Owner_NIC, String p_Id) {
        this.Item_Id = item_Id;
        this.Description = description;
        this.QTY_Used = QTY_Used;
        this.unitPrice = unitPrice;
        this.Total = total;
        this.order_Set_Date = order_Set_Date;
        this.O_Id = o_Id;
        this.Cost = cost;
        this.P_Owner_NIC = p_Owner_NIC;
        this.P_Id = p_Id;
    }


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

    public OrderDTO() {
    }

    public OrderDTO(String item_Id, String description, int QTY_Used, Double unitPrice, Double total, String order_Set_Date) {
        this.Item_Id = item_Id;
        this.Description = description;
        this.QTY_Used = QTY_Used;
        this.unitPrice = unitPrice;
        this.Total = total;
        this.order_Set_Date = order_Set_Date;
    }
}
