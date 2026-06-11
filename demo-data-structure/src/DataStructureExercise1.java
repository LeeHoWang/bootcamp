import java.util.ArrayList;
import java.util.List;

public class DataStructureExercise1 {

  private Student student;
  public int id;
  public String name;

  public void setID(int id) {
    this.id = id;
  }

  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "Alice")); 
  }
}

class Student {
    private int id;
    private String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}