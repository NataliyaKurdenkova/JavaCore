package homeworkTwo;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;
import junit.framework.Assert;
import org.w3c.dom.ls.LSOutput;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        ////////////////////////////////////////////
        ///////TASK 1/////////////
        /////////////

        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();


        printArray(RAW_DATA);

        ////////////////////////////////////////////
        ///////TASK 2/////////////
        /////////////


        System.out.println();
        System.out.println("**************************************************");
        System.out.println("Task 2");

        int[] array = {3, 4, 2, 7};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(array, target)));


        ////////////////////////////////////////////
        ///////TASK 3/////////////
        /////////////

        System.out.println();
        System.out.println("**************************************************");
        System.out.println("Task 3");


        try {
            System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));// true

        } catch (Exception e) {
            System.out.println(e.getMessage());


        TestTask3 testTask3 = new TestTask3();
        testTask3.testEquals();
        }
    }

    public static void printArray(Person[] array) {
        if (array != null) {
            Arrays.stream(array)
                    .filter(Objects::nonNull)
                    .filter(obj -> obj.getName() != null)
                    .distinct()
                    .sorted(Comparator.comparingInt(Person::getId))
                    .collect(Collectors.groupingBy(Person::getName))
                    .forEach((k, v) -> System.out.println("Key: " + k + "\n" + "Value: " + v.size()));
        } else
            System.out.println("В метод передан пустой массив");
    }

    public static int[] twoSum(int[] array, int target) {
        int[] massiv = new int[2];

        if (array != null) {
            int i = 0;
            int j = array.length - 1;
            Arrays.sort(array);
            while (i < j) {
                 if (array[i] + array[j] == target) {
                    massiv[0] = array[i];
                    massiv[1] = array[j];
                    return massiv;
                } else if (array[i] + array[j] < target) i += 1;
                else if (array[i] + array[j] > target) j -= 1;
            }
        } else System.out.println("В метод передан пустой массив");
        return massiv;
    }

    private static boolean fuzzySearch(String subStr, String str) {
        Boolean contain = true;

        if (subStr.length() != 0 || str.length() != 0 || subStr != null || str != null) {

            int indexSub = 0;
            int indexStr = 0;

            while (indexSub < subStr.length()) {
                Boolean eqSimbol = (subStr.charAt(indexSub) == str.charAt(indexStr));

                if (eqSimbol) {
                    contain &= eqSimbol;
                    indexSub++;
                }

                indexStr++;
                if ((indexStr >= str.length()) && (indexSub < subStr.length())) {
                    contain = false;
                    break;
                }
            }
        } else {
            System.out.println("В метод переданы нулевые объекты");
            return false;
        }

        return contain;
    }



    static class TestTask3 {
        @Test
        public void testEquals() {

            Assert.assertEquals(true, fuzzySearch("car", "ca6$$#_rtwheel"));
            Assert.assertEquals(true, fuzzySearch("cwhl", "cartwheel"));
            Assert.assertEquals(true, fuzzySearch("cartwheel", "cartwheel"));
            Assert.assertEquals(true, fuzzySearch("cwhee", "cartwheel"));
            Assert.assertEquals(false, fuzzySearch("cwheeel", "cartwheel"));
            Assert.assertEquals(false, fuzzySearch("lw", "cartwheel"));


        }
    }
}


