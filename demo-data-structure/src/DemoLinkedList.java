import java.util.LinkedList;

public class DemoLinkedList {
  public static void main(String[] args) {
    // ! explain memory structure
    // ArrayList vs LinkedList

    // Dog[]
    // ArrayList<Dog>

    // LinkedList
    LinkedList<Cat> cats = new LinkedList<>();
    cats.add(new Cat("Mary"));
    cats.add(new Cat("Peter"));
    cats.add(new Cat("Steve"));
    System.out.println(cats);

    cats.remove(new Cat("Mary"));
    System.out.println(cats);

    cats.remove(1); // remove the 2nd cat
    
  }
}
