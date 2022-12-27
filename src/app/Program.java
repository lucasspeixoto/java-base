package app;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        listAverage();
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
        for (double value: numbersList) {
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
