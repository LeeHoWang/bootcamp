import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DemoTypeInference {
  // private var name;

  // public DemoTypeInference (var name){
  //   this.name = name;
  // }

  // ! for Java, the type of parameters & return type must be determined during compile time
  // public var sleep(var time){
  //   System.out.println("Sleep:" + time);
  // }



  public static void main(String[] args) {
    // Java 10
    String s = "hello";
    s.charAt(0); // ! Polymorphism Compile time

    var s2 = "hello"; // Determine the type of s2
    s2.charAt(0); // ! 

    // s2 = 10; // 不是萬能key

    var names = new ArrayList<>();
    names.add("John");

    List<List<String>> nameLists = new LinkedList<>();
    nameLists.add(List.of("John", "Mary"));
    nameLists.add(List.of("Apple", "Orange", "Kiwi"));

    for (var nameList : nameLists) {
      for (var name : nameList) {
        System.out.println(name.length());
    }
  }

  // ! Syntax "var" -> compile time -> Generate back to Actual Type

  }
}
