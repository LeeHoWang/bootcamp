// ! Parent Class
// 抽象
public abstract class Shape {
  private Color color;
  private String name;

  public abstract double area();

  // ! Not for object creation
  public Shape(Color color) {
    this.color = color;
  }
  
  public Shape(Color color, String name) {
    this.color = color;
    this.name = name;
  }

  public Color getColor() {
    return this.color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
