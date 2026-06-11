import java.time.chrono.JapaneseChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoList {
  public static void main(String[] args) {
    // ArrayList LinkedList

    // 1. new ArrayList
    // 2. new LinkedList


    // ! What happen for read / write after initial creation

    // 3. Arrays.asList
    List<String> names = Arrays.asList("John", "Jenny", "Tommy");
    // names.add("Kenny");
    // java.lang.UnsupportedOperationException
    names.set(1, "Kenny");

    // 4. List.of
    List<String> fruits = List.of("Banana", "Apple");
    // fruits.add("Kiwi");  // java.lang.UnsupportedOperationException 
    System.out.println(fruits.get(0));
    // fruits.set(1, "watermelon"); // java.lang.UnsupportedOperationException

    // 5. new ArrayList<>(List.of())
    List<Integer> ages = new ArrayList<>(List.of(10, 3, 20));
    ages.add(40); // OK
    System.out.println(ages.get(0)); // OK
    ages.set(1, 25); 


  }
}
