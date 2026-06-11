// ! 1. APIE -> Inheritance

import java.math.BigDecimal;

public class Circle extends Shape {
  // ! Inherit all attributes (Parent Class methods)
  // ! Inherit all object methods (Parent Class methods)
  // ! CANNOT Inherit Parent's constructor (but you can call -> super)

  private double radius;
  // String not appropriate for color: Java is case sensitive
  // private Color color;

  public Circle(double radius, Color color) {
    super(color); // call parent constructor
    this.radius = radius;
  }

  // ! Encapsulation (封裝Attribute + 過程)
  @Override
  public double area() {
    return BigDecimal.valueOf(this.radius) //
        .multiply(BigDecimal.valueOf(this.radius)) //
        .multiply(BigDecimal.valueOf(Math.PI)) //
        .doubleValue();
  }


  public Circle(double radius, Color color, String name) {
    super(color, name);
    this.radius = radius;
  }

  // get set
  public double getRadius() {
    return this.radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public static void main(String[] args) {
    Circle c1 = new Circle(3.5, Color.RED); //
    System.out.println(c1.getRadius());
    System.out.println(c1.getColor());
    c1.setColor(Color.BLACK);
    System.out.println(c1.getColor());
    System.out.println(c1.getColor().getValue());
    System.out.println(c1.getColor().getDescription());

    System.out.println(Direction.WEST.oppsite());
    System.out.println(Direction.SOUTH.oppsite());

    Circle c2 = new Circle(2.3, Color.BLACK, "Super Circle");

  }

}
