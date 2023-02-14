package lk.sankalpa.dto;

public class StockDTO {
    private String id;
    private String descrption;
    private String date;
    private String QTY;
    private Double unitPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public StockDTO() {
    }

    public StockDTO(String id, String descrption, String date, String QTY, Double unitPrice) {
        this.id = id;
        this.descrption = descrption;
        this.date = date;
        this.QTY = QTY;
        this.unitPrice = unitPrice;
    }


}
