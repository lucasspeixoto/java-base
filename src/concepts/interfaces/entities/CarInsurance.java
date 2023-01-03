package concepts.interfaces.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarInsurance {

    private final LocalDate actualDate;
    private String carBrand;
    private Integer yearOfPurchase;
    private Integer carValue;
    private List<Insurance> insurances = new ArrayList<>();

    public CarInsurance(String carBrand, Integer yearOfPurchase, Integer carValue) {
        this.carBrand = carBrand;
        this.yearOfPurchase = yearOfPurchase;
        this.carValue = carValue;
        this.actualDate = LocalDate.now();
    }

    public LocalDate getActualDate() {
        return actualDate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Integer getYearOfPurchase() {
        return yearOfPurchase;
    }

    public void setYearOfPurchase(Integer yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    public Integer getCarValue() {
        return carValue;
    }

    public void setCarValue(Integer carValue) {
        this.carValue = carValue;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }
}
