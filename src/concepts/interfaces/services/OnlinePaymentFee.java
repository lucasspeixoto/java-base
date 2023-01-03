package concepts.interfaces.services;

public interface OnlinePaymentFee {

    Double paymentFee(Double amount);

    Double interest(Double amount, Integer months);
}
