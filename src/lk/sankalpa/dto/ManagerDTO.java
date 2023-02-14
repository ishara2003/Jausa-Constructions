package lk.sankalpa.dto;

public class ManagerDTO {
    private String name;
    private String nic;
    private String user_name;
    private String password;

    public ManagerDTO(String nic, String confermpw) {
        this.nic=nic;
        this.password=confermpw;
    }

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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ManagerDTO() {
    }

    public ManagerDTO(String name, String nic, String user_name, String password) {
        this.name = name;
        this.nic = nic;
        this.user_name = user_name;
        this.password = password;
    }
}
