package concepts.interfaces.services;

public class BmwService implements OnlineInsuranceFee {

    private static final double MONTHLY_INTEREST = 0.01;
    private static final double FEE_PERCENTAGE = 0.02;

    public Double interest(Double amount, Integer months) {
        return amount * MONTHLY_INTEREST * months;
    }

    public Double paymentFee(Double amount) {
        return amount * FEE_PERCENTAGE;
    }

}
