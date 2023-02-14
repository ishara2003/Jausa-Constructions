package lk.sankalpa.tm;

public class PaymentTM {

    private  String payment_Id;
    private  String payment_Owner_NIC;
    private  String payment_Price;
    private  String payment_Date;

    public PaymentTM() {
    }

    public PaymentTM(String payment_Id, String payment_Owner_NIC, String payment_Price, String payment_Date) {
        this.payment_Id = payment_Id;
        this.payment_Owner_NIC = payment_Owner_NIC;
        this.payment_Price = payment_Price;
        this.payment_Date = payment_Date;
    }

    public String getPayment_Id() {
        return payment_Id;
    }

    public void setPayment_Id(String payment_Id) {
        this.payment_Id = payment_Id;
    }

    public String getPayment_Owner_NIC() {
        return payment_Owner_NIC;
    }

    public void setPayment_Owner_NIC(String payment_Owner_NIC) {
        this.payment_Owner_NIC = payment_Owner_NIC;
    }

    public String getPayment_Price() {
        return payment_Price;
    }

    public void setPayment_Price(String payment_Price) {
        this.payment_Price = payment_Price;
    }

    public String getPayment_Date() {
        return payment_Date;
    }

    public void setPayment_Date(String payment_Date) {
        this.payment_Date = payment_Date;
    }



}
