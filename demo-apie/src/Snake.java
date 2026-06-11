import java.util.Objects;

public class Snake extends Animal {
  private String name;

  public Snake(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  // ! 覆蓋 Object.class equals()
  @Override
  public boolean equals(Object obj) {
    // checking object address
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Snake)) {
      return false;
    }
    Snake snake = (Snake) obj;
    return this.name.equals(snake.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }
}
