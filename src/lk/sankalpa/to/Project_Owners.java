package lk.sankalpa.to;

public class Project_Owners {

    private String NIC;
    private String Number;
    private String Address;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Project_Owners(String name, String NIC, String address, String number) {
        this.Name = name;
        this.NIC = NIC;
        this.Address = address;
        this.Number = number;
    }

    public Project_Owners() {
    }


}
