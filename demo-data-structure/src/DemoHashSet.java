import java.util.ArrayList;
import java.util.HashSet;

public class DemoHashSet {
  // ! HashSet
  // ! 1. Avoid Duplicate
  // ! 1. Without Ordering
  public static void main(String[] args) {
    HashSet<String> set1 = new HashSet<>();
    set1.add("John");
    set1.add("Jenny");
    System.out.println(set1.add("John"));
    set1.add("Peter");

    System.out.println(set1); // [John, Peter, Jenny]

    HashSet<Human> humans = new HashSet<>();
    humans.add(new Human("John"));
    humans.add(new Human("Jenny"));
    humans.add(new Human("John"));
    humans.add(new Human("Peter"));
    System.out.println(humans.size());

    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("apple");
    fruits.add("orange");
    fruits.add("apple");

    HashSet<String> uniqueFruits = new HashSet<>();
    ArrayList<String> finalFruits = new ArrayList<>();
    for (String fruit : fruits) { // for-each -> cannot add/update/delete on this list at the same time
      if (uniqueFruits.add(fruit)) {
        finalFruits.add(fruit);
      }
    }

    System.out.println(finalFruits); // [apple, orange]

    // Approach 2 
    uniqueFruits = new HashSet<>(fruits); // ArrayList -> HashSet
    finalFruits = new ArrayList<>(uniqueFruits); // HashSet -> ArrayList
    System.out.println(finalFruits);

    fruits.remove("apple");
    System.out.println(fruits);
    fruits.remove(0);
    System.out.println(fruits);
    
  }
}
