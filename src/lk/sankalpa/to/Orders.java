package lk.sankalpa.to;

public class Orders {

    private String O_Id;
    private String order_Set_Date;
    private int QTY_Used;
    private Double Cost;
    private String P_Owner_NIC;
    private String P_Id;
    private String Item_Id;


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;

    public String getO_Id() {
        return O_Id;
    }

    public void setO_Id(String o_Id) {
        O_Id = o_Id;
    }

    public String getOrder_Set_Date() {
        return order_Set_Date;
    }

    public void setOrder_Set_Date(String order_Set_Date) {
        this.order_Set_Date = order_Set_Date;
    }

    public int getQTY_Used() {
        return QTY_Used;
    }

    public void setQTY_Used(int QTY_Used) {
        this.QTY_Used = QTY_Used;
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

    public String getItem_Id() {
        return Item_Id;
    }

    public void setItem_Id(String item_Id) {
        Item_Id = item_Id;
    }

    public Orders() {
    }

    public Orders(String o_Id, String order_Set_Date, int QTY_Used, Double cost, String p_Owner_NIC, String p_Id, String item_Id, String Description ) {
        this.O_Id = o_Id;
        this.order_Set_Date = order_Set_Date;
        this.QTY_Used = QTY_Used;
        this.Cost = cost;
        this.P_Owner_NIC = p_Owner_NIC;
        this.P_Id = p_Id;
        this.Item_Id = item_Id;
        this.Description=Description;
    }
}
