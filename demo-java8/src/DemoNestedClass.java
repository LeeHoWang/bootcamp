public class DemoNestedClass {
  private int x;
  
  // Static Nested Class - Cat
  public static void main(String[] args) {
    new DemoNestedClass.Cat("John", 2);
    System.out.println(DemoNestedClass.Color.BLUE); // BLUE

    // new User();
  }

  public static enum Color {
    BLUE, RED
  }

  public static class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
      this.name = name;
      this.age = age;
    }

    // ! Cannot access Outer Class Object, because Cat Class has no relationship at runtime.
    // public void getX() {
    //   return x;
    // }
  }
}
