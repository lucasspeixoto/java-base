package concepts.interfaces.services;

import concepts.interfaces.entities.CarRental;
import concepts.interfaces.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;

    private TaxService taxService;

    public RentalService(
            Double pricePerDay,
            Double pricePerHour,
            TaxService taxService
    ) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {

        double durationInMinutes = Duration.between(
                carRental.getStart(),
                carRental.getFinish()
        ).toMinutes();

        double durationInHours = durationInMinutes / 60.0;

        double basicPayment;
        if (durationInHours <= 12.0) {
            basicPayment = this.pricePerHour * Math.ceil(durationInHours);
        } else {
            basicPayment = this.pricePerDay * Math.ceil(durationInHours / 24.0);
        }

        double tax = this.taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
