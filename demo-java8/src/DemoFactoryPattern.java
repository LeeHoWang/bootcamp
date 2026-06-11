public class DemoFactoryPattern {
  // ! Factory Pattern -> Polymorphism + Encapsulation
  // ! Open-Closed Coding Pattern -> Reduce maintainence for new class
  public static void main(String[] args) {
    FurnitureFactory ff = FurnitureFactory.of(Furniture.Type.VICTORIAN);
    // ! this chair reference is pointing a chair object
    Furniture furniture = ff.createChair();
    // ! Main Logic no longer need to change (after FactoryPattern): hasLegs and sitOn
    if (furniture.hasLegs()) {
      System.out.println("This furniture has legs");
    } else {
      System.out.println("This furniture has no leg");
    }
  }
}
