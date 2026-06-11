import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoPassByValue {
  public static void main(String[] args) {
    // Pass by value (Java)
    // Pass by reference

    int[] arr2 = DemoPassByValue.sort(new int[] {3, 10, -3, 7});
    System.out.println(Arrays.toString(arr2));

    // ! Correct
    int[] arr3 = new int[] {100, -3, -200, -100};
    DemoPassByValue.sort(arr3);
    System.out.println(Arrays.toString(arr3));
    
    Integer x1 = 10;
    Integer x2 = 20;
    Integer result = DemoPassByValue.sum(x1, x2);
    System.out.println(result);
    System.out.println(x1);
    System.out.println(x2);

    List<String> names = new ArrayList<>();
    names.add("John");
    names.add("Tommy");
    names.add("Susan");
    DemoPassByValue.set(names, 1, "Jennie");
    System.out.println(names);

    BigDecimal k1 = BigDecimal.valueOf(30);
    BigDecimal k2 = BigDecimal.valueOf(40);
    BigDecimal answer = DemoPassByValue.add(k1, k2);
    System.out.println(answer);
    System.out.println(k1);

    Integer[] original = new Integer[] {3, 10, 4};
    DemoPassByValue.setToZero(original);
    System.out.println(Arrays.toString(original));

  }

  public static void setToZero(Integer[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = 0;
    }
  }
  

  // BigDecimal
  public static BigDecimal add(BigDecimal b1, BigDecimal b2){
    BigDecimal result = b1.add(b2); // return a new BigDecimal Object
    b1 = BigDecimal.valueOf(1000);
    return result;
  }

  public static Integer sum(Integer x, Integer y) {
    x = x + 100;
    return x + y;
  }

  public static String concat(String s1, String s2) {
    return s1.concat(s2); // return a new string
  }

  public static void set(List<String> names, int index, String newName) {
    names.set(index, newName);
  }

  // ! 8 Primitive + String + 8 Wrapper Class -> Pass By Value
  // ! Array + BigDecimal + LocalDate + Data Structure(ArrayList, LinkedList, ... etc), or any other classes 
  // classes

  // ! Wrong Design
  public static int[] sort(int[] arr) {
    Arrays.sort(arr);
    return arr;
  }

  // ! Correct Design
  public static void sort2(int[] arr) {
    Arrays.sort(arr);
  }
}



