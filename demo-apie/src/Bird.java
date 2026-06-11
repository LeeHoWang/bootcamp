public class Bird extends Animal implements Flyable {
  @Override
  public void fly() {
    System.out.println("Bird is flying...");
  }
}
