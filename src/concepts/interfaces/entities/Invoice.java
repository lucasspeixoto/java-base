package concepts.interfaces.entities;

public class Invoice {


    public Double basicPayment;

    public Double tax;

    public Invoice() {
    }

    public Invoice(Double basicaPayment, Double tax) {
        this.basicPayment = basicaPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicaPayment) {
        this.basicPayment = basicaPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment() {
        return this.getBasicPayment() + this.getTax();
    }
}
