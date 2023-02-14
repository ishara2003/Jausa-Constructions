package lk.sankalpa.tm;

public class P_OwnerTM {
    private String name;
    private String nic;
    private String address;
    private String number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }




    public P_OwnerTM() {
    }



    public P_OwnerTM(String name, String nic, String address, String number) {
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.number = number;

    }

}
