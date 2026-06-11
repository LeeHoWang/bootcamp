import java.util.ArrayList;
// import java.util.Arrays;

public class DemoArrayList {
  public static void main(String[] args) {
    // int[] arr = new int[] {2,4,6,8};
    // Array Disadvantages:
    // 1. Add New Element -> new int[5]
    // for loop

    // Solution by Data Structure: ArrayList
    // !
    ArrayList<Integer> integers = new ArrayList<Integer>();
    integers.add(2);
    integers.add(4);
    integers.add(6);
    integers.add(8);
    // ! ArrayList is with ordering
    System.out.println(integers); // [2, 4, 6, 8]
    System.out.println(integers.size()); // 4
    integers.add(10);
    System.out.println(integers.size()); // 5

    System.out.println(integers.contains(6)); // ! return boolean
    System.out.println(integers.contains(12));

    if (integers.isEmpty()) {

    } 
    // check if not empty // ! better code writing skills

    // Similar to Array arr[2]
    System.out.println(integers.get(2)); // 6

    integers.remove(new Integer(8));
    System.out.println(integers); // [2, 4, 6, 10]

    System.out.println(integers.remove(3));
    System.out.println(integers);

    // ArrayList of String
    // "John", "Mary", "Steven"
    // Size
    // remove Mary
    ArrayList<String> strings = new ArrayList<>();
    strings.add("John");
    strings.add(new String("Mary"));
    strings.add("Steven");
    strings.add(new String("Mary"));

    System.out.println(strings);
    System.out.println(strings.size());
    // remove Mary
    strings.remove(new String("Mary")); // ! remove method -> call String equals()
    System.out.println(strings); // [John, Steven]
    // ! remove first found element

    strings.set(1, "Leo");
    System.out.println(strings); // [John, Leo, Mary]

    strings.removeFirst();
    strings.removeLast();
    strings.addFirst("Peter");
    strings.addLast("Sally");
    System.out.println(strings); // [Peter, Leo, Sally]

    // for: int i = 0;...
    // for-each
    for (String string : strings){   // array OK, array list OK
      System.out.println(string);
    }


    // ArrayList<LocalDate> exercise
    // HashMap in HashMap

  }  
}
