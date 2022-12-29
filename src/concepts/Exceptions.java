package concepts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {

        File file = new File(".\\in.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }

    private static void method1() {
        System.out.println("**** START METHOD 1 ****");
        method2();
        System.out.println("**** END METHOD 1 ****");
    }

    private static void method2() {
        System.out.println("**** START METHOD 2 ****");
        Scanner sc = new Scanner(System.in);
        try {
            String[] namesList = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(namesList[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("The position is a number!");
        }

        sc.close();

        System.out.println("**** END METHOD 2 ****");
    }
}
