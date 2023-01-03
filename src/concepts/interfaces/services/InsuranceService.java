package concepts.interfaces.services;

import concepts.interfaces.entities.CarInsurance;
import concepts.interfaces.entities.Insurance;

import java.time.LocalDate;

public class InsuranceService {

    private final OnlineInsuranceFee onlineInsuranceFee;

    public InsuranceService(OnlineInsuranceFee onlineInsuranceFee) {
        this.onlineInsuranceFee = onlineInsuranceFee;
    }

    public void processInsurance(CarInsurance carInsurance) {

        double totalValue;
        if (carInsurance.getYearOfPurchase() <= 2010) {
            totalValue = 0.05 * carInsurance.getCarValue() / 12.00; //Seguro anual em cima de 5% do valor do carro
        } else {
            totalValue = 0.03 * carInsurance.getCarValue() / 12.00; //Seguro anual em cima de 3% do valor do carro
        }

        System.out.println(totalValue);

        for (int month = 1; month <= 12; month++) {

            LocalDate dueDate = carInsurance.getActualDate().plusMonths(month);

            double interest = this.onlineInsuranceFee.interest(totalValue, month);
            double fee = this.onlineInsuranceFee.paymentFee(totalValue + interest);

            double total = totalValue + interest + fee;

            carInsurance.getInsurances().add(new Insurance(dueDate, total));

        }
    }
}
