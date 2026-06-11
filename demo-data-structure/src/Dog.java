public class Dog {
  private String name;
  private Dog dog;

  public Dog(String name, Dog dog) {
    this.name = name;
    this.dog = dog;
  }

  public String getName(){
    return this.name;
  }

  public Dog getDog() {
    return this.dog;
  }

  public static void main(String[] args) {
    Dog head = new Dog("John", new Dog("Peter", null));
    System.out.println(head.getName());
    System.out.println(head.getDog().getName());
  }
}
