package concepts.poo;

/*
  Quando falamos que o balance tem o modificador
  protected, estamos dizendo que ela não é publico,
  podendo ser acessado por qualquer instância, e nem
  privado, limitado o acesso àpenas a classe Account.
  Ele pode ser acessado pelas classes que herdam Account
  como BusinessAccount
 */

import concepts.poo.entities.*;
import concepts.poo.enums.Color;
import concepts.poo.services.BrazilInterestService;
import concepts.poo.services.InterestService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Upcasting
 * -> Casting da subclasse para a superclasse
 * -> Uso comum: Polimorfismo
 * <p>
 * Downcasting
 * -> Casting da superclasse para a subclasse
 * -> Palavra instanceof
 * -> Uso comum: Métodos que recebem parâmetros genéricos (ex: Equals)
 * <p>
 * Palavra Chave: final
 * Em classes evita que a classe seja herdada
 * Em métodos evita que o método seja sobreposto
 * O uso do final gera uma maior performance na execução
 * dos métodos e classes, a análise é mais rápida
 */

/**
 * Palavra Chave: final
 *  Em classes evita que a classe seja herdada
 *  Em métodos evita que o método seja sobreposto
 *  O uso do final gera uma maior performance na execução
 *  dos métodos e classes, a análise é mais rápida
 */

/**
 * Classes abstratas
 * São classes que não podem ser instanciadas
 * É uma forma de garantir herança total: somente subclasses
 * não abstratas podem ser instanciadas, mas nunca a
 * superclasse abstrata
 */

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new BrazilInterestService(2.0);
        double payment = is.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.printf("%.2f%n", payment);

        sc.close();

    }

    private static void compareToExercise() {
        List<Employee> employees = new ArrayList<>();
        String path = "C:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeeCsv = br.readLine();
            while (employeeCsv != null) {
                String[] fields = employeeCsv.split(",");
                String name = fields[0];
                Double salary = Double.parseDouble(fields[1]);
                employees.add(new Employee(name, salary));
                employeeCsv = br.readLine();
            }
            Collections.sort(employees);
            for (Employee employee : employees) {
                System.out.println(employee.getName() + ", " + employee.getSalary());
            }
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    private static void interfacesWithAbstractClass() {
        AbstractShape s1 = new Circle(Color.BLACK, 2.0);
        AbstractShape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);

        System.out.println("Circle Color: " + s1.getColor());
        System.out.println("Circle area: " + String.format("%.3f", s1.area()));
        System.out.println("Rectangle Color: " + s2.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
    }

    private static void castings() {
        Account account = new Account(1001, "Lucas Peixoto", 0.0);
        BusinessAccount businessAccount = new BusinessAccount(
                1002,
                "Liana Fernandes",
                0.0,
                500.0);

        //! UpCasting
        Account account1 = businessAccount;
        Account account2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account account3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        //! DownCasting
        /**
         * BusinessAccount account4 = account2;
         * Um objeto da subclasse BusinessAccount não pode
         * ser atribuido de um objeto da superclasse Account,
         * é necessário um casting
         */
        BusinessAccount account4 = (BusinessAccount) account2; //
        account4.loan(100.0);

        //! Esta conversão abaixo não pode ser realizada pois account3 foi instanciada como SavingsAccount ao invés de BusinessAccount.Este erro só ocorre em tempo de execução.
        //BusinessAccount account5 = (BusinessAccount)account3;
        if (account3 instanceof BusinessAccount) {
            BusinessAccount account5 = (BusinessAccount) account3;
            account5.loan(100.0);
        }
    }
}
