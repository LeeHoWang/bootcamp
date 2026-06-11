public class Circle{
  // constant (static + final)
  // final: cannot be revised after value assignment
  // static: belongs to class
  private static final String CIRCLE_COLOR = "RED";

  // ! Static - No relationship to Circle Object
  // non-final: value can be updated
  private static String brand = "BYD";
  
  // ! the circle radius cannot be revised after object creation
  private final int radius;
  // private String color; // "RED"

  public Circle(int radius) {
    this.radius = radius;
    // this.color = CIRCLE_COLOR;
  }

  // Circle must be RED -> No setColor()

  // ! Instance method -> Attribute/ static variable
  // ! Static method -> static variable
  public String getColor() {
    return CIRCLE_COLOR;
  }

  // radius * radius * Math.PI
  public double area() {
    return this.radius * this.radius * Math.PI;
  }

  public static void main(String[] args) {
    System.out.println(Circle.brand); // BYD
  }
}