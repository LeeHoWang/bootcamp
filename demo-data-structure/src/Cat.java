import java.util.Objects;

public class Cat {
  private String name;

  public Cat(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) 
        return true; 
    if (!(o instanceof Cat))  
      return false;
    Cat cat = (Cat) o;
    return Objects.equals(this.name, cat.getName());
  }

  @Override
  public String toString() {
    return "Cat{" //
      + "name= " + this.name //
      + ")"; //
  }
}
