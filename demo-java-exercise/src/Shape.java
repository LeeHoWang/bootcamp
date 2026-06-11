import java.util.List;

public abstract class Shape {
  abstract double area();

  // ! Generic 
  public static double totalArea(List<Shape> shapes){ // ! call Shape.area() -> Circle.area() or Rectangle.area()
    return 0.0;
  }

  public static <T extends Shape> double totalArea2(List<T> shapes){ // ! call circle method? No
    return 0.0;
  }

  public static double totalArea3(List<? super Circle> circles){ // ! call Circle.area() 
    return 0.0;
  }  
  public static class Circle extends Shape{
    public int radius;
    @Override
    public double area() {
      return this.radius * this.radius * Math.PI;
    }

    public static class Rectange extends Shape{
      public int length;
      public int width;
      @Override
      public double area() {
        return this.length * this.width;
      }
    }

    public static void main(String[] args) {
      List<Shape> shapes = List.of(new Circle(), new Circle());
      List<Circle> circles = List.of(new Circle(), new Circle());
      totalArea(shapes);
      // totalArea(circles); // ! totalArea != totalArea2

      totalArea2(shapes);
      totalArea2(circles);

      totalArea3(shapes);
      totalArea3(circles);
    }

  }
}
