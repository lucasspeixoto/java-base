package concepts;

import java.util.Arrays;
import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensão da matriz:");
        int n = sc.nextInt();

        int[][] matrice = new int[n][n];

        //! Popular a Matriz
        System.out.println("Valores:");
        for (int row = 0; row < matrice.length; row++) {
            for (int column = 0; column < matrice[row].length; column++) {
                int value = sc.nextInt();
                matrice[row][column] = value;
            }
        }

        //! Encontrar a quantidade de negativos
        int totalNegativeNumbers = 0;
        for (int[] ints : matrice) {
            for (int value : ints) {
                if (value < 0) {
                    totalNegativeNumbers += 1;
                }
            }
        }

        //! Encontrar a diagonal principal
        int[] matriceMainDiagonal = new int[n];
        for (int index = 0; index < n; index++) {
            int value = matrice[index][index];
            matriceMainDiagonal[index] = value;
        }

        System.out.println(Arrays.deepToString(matrice));
        System.out.println(Arrays.toString(matriceMainDiagonal));
        System.out.println(totalNegativeNumbers);

        sc.close();

    }
}
