import java.util.LinkedList;
import java.util.Queue;

public class DemoQueue {
  public static void main(String[] args) {
    // List, Set, Queue
    Queue<String> queue1 = new LinkedList<>();
    queue1.add("John");
    queue1.add("Jenny");
    queue1.add("Steven");
    
    System.out.println(queue1.poll()); // John
    System.out.println(queue1.poll()); // Jenny
    System.out.println(queue1.poll()); // Steven

    Queue<Human> queue2 = new LinkedList<>();
    queue2.add(new Human("John"));
    queue2.add(new Human("Jenny"));
    queue2.add(new Human("Steven"));

    while (!queue2.isEmpty()) {
      System.out.println(queue2.poll().getName());
    }

  }
}
