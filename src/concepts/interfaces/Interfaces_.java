package concepts.interfaces;

import concepts.interfaces.entities.CarRental;
import concepts.interfaces.entities.Invoice;
import concepts.interfaces.entities.Vehicle;
import concepts.interfaces.services.BrazilTaxService;
import concepts.interfaces.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 * Interface é um tipo que define um conjunto
 * de operações que uma classe deve implementar
 * <p>
 * A interface estabelece um contrato que a classe
 * deve cumprir
 */

/**
 * Inversão de Controle: Padrão de desenvolvimento
 * que consiste em retirar da classe a responsabilidade
 * de instanciar sua dependências
 *
 * Injeção de dependência: É uma forma de realizar a inversão
 * de controle, onde um componente externo instancia a dependência,
 * que é então injetada no objeto "pai". Pode ser implementada de
 * várias formas:
 *   -> Construtor
 *   -> Classe de instanciação (builder/factory)
 *   -> Container / framework
 */

public class Interfaces_ {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel:");
        System.out.print("Modelo do carro:");
        String carModel = sc.nextLine();

        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Entrega (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por hora: ");
        Double pricePerHour = sc.nextDouble();

        System.out.print("Entre com o preço por dia: ");
        Double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(
                pricePerDay,
                pricePerHour,
                new BrazilTaxService()
        );

        rentalService.processInvoice(carRental);

        Invoice invoice = carRental.getInvoice();

        System.out.println("FATURA: ");
        System.out.println("Pagamento Básico: " + String.format("%.2f", invoice.getBasicPayment()));
        System.out.println("Imposto: " + invoice.getTax());
        System.out.println("Pagamento Total: " + String.format("%.2f", invoice.getTotalPayment()));

        sc.close();

    }
}
