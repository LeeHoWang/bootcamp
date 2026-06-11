// ! Interface (Abstraction) -> implement more than 1 interface
// ! 承諾 you can fly & eat
import java.math.BigDecimal;

public class Superman implements Flyable, Eatable {
  // public class Superman {
  @Override // ! 覆蓋 Parent Class/ Interface method
  public void fly() {
    System.out.println("Superman is flying...");
  }

  @Override
  public void eat() {
    System.out.println("Superman is eating..");
  }

  public static void main(String[] args) {
    Superman s1 = new Superman();
    s1.fly();

    // 1. Extends Parent Class -> Inheritance
    // 2. Interface -> Abstraction

    // ! Polymorphism (多態)
    Flyable person = new Superman();
    person.fly();

    // ! Type of reference (Flyable) determine which method can be called.
    // ! so, eat() cannot be called by "person".
    // ! Method eat() in Superman Object is hidden.
    // person.eat();

    // ! But we take it back.

    // Upper Object cannot be auto-downgraded.
    // from long to int (similar case)

    // take your own risk. Why?
    // because person reference may not be Superman (may be Bird).
    // so, Java thinks it is risky to downcast Superman
    Superman tommy = (Superman) person;

    // ! Type of reference (Superman) determine which method can be called.
    tommy.fly();
    tommy.eat();

    Eatable jenny = new Superman();
    jenny.eat();
    // jenny.fly();

    // ! Why do we need Parent Class and Interface
    Flyable[] arr = new Flyable[3];
    arr[0] = new Bird();
    arr[1] = new Superman();
    arr[2] = new Bird();

    // Circle Array can only store circle object
    // Square Array can only store square object
    // Shape Array can store all child class (circle / square)

    Shape[] shapes = new Shape[4];
    shapes[0] = new Circle(3.5, Color.BLACK);
    shapes[1] = new Square(5, Color.BLUE);
    shapes[2] = new Square(4, Color.RED);
    shapes[3] = new Circle(4.8, Color.RED);

    // ! By using Polymorphism, we can simply use Type Reference for computing.
    // ! Polymorphism: Runtime -> call the object's method.
    BigDecimal totalArea = BigDecimal.ZERO;
    for (Shape shape : shapes) {
      totalArea = totalArea.add(BigDecimal.valueOf(shape.area()));
    }
    System.out.println(totalArea.doubleValue()); // 151.8668047451838

    // Hero[]
    // Acrher[]

  }

}
