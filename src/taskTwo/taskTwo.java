package taskTwo;

import java.util.Arrays;

public class taskTwo {
    public static void main(String[] args) {

        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};

        System.out.println("source array: ");
        printArray(array);
        int[] newSortArray = sortArray(array);
        System.out.println("sort array: ");
        printArray(newSortArray);

        testSortArray(newSortArray);

    }

    /**
     * Method that sort array
     *
     * @param array - any array
     * @return sortArray
     */
    private static int[] sortArray(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * Method that print array
     *
     * @param array - any array
     */
    private static void printArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

    }

    /**
     * Method that compares an array
     *
     * @param array - any array
     */
    public static void testSortArray(int[] array) {

        int[] sampleSort={1,2,3,4,5,5,6,9};

        if (!Arrays.equals(sampleSort,array)) {
            // Выбрасываем исключение и завершаем выполнение теста, если массивы не равны
            throw new AssertionError("Метод работает неверно!");
        }else System.out.println("Тест пройден!");




    }
}


