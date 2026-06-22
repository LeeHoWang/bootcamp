import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DataStructureExercise1 {
  public static void main(String[] args) {
    // Exercise 1: Array List Basic Operations

    // 1a. Create an ArrayList of integers.
    // 1b. Add the following numbers: 10, 20, 30, 40, and 50.
    // 1c. Print all the elements in the list.
    // 1d. Remove the number 30 from the list.
    // 1e. Print the size of the list.
    // ArrayList<Integer> num1 = new ArrayList<>();
    // num1.add(Integer.valueOf(10)); // can I add multiple
    // num1.add(20);
    // num1.add(30);
    // num1.add(40);
    // num1.add(50);
    // System.out.println(num1);
    // num1.remove(Integer.valueOf(30)); // can I remove 30 without knowing it position?
    // System.out.println(num1.size());

    // Exercise 2: Search and Update

    // 2a. Create an ArrayList of strings to store names of fruits: "Apple", "Banana", "Mango", and
    // "Orange".
    // 2b. Check if "Grapes" exists in the list.
    // 2c. If it doesn’t exist, add it to the list.
    // 2d. Update "Mango" to "Peach".
    // 2e. Print the final list.
    // ArrayList<String> Fruits = new ArrayList<>();
    // Fruits.addAll(List.of("Apple", "Banana", "Mango", "Orange"));
    // if (!Fruits.contains("Grapes")) {
    //   Fruits.add("Grapes");
    //     }
    // int index = Fruits.indexOf("Mango");
    // if (index != -1) {
    //     Fruits.set(index, "Peach");
    // }    
    // System.out.println(Fruits);

    // Exercise 3: Remove Duplicates

    // 3a. Create an ArrayList with the following numbers: 10, 20, 10, 30, 40, 20, 50.
    // 3b. Remove duplicates from the list using a HashSet.
    // 3c. Print the list after removing duplicates.
    // ArrayList<Integer> dup = new ArrayList<>();
    // dup.addAll(List.of(10, 20, 10, 30, 40, 20, 50));
    // HashSet<Integer> clean = new HashSet<>();
    // for (Integer a : dup) {
    //   clean.add(a);
    // }
    // System.out.println(clean);

    // Exercise 4: HashSet Basic Operations

    // 4a. Create a HashSet of strings to store country names: "USA", "India", "China", "Japan".
    // 4b. Add "Canada" to the set.
    // 4c. Add "India" again. Print the result.
    // 4d. Print all elements in the set.
    // HashSet<String> country = new HashSet<>();
    // country.add("Canada");
    // System.out.println(country.add("India"));
    // System.out.println(country);

    // Exercise 5: Check the numbers

    // 5a. Create a HashSet of numbers: 1.1, 2.2, 3.3, 4.4, 5.5
    // 5b. Check if the set contains the number 3.3
    // 5c. Remove the number 2.2 from the set.
    // 5d. Print the size of the set.
    // HashSet<Double> num2 = new HashSet<>();
    // num2.contains(3.3);
    // num2.remove(2.2);
    // System.out.println(num2.size());

    // Exercise 6: Intersection of Sets

    // 6a. Create two HashSets:
    // 6b. Set 1: 10, 20, 30, 40
    // 6c. Set 2: 30, 40, 50, 60
    // 6d. Find the common numbers of the two sets.
    // 6e. Print the resulting set.
    // HashSet<Integer> set1 = new HashSet<>(Set.of(10, 20, 30, 40));
    // HashSet<Integer> set2 = new HashSet<>(Set.of(30, 40, 50, 60));
    // HashSet<Integer> common = new HashSet<>(set1);
    // common.retainAll(set2);
    // System.out.println(common);

    // Exercise 7: Convert HashSet to ArrayList

    // 7a. Create a HashSet with the following String: "Cherry", "Steve", "Chole", "Jenny", "Vicky".
    // 7b. Convert the HashSet to an ArrayList.
    // 7c. Print the converted list.
    // HashSet<String> name1 = new HashSet<>(Set.of("Cherry", "Steve", "Chole", "Jenny", "Vicky"));
    // ArrayList<String> name2 = new ArrayList<>(name1);
    // System.out.println(name2);

    // Exercise 8: ArrayList of Students
    // 8a. Create an ArrayList to store Student objects.
    // Add the following students:
    // ID: 1, Name: Alice
    // ID: 2, Name: Bob
    // ID: 3, Name: Charlie
    // List<Student> students = new ArrayList<>();
    // students.add(new Student(1, "Alice"));
    // students.add(new Student(2, "Bob"));
    // students.add(new Student(3, "Charlie"));
    // 8b. Iterate over the ArrayList and print each student's details.
    // for (Student student : students) {
    //   System.out.println(student.getName());
    // }
    // 8c. Remove the student Bob.
    // students.remove(new Student(2, "Bob"));
    // 8d. Write a static method to search for a student by ID and return their name. If the student is
    // not found,
    // return "Student not found".
    // String result = DataStructureExercise1.search(students, 3);
    // System.out.println(result);

    // 8e. Create another ArrayList to store student with name starts with 'A'
    // List<Student> newStudents = new LinkedList<>();
    // for (Student s : students) {
    //   if (s.getName().startsWith("A"))
    //     newStudents.add(s);
    // }
    // System.out.println(newStudents);

    // Exercise 9: HashSet of Students
    // 9a. Create two HashSets of Student objects:
    // Set 1: Alice (ID: 1), Bob (ID: 2), Charlie (ID: 3)
    // Set 2: Bob (ID: 2), Charlie (ID: 3), David (ID: 4)
    // 9b. Find the common students of the two sets
    // 9c. Print the result.
    // 9a. 建立兩個 HashSet<Student>
    HashSet<Student> Students1 = new HashSet<>();
    Students1.add(new Student(1, "Alice"));
    Students1.add(new Student(2, "Bob"));
    Students1.add(new Student(3, "Charlie"));

    HashSet<Student> Students2 = new HashSet<>();
    Students2.add(new Student(2, "Bob"));
    Students2.add(new Student(3, "Charlie"));
    Students2.add(new Student(4, "David"));

    // 9b. 找出共同學生（交集）
    HashSet<Student> Duplicates = new HashSet<>(Students1);  // 複製 Students1
    Duplicates.retainAll(Students2);                         // 保留與 Students2 共同的

    // 9c. 印出結果
    System.out.println(Duplicates);
  }
  

  // ✅ 修正：search 方法移到 main 外面（錯誤 2 修正）
  public static String search(List<Student> students, int id) {
    for (Student student : students) {
      if (student.getId() == id)
        return student.getName();
    }
    return "Student not found";
  }

  // ✅ 修正：Student 類別移到 main 外面（錯誤 3 修正）
  public static class Student {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Student))
        return false;
      Student student = (Student) obj;
      return Objects.equals(this.id, student.getId())
          && Objects.equals(this.name, student.getName());
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
      return "Student("
          + "id=" + this.id
          + ",name=" + this.name
          + ")";
    }
  }
}