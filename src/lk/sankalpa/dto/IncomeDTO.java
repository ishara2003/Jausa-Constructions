package lk.sankalpa.dto;

public class IncomeDTO {

    private String incomeId;
    private String paymentId;
    private String date;

    public IncomeDTO() {
    }

    public IncomeDTO(String incomeId, String paymentId, String date) {
        this.incomeId = incomeId;
        this.paymentId = paymentId;
        this.date = date;
    }

    public String getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(String incomeId) {
        this.incomeId = incomeId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
