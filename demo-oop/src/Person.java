// this structure is allowed by Java, but no reason

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Person { // ! Class -> Blueprint (藍圖)
  // ! 1. Attributes 
  private String name; 
  private int age;
  private double height;
  private double weight;
  
  // ! 2. Constructor (Step to create object) // similar to method
  // Input (String + int)
  public Person(String name, int age){
  // ! 第一人稱視野
    this.name = name;
    this.age = age; 
  }

  public Person(String name, int age, double height, double weight){
  // ! 第一人稱視野
    this.name = name;
    this.age = age;  // it is a place holder
    this.height = height;
    this.weight = weight;
    // this.weight is the blueprint, weight is assigning the exact value to the blueprint
  }

  // ! 3. Getter
  public String getName(){
  // ! 第一人稱視野
    return this.name;
  }

  public int getAge(){ //need to follow type
    // ! 第一人稱視野
    return this.age;
  }

  public double getHeight(){
    return this.height;
  }

  public double getWeight(){
    return this.weight;
  }

  public double bmi() {
    // weight / height^2
    BigDecimal HeightSquare = BigDecimal.valueOf(this.height)
      .multiply(BigDecimal.valueOf(this.height));
    return BigDecimal.valueOf(this.weight)
      .divide(HeightSquare, 2, RoundingMode.HALF_UP).doubleValue();
  }

  // ! 4. Instance method: Setter 
  public void setName(String name){
      // ! 第一人稱視野
    this.name = name;
  }

  public void setAge(int age){
      // ! 第一人稱視野

    this.age = age;
  }

  public void setHeight(double height){
    this.height = height;
  }

  public void setWeight(double weight){
    this.weight = weight;
  }



  //  第三人稱視野
  public static void main(String[] args){
    // Harddisk -> store Person.java file
    // Command to Create Person Object (memory)

    // object -> life // ! inside memory
    int x = 3;
    Person p1 = new Person("John", 10); // ! calling constructor to create object
    Person p2 = new Person("Peter", 7);

    // p1 -> name age  
    System.out.println(p1.getName());
    System.out.println(p1.getAge());

    p1.setName("Jenny");
    System.out.println(p1.getName());

    System.out.println(p1.name);

    // p3 ()
    Person p3 = new Person("Alice", 8, 1.6, 50.0);
    System.out.println(p3.bmi());
  }


  public String weightCat(){
    if (this.bmi() < 18.5){
      return "Underweight";
    } else if (this.bmi() < 24.9){
      return "Normal weight";
    } else if (this.bmi() < 29.9){
      return "Overweight";
    } else if (this.bmi() < 34.9){
      return "Obesity";
    } else {
      return "Severe Obesity";
    }
  }
}

// public class Exam {
//   private int score;
//   private String subject;
// }

// public Exam (int score, String subject){
//   this.score = score;
//   this.subject = subject;

// }

// public int getScore(){
//   return this.score;
// }

// public String getSubject(){
//   return this.subject;
// }

// public void setScore(int score){
//   this.score = score;
// }

// public void setSubject(String subject){
//   this.subject = subject;
// }

// public static void main(String[] args){
//   Exam e1 = new Exam(90, "Math");
//   System.out.println(e1.getScore());
//   System.out.println(e1.getSubject());

//   e1.setScore(95);
//   System.out.println(e1.getScore());
//     }
// }
// ///

