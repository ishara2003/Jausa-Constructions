package lk.sankalpa.dto;

public class P_OwnerDTO {
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




    public P_OwnerDTO() {
    }



    public P_OwnerDTO(String name, String nic, String address, String number) {
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.number = number;

    }

}
