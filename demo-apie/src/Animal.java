import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Animal { // ! implicitly extends Object


  public static void main(String[] args) {
    Animal[] animals = new Animal[2];
    animals[0] = new Bird();
    animals[1] = new Snake("John");

    Object o1 = new Bird();
    Object o2 = new Bird();

    // Java's Object Class, by default = memory object
    System.out.println(o1.equals(o2)); // false

    // ! Override
    // Child Class has the right to override parent method

    Snake s1 = new Snake("Jenny");
    Snake s2 = new Snake("Steven");
    Snake s3 = new Snake("Jenny");
    System.out.println(s1.equals(s2)); // false
    System.out.println(s1.equals(s3)); // true

    System.out.println(s1.hashCode()); // 71458717
    System.out.println(s2.hashCode()); // -1808493766
    System.out.println(s3.hashCode()); // 71458717


    User u1 = new User("vincentlau123");
    User u2 = new User("vincentlau123");
    System.out.println(u1.equals(u2)); // true

    System.out.println(u1.hashCode());
    System.out.println(u2.hashCode());

    Staff s10 = new Staff("S1000", "John", LocalDate.of(2020, 1, 1));
    Staff s11 = new Staff("S1000", "John", LocalDate.of(2020, 1, 1));
    System.out.println(s10.equals(s11)); // true
    System.out.println(s10.hashCode());
    System.out.println(s11.hashCode());
    
    String s12 = new String("hello");
    String s13 = new String("hello");
    System.out.println(s12.equals(s13)); // true
    // The author of String Class Override equals

    Integer i10 = new Integer(100);
    Integer i11 = new Integer(100);
    System.out.println(i10.equals(i11)); // true

    BigDecimal bd1 = BigDecimal.valueOf(3.5);
    BigDecimal bd2 = new BigDecimal("3.5");
    System.out.println(bd1.equals(bd2)); // true
 
  }
}
