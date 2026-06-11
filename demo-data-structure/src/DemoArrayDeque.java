import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DemoArrayDeque {
  public static void main(String[] args) {
    // ! contract extends contract
    // Deque (Interface) extends Queue (Interface)
    Queue<String> names1 = new LinkedList<>();
    Deque<String> names2 = new LinkedList<>();

    Queue<String> names3 = new ArrayDeque<>();
    Deque<String> names4 = new ArrayDeque<>();

    // ! Polymorphism
    // Objects -> determine -> HOW to do (i.e. add()) (Runtime Polymorphism)
    // Object Reference (Type) -> determine -> WHAT can be called (Compile time Polymorphism)

    names1.add("John"); // no addfirst/ addlast
    names1.poll();

    names2.addFirst("Peter");
    names2.addLast("Mary");
    names2.addFirst("Tommy");
    names2.pollFirst();
    names2.pollLast();

    names3.add("John"); // no addfirst/ addlast
    names3.poll();

    names4.addFirst("Peter");
    names4.addLast("Mary");
    names4.addFirst("Tommy");
    names4.pollFirst();
    names4.pollLast();    

    // ! name1 vs name3, no difference in result perspective
    // ! name2 vs name4, no difference in result perspective, but different in speed

    // Deque
    Deque<Human> humans = new LinkedList<>();
    humans.add(new Human("John"));
    System.out.println(humans.contains(new Human("John")));
    humans.add(new Human("Alex"));
    
    // ! Peek -> LookUp
    System.out.println(humans.peekFirst());
    System.out.println(humans.peekLast());

    // ! Bottle filling scenario (push + pop)
    // addLast + pollLast (same idea)
    // addFirst + pollFirst (same idea)
    Deque<Ball> balls = new ArrayDeque<>();
    balls.push(new Ball(10, Ball.Color.RED));
    balls.push(new Ball(20, Ball.Color.YELLOW));
    balls.push(new Ball(15, Ball.Color.BLUE));
    System.out.println(balls.pop()); // Ball(value=15, color=BLUE)

    balls.clear();
    System.out.println(balls);

    // ! why vincent said everything is just right?
  }
}
