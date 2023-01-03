package concepts.interfaces.services;

public interface OnlineInsuranceFee {

    Double paymentFee(Double amount);

    Double interest(Double amount, Integer months);
}
