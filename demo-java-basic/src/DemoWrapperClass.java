public class DemoWrapperClass {
  public static void main(String[] args) {
    // ! Primitives
    // byte, short, int, long, float, double, char, boolean

    // ! Class
    // Byte, Short, Integer, Long, Floar, Double, Character, Boolean

    // ! 升級關係
    // ! byte -> short -> int -> long -> float -> double 
    // ! char -> int

    // ! Primitive -> Wrapper Class (Autobox)


    byte b1 = 127; // Java Special Handling -> compile checking
    Byte b2 = 127; // Java Special Handling -> compile checking

    short s1 = 32000; // Java Special Handling -> compile checking
    Short s2 = 32000; // Java Special Handling -> compile checking

    int i1 = 2_100_000_000; 
    Integer i2 = 2_100_000_000;

    long l1 = 2000000; // int value -> long variable 
    Long l3 = 2000000L;
    // Long l2 = 2000000; // ! error: int -> long (promotion) -> Long (autobox)
    // Checking upgrade relationship

    float f1 = 0.1234f;
    Float f2 = 0.1234f; // autobox (float value -> Float variable)

    double d1 = 0.1234;
    Double d2 = 0.1234;

    char ch1 = 'a';
    Character ch2 = 'a'; // autobox (char value -> Character variable)

    boolean bool1 = false;
    Boolean bool2 = false; // autobox (boolean value -> Boolean variable)

    // ! error: float -> double -> Double
    // Double d3 = 0.123f;  // This causes compilation error

    // Correct ways to declare a Double:
    Double d3 = 0.123;      // double literal → Double (autoboxing)
    Double d4 = 0.123d;     // explicit double literal
    Double d5 = (double) 0.123f;  // cast float to double, then autobox
    Double d6 = Double.valueOf(0.123f);  // explicit conversion
  }
}
