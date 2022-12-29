package app;

import concepts.entities.Department;
import concepts.entities.HourContract;
import concepts.entities.Worker;
import concepts.entities.WorkerLevel;
import entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department`s name:");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name:");
        String workerName = sc.nextLine();
        System.out.print("Level:");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary:");
        double workerBaseSalary = sc.nextDouble();

        Worker worker = new Worker(
                workerName,
                WorkerLevel.valueOf(workerLevel),
                workerBaseSalary,
                new Department(departmentName));

        System.out.print("How many contracts to this worker ?");
        int numberOfContracts = sc.nextInt();

        for (int i = 1; i <= numberOfContracts; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per Hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            worker.addContract(contract);
        }

        System.out.println();

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }

    private static void listAverage() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers ?");
        int n = sc.nextInt();

        double[] numbersList;
        numbersList = new double[n];

        for (int i = 0; i < n; i++) {
            double value = sc.nextDouble();
            numbersList[i] = value;
        }

        double sum = 0.0;
        for (double value : numbersList) {
            sum += value;
        }

        double average = sum / numbersList.length;
        System.out.printf("Sum: %.2f%n", (sum));
        System.out.printf("Average: %.2f%n", (average));

        sc.close();
    }

    private static void negatives() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers ?");
        int n = sc.nextInt();

        double[] numbersList;
        numbersList = new double[n];

        for (int i = 0; i < numbersList.length; i++) {
            double value = sc.nextDouble();
            numbersList[i] = value;
        }

        System.out.println("Negatives:");

        for (double number : numbersList) {
            if (number < 0) {
                System.out.println(number);
                sc.nextLine();
            }
        }
    }

    private static void productAveragePrice() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Product[] products = new Product[n];

        for (int i = 0; i < products.length; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            double price = sc.nextDouble();
            products[i] = new Product(name, price);
        }

        double sum = 0.0;

        for (Product product : products) {
            sum += product.getPrice();
        }
        double average = sum / products.length;

        System.out.printf("Average Price: %.2f%n", (average));

        sc.close();
    }

    private static void heightAverage() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] averageList;
        averageList = new double[n];

        for (int i = 0; i < n; i++) {
            averageList[i] = sc.nextDouble();
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += averageList[i];
        }
        double average = sum / n;

        System.out.printf("Media = %.2fcm%n", (average));

        sc.close();
    }
}
