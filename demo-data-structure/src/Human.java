import java.util.Objects;

public class Human implements Comparable<Human> {
  private String name;

  public Human(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // ! Ranking Two objects
  // this vs human

  @Override
  public int compareTo(Human human) {
    // ! my name - human's name (compare first char)
    return this.name.compareTo(human.getName()) * -1;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } 
    if (!(obj instanceof Human)) { 
      return false;
    }
    Human human = (Human) obj;
    return Objects.equals(this.name, human.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }

  @Override
  public String toString() {
    return "Human{name='" + name + "'}";
  }
}


