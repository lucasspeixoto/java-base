package concepts.interfaces;

import concepts.interfaces.entities.*;
import concepts.interfaces.services.*;

import java.time.LocalDate;
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
 * <p>
 * Injeção de dependência: É uma forma de realizar a inversão
 * de controle, onde um componente externo instancia a dependência,
 * que é então injetada no objeto "pai". Pode ser implementada de
 * várias formas:
 * -> Construtor
 * -> Classe de instanciação (builder/factory)
 * -> Container / framework
 */

/**
 * Interface x Herança
 *  Herança: Reuso
 *  Interface: Contrato ser cumprido
 *
 */

public class Interfaces_ {

    public static void main(String[] args) {

        insuranceExercise();

    }

    private static void insuranceExercise() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados da compra do carro:");

        System.out.print("Marca: ");
        String carBrand = sc.nextLine();

        System.out.print("Ano da compra: ");
        Integer yearOfPurchase = sc.nextInt();

        System.out.print("Valor de Mercado: ");
        Integer carValue = sc.nextInt();

        CarInsurance carInsurance = new CarInsurance(carBrand, yearOfPurchase, carValue);

        InsuranceService insuranceService = new InsuranceService(new BmwService());

        insuranceService.processInsurance(carInsurance);

        System.out.println("Parcelas Seguro (Anual): ");

        for (Insurance insurance : carInsurance.getInsurances()) {
            System.out.println(insurance);
        }

        sc.close();
    }

    private static void paypalExercise() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");

        System.out.print("Número: ");
        Integer contractNumber = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dueDate = LocalDate.parse(sc.next(), fmt);

        System.out.print("Valor do contrato (R$): ");
        Double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, dueDate, contractValue);

        System.out.print("Quantidade de parcelas: ");
        int months = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, months);

        System.out.println("Parcelas:");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }

    private static void carRentalExercise() {
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
