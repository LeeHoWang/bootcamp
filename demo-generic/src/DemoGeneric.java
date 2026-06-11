import java.time.LocalDate;
import java.util.ArrayList;

public class DemoGeneric {
  public static void main(String[] args) {
    // Before Java 1.5
    ArrayList names = new ArrayList();
    names.add("Alex");
    names.add("John");
    names.add("Peter");

    for (Object name : names) {
      System.out.println(name); 
      // String.toString (runtime Polymorphism)
      // no charAt available, compile time Polymorphism
    }

    // After Java 1.5
    ArrayList<String> names2 = new ArrayList<>();
    names2.add("Alex");
    names2.add("John");
    names2.add("Peter");
    for (String name : names2) {
      System.out.println(name);
      System.out.println(name.charAt(0)); 
    }

    
    
  }
}
