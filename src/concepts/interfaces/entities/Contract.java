package concepts.interfaces.entities;

import java.util.Date;

public class Contract {

    private Integer number;
    private Date date;
    private Double TotalValue;

    public Contract(Integer number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        TotalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return TotalValue;
    }

    public void setTotalValue(Double totalValue) {
        TotalValue = totalValue;
    }
}
