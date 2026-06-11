public class Person implements Action {
  @Override
  public void read() {
    System.out.println("Person Class read...");
  }

  @Override
  public void run() {
    System.out.println("Person Class run...");
  }

  public static void main(String[] args) {
    // ! A object is able to read and run (That's why Person Class)

    // Anonymous Inner Class
    // No longer need a class before creating object
    // ! Create one-off object in runtime
    Action person = new Action() {
      @Override
      public void read() {
        System.out.println("Anonymous Inner Class read...");
      }
      @Override
      public void run() {
        System.out.println("Anonymous Inner Class run...");
      }
    };
    person.run();

    Action person2 = new Person();
    person2.run();
  }
}
