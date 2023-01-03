package concepts.interfaces.services;

import concepts.interfaces.entities.Contract;
import concepts.interfaces.entities.Installment;

import java.time.LocalDate;

public class ContractService {


    private final OnlinePaymentFee onlinePaymentFee;

    public ContractService(OnlinePaymentFee onlinePaymentFee) {
        this.onlinePaymentFee = onlinePaymentFee;
    }

    public void processContract(Contract contract, Integer months) {

        double baseInstallment = contract.getTotalValue() / months;

        for (int month = 1; month <= months; month ++) {

            // Get Installments Data
            LocalDate dueDate = contract.getDate().plusMonths(month);
            double interest = this.onlinePaymentFee.interest(baseInstallment, month);
            double fee = this.onlinePaymentFee.paymentFee(baseInstallment + interest);
            double quota = baseInstallment + interest + fee;

            // Create installment
            contract.getInstallments().add(new Installment(dueDate, quota));
        }


    }
}
