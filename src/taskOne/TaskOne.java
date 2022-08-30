package taskOne;

/**
 * A program that finds the maximum, minimum and middle values from two-dimensional array.
 * The dimension of the array is entered from the keyboard
 */

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimension of the array - n");
        int n;
        n = scanner.nextInt();

        int[][] massiv = fillingArray(n);

        printArray(massiv);

        System.out.println("maximum value: " + maxNumber(massiv));
        System.out.println("minimum value: " + minNumber(massiv));
        System.out.println("the arithmetic mean of array elements: " + middleNumber(massiv));

        scanner.close();
    }

    /**
     * Method fills an array with random numbers
     *
     * @param n any number
     * @return array - two-dimensional array filled with random numbers
     */
    private static int[][] fillingArray(int n) {

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                array[i][j] = generator((int) (System.nanoTime()));
            }

        return array;
    }

    /**
     * Method generates a random number
     *
     * @return number - random number
     */
    private static int generator(int n) {
        //Xn-1=(a*Xn+c) mod m - Линейный конгруэнтный метод
        int maxNumber=100;
        final int a=1103515245; // множитель
        final int c=12345; //слагаемое
        final int m=65536; // 2 в степени 16
        int number=n;

        number= (number*a+c);
        return((number)/m)%(maxNumber+1);
    }

    /**
     * Method that finds the maximum value from an array
     *
     * @param array -any two-dimensional array
     * @return maxNumber - maximum value from an array
     */
    private static int maxNumber(int[][] array) {

        int maxNumber = array[0][0];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (array[i][j] > maxNumber) maxNumber = array[i][j];

        return maxNumber;
    }

    /**
     * Method that finds the minimum value from an array
     *
     * @param array - any two-dimensional array
     * @return minNumber - minimum value from an array
     */
    private static int minNumber(int[][] array) {
        int minNumber = array[0][0];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (array[i][j] < minNumber) minNumber = array[i][j];

        return minNumber;
    }

    /**
     * Method that finds the arithmetic mean of array elements
     *
     * @param array - any two-dimensional array
     * @return middleNumber - the arithmetic mean of array elements
     */
    private static double middleNumber(int[][] array) {
        double middleNumber;
        int sumArray = 0;

        if (array.length > 0) {

            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < array.length; j++)
                    sumArray += array[i][j];
        }
        middleNumber = (double) sumArray / (array.length * array.length);

        return middleNumber;
    }

    /**
     * Method that print array
     *
     * @param array -any two-dimensional array
     */
    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                System.out.print(array[i][j] + "\t");
            System.out.println();
        }
    }


}
