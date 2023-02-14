package lk.sankalpa.dto;

public class ProjectDTO {
    private String id;
    private String name;
    private Long cost;
    private String nic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public ProjectDTO() {
    }

    public ProjectDTO(String id, String name, Long cost, String nic) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.nic = nic;
    }


}
