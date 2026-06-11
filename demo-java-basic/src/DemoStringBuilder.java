public class DemoStringBuilder {
  //system.currentTimeMillis() -> return long
  public static void main(String[] args) {
    String s = "hello";

    long before = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
      s = s + "!";
    }
    long after = System.currentTimeMillis();
    System.out.println(after - before); //612 ms

    StringBuilder s2  = new StringBuilder("hello");
    before = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
      s2.append("!");
    }
    after = System.currentTimeMillis();
    System.out.println(after - before); //2 ms

    // ! 2. Revise itself
    StringBuilder s3 = new StringBuilder("Python");
    System.out.println(s3.reverse()); //Python
    char[] text = new char[] {'J', 'a', 'v', 'a'};
    s3.append(text);
    System.out.println(s3); //nohtyPJava

    s3.deleteCharAt(2);
    System.out.println(s3); //nohyPJava
  }
}