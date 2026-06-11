public class DemoPrimitive{
  public static void main(String[] args) {
    // ! 8 Primitive Data Types in Java
    // 1. byte: 8-bit signed integer
    // 2. short: 16-bit signed integer
    // 3. int: 32-bit signed integer
    // 4. long: 64-bit signed integer
    // 5. float: 32-bit floating-point number
    // 6. double: 64-bit floating-point number
    // 7. boolean: represents true or false
    // 8. char: represents a single character
    int a = 10;
    double b = 3.14;
    boolean c = true;
    char d = 'A';

    System.out.println("Integer: " + a);
    System.out.println("Double: " + b);
    System.out.println("Boolean: " + c);
    System.out.println("Character: " + d);

    // ! byte (-128 to 127)
    byte b1 = 100;

    // int (32-bit signed integer)
    // long (64-bit signed integer)
    int i1 = 1000000000; // exceeds byte range
    long l1 = 10000000000L; // 'L' suffix for long literals

    // ! We can only define an int value or long value, but no byte and short value, because they are too small to hold the value 1000000000 or 10000000000.
    // 127 is an int value
    // 127L is a long value

    // ! float -> double value
    // 99.99 is a double value
    // 99.99f is a float value
    double d5 = 99.99; // double literal
    float f5 = 99.99f; // float literal
  } 
}