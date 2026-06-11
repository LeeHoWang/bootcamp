public class DemoInteger{
  public static void main(String[] args) {
    Integer i1 = 127;
    Integer i2 = 127;
    System.out.println(i1 == i2); // true

    Integer i3 = new Integer(127);
    System.out.println(i1 == i3); // false
    System.out.println(i1.equals(i3)); // true

    Integer i4 = 128;
    Integer i5 = 128;
    System.out.println(i4 == i5); // false
    // ! Java Cache for Integer (-128 to 127)
  }
}