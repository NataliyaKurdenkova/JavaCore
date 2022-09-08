package homeworkTwo;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;
import junit.framework.Assert;

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

//        Person[] RAW_DATA2 = null;

        Map<String, List<Person>> arrayPerson = Arrays.stream(Optional.ofNullable(RAW_DATA)
                        .orElseThrow(() -> new NullPointerException("Массив пустой")))
                .distinct()
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.groupingBy(Person::getName));


//        for(Map.Entry<String, List<Person>> item : arrayPerson.entrySet()){
//
//            System.out.println(item.getKey()+":");
//            int i=1;
//            for(Person person : item.getValue()){
//
//                System.out.println(i+" - "+person.getName()+"("+person.getId()+")");
//                i++;
//            }
//            System.out.println();
//        }

        for (Map.Entry<String, List<Person>> item : arrayPerson.entrySet()) {
            System.out.println("Key: " + item.getKey());
            System.out.println("Value: " + item.getValue().size());
            System.out.println();
        }

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

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));// true

        TestTask3 testTask3 = new TestTask3();
        testTask3.testEquals();

    }


    public static int[] twoSum(int[] array, int target) {
        int[] massiv = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    massiv[0] = array[i];
                    massiv[1] = array[j];
                    return massiv;
                }
            }
        }
        return massiv;
    }


    private static boolean fuzzySearch(String subStr, String str) {
        Boolean contain = true;

        int indexSub = 0;
        int indexStr = 0;
        while (indexSub < subStr.length()) {

            String charSub = String.valueOf(subStr.charAt(indexSub));
            String charStr = String.valueOf(str.charAt(indexStr));

            if (charSub.equals(charStr)) {
                contain &= (charSub.equals(charStr));
                indexSub++;
            }
            indexStr++;
            if ((indexStr >= str.length()) && (indexSub < subStr.length())) {
                contain = false;
                break;
            }
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


