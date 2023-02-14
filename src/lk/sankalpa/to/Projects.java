package lk.sankalpa.to;

public class Projects {

    private String p_id;
    private String P_O_NIC;
    private String p_Name;
    private Long p_Cost;

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_O_NIC() {
        return P_O_NIC;
    }

    public void setP_O_NIC(String p_O_NIC) {
        P_O_NIC = p_O_NIC;
    }

    public String getP_Name() {
        return p_Name;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public Long getP_Cost() {
        return p_Cost;
    }

    public void setP_Cost(Long p_Cost) {
        this.p_Cost = p_Cost;
    }

    public Projects() {

    }

    public Projects(String p_Name,String p_id , Long p_Cost, String p_O_NIC) {
        this.p_Name = p_Name;
        this.p_id = p_id;
        this.p_Cost = p_Cost;
        this.P_O_NIC = p_O_NIC;
    }
}
