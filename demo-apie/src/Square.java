// ! Child Class

import java.math.BigDecimal;

public class Square extends Shape {
  private double length;

  public Square(double length, Color color) {
    super(color); // ! calling Parent Constructor
    this.length = length;
  }

  public double getLength() {
    return this.length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  @Override
  public double area() {
    return BigDecimal.valueOf(this.length) //
        .multiply(BigDecimal.valueOf(this.length)) //
        .doubleValue();
  }


  public static void main(String[] args) {
    // ! 2 Java Objects (each java object has its parent container)
    Square s1 = new Square(3.5, Color.BLACK);
    Square s2 = new Square(4.0, Color.BLUE);

    // Square Class inherits Shape Class's methods (getColor, setColor)

    System.out.println(s1.getLength()); // 3.5
    System.out.println(s1.getColor()); // BLACK

  }
}
