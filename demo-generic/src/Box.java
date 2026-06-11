public class Box<T> {
  private T t;

  public Box(T t) {
    this.t = t;
  }

  public T getValue() {
    return this.t;
  }

  public void setValue(T t){
    this.t = t;
  }

  public static void main(String[] args) {
    // ! Generic -> write less class
    Box<Bird> box1 = new Box<>(new Bird());
    box1.getValue().fly();

    Box<Integer> box2 = new Box<>(100);
    // can use getvalue +-*/ now

    Box<String> box3 = new Box<>("Hello");
    System.out.println(box3.getValue().charAt(0));

    // Compile Time (Generic)
    // RunTime (not-Generic)

    // box3.setValue(new Bird()); // error
    // box<T> box4 = new Box<>(); // error
  }
}
