package concepts.poo.services;

import java.security.InvalidParameterException;

/**
 * Com os defaults methods, podemos ter reuso de métodos (ex: payment)
 * sem a necessidade de combinação de interfaces com classes abstratas
 * <p>
 * Com os defaults methods temos uma forma de herança múltipla, porem
 * o compilador vai obrigar a sobreescrever o método
 * <p>
 * ‘Interfaces’ são bem diferentes de classes abstratas, não possuem recursos
 * tais como construtores e atributos
 */

public interface InterestService {

    double getInterestRate();

    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("Months must be greater than zero.");
        }
        return amount * Math.pow(1.0 + this.getInterestRate() / 100.00, months);
    }


}
