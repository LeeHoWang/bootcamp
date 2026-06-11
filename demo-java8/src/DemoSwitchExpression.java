public class DemoSwitchExpression {
  public static void main(String[] args) {
    // Java 14()
    // ! switch Disadvantage
    // 1. break
    // 2. Cannot cater AND events
    // 3. Cannot cater Range checking

    // (Use Case) switch -> Enum (finite)

    // Java 14: Switch Expression
    Weekday today = Weekday.WEDNESDAY;
    switch (today) {
      case MONDAY -> System.out.println("It's Monday!");
      case TUESDAY -> System.out.println("It's Tuesday!");
      // case WEDNESDAY -> System.out.println("It's Wednesday!");  // missing OK
      case THURSDAY -> System.out.println("It's Thursday!");
      case FRIDAY -> System.out.println("It's Friday!");
      // case FRIDAY -> System.out.println("It's Friday!"); // duplicated, NOT OK
      case SATURDAY -> System.out.println("It's Saturday!");
      case SUNDAY -> System.out.println("It's Sunday!");
      default -> System.out.println("Not Found."); // ! default is optional for enum
    };

    int value = switch (today) {
      case MONDAY -> 2;
      case TUESDAY -> 3;
      case THURSDAY -> 4;
      case FRIDAY -> 5;
      case SATURDAY -> 6;
      case SUNDAY -> 7;
      default -> -1; 
    };
    System.out.println("value=" + value);
 
  String weather = "Rain";  
  value = switch (today) {
      case MONDAY -> {
        if ("Rain".equals(weather)){
          yield 10; // ! yield is used to return value from switch block, similar to return in method
        } 
          yield 20;
        }
      case TUESDAY -> 3;
      case THURSDAY -> 4;
      case FRIDAY -> 5;
      case SATURDAY -> 6;
      case SUNDAY -> 7;
      default -> -1; 
    };
    System.out.println("value=" + value);
  }

  public static enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY,;
  }

}
