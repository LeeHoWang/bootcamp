public class DemoString{
  public static void main (String[] args) {
    String s1 = "Hello";
    String s2 = "Hello";
    System.out.println(s1.equals(s2)); // true, because the contents are the same
    System.out.println(s1 == s2); // true, because string literals are interned

    String s3 = new String("Hello"); // Force to create new object
    System.out.println(s1.equals(s3)); // true, because the contents are the same
    System.out.println(s1 == s3); // false, because s3 is a new object

    // String Literal Pool: 
    // Java maintains a pool of string literals. When you create a string literal, Java checks the pool first. 
    // If the string already exists, it returns a reference to the existing string. 
    // If not, it creates a new string and adds it to the pool.

    // "hello" -> String Object -> String Literal Pool (Cache)
    // new String("hello") -> String Object -> Heap Memory 
  }
}