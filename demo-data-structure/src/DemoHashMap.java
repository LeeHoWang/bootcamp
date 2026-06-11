import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoHashMap {
  public static void main(String[] args) {
    // Key -> find value

    HashMap<String, Double> itemMap = new HashMap<>();
    itemMap.put("apple", 5.5);
    itemMap.put("orange", 8.0);
    itemMap.put("lemon", 6.5);

    // Behind the sense, key -> value
    System.out.println(itemMap.get("orange")); // 8.0
    // ! Hash find thing is fast

    // Subject (Key) (CHINESE, ENGLISH, MATH)
    // List<String> (Value) -> Many Student Name
    HashMap<String, ArrayList<String>> subjectMap = new HashMap<>();

    // Chinese students
    ArrayList<String> chinese = new ArrayList<>();
    chinese.add("Peter");
    chinese.add("Mandy");
    subjectMap.put("Chinese", chinese);

    // English students 
    ArrayList<String> english = new ArrayList<>();
    english.add("Florence");
    subjectMap.put("English", english);

    // Math students 
    ArrayList<String> math = new ArrayList<>();
    math.add("John");
    subjectMap.put("Math", math);

    System.out.println(subjectMap.get("English")); // [Florence]
    System.out.println(subjectMap.containsKey("Chinese")); // true
    System.out.println(subjectMap.size()); // 3
    System.out.println(subjectMap.isEmpty()); // false

    // for-each Map
    // entrySet() -> return entries
    for (Map.Entry<String, ArrayList<String>> entry : subjectMap.entrySet()) {
      System.out.println(entry.getKey() + "," + entry.getValue());
    }
    // [Peter, John, Mary, Oscar, Connie]
    ArrayList<String> allnames = new ArrayList<>(); 
    for (Map.Entry<String, ArrayList<String>> entry : subjectMap.entrySet()) {
      for (String name : entry.getValue()) { // ! understand it is string
        allnames.add(name);
      }
      }
      System.out.println(allnames);

      // addAll
      allnames.clear(); // ! remove all elements
      System.out.println(allnames);

      for (Map.Entry<String, ArrayList<String>> entry : subjectMap.entrySet()) {
        allnames.addAll(entry.getValue());
      }
      System.out.println(allnames);

      // HashMap<String, HashMap<String, Double>>
      HashMap<String, HashMap<String, Double>> priceMap = new HashMap<>();

      HashMap<String, Double> fruitMap = new HashMap<>();
      fruitMap.put("apple", 6.5);
      fruitMap.put("banana", 8.5);
      priceMap.put("fruit", fruitMap);

      HashMap<String, Double> drinkMap = new HashMap<>();
      drinkMap.put("orangeJuice", 10.5);
      drinkMap.put("appleJuice", 6.6);
      priceMap.put("drink", drinkMap);

      HashMap<Human, Cat> map1 = new HashMap<>();
      map1.put(new Human("Peter"), new Cat("Susan"));
      map1.put(new Human("John"), new Cat("Leo"));
      map1.put(new Human("Jenny"), new Cat("Oscar"));

      // print the cat name owned by John 
      Human john = new Human("John");
      System.out.println(map1.get(new Human("John")).getName());
      System.out.println(map1.get(john).getName());

      // ! HashMap.get() -> equals()
      // So, add equals() and hashCode() in Human class.

      // ! entryset()
      for (Map.Entry<Human, Cat> entry: map1.entrySet()) {
        System.out.println(
          entry.getKey().getName() + "owns" + entry.getValue().getName()
        );
      }

      // ! Keyset()
      for (Human human : map1.keySet()) {
        System.out.println(human.getName());
      }

      // ! values()
      for (Cat cat : map1.values()){
        System.out.println(cat.getName());
      }

      // remove Jenny
      map1.remove(new Human ("Jenny"));
      System.out.println(map1.size());
      
  } 
}
