import java.util.PriorityQueue;
import java.util.Queue;

public class DemoPriorityQueue{
  public static void main(String[] args) {
    Queue<String> names = new PriorityQueue<>();
    names.add("John");
    names.add("Peter");
    names.add("Alex");

    System.out.println(names.poll()); // Alex

    Queue<Integer> ages = new PriorityQueue<>();
    ages.add(80);
    ages.add(50);
    ages.add(10);
    ages.add(60);
    ages.add(20);
    System.out.println(ages.poll()); // 10

    Queue<Human> humans = new PriorityQueue<>(); 
    // ? VS Linkedlist
    humans.add(new Human("John"));
    humans.add(new Human("Peter"));
    humans.add(new Human("Alex"));

    // ! poll() -> human object's compareTo -> Ranking
    System.out.println(humans.poll().getName()); // Alex
    humans.add(new Human("Benny"));
    System.out.println(humans.poll().getName()); // Benny

    // From large
    Queue<Ball> balls = new PriorityQueue<>(); 
    balls.add(new Ball(100, Ball.Color.RED));
    balls.add(new Ball(70, Ball.Color.BLUE));
    balls.add(new Ball(120, Ball.Color.YELLOW));
    balls.add(new Ball(110, Ball.Color.BLUE));
    System.out.println(balls.poll());
    balls.add(new Ball(130, Ball.Color.BLUE));
    System.out.println(balls.poll());
    System.out.println(balls.poll());

    Queue<Ball> balls2 = new PriorityQueue<>(new SortedByColor());
    balls2.add(new Ball(100, Ball.Color.RED));
    balls2.add(new Ball(70, Ball.Color.BLUE));
    balls2.add(new Ball(120, Ball.Color.YELLOW));
    balls2.add(new Ball(110, Ball.Color.BLUE));
    System.out.println(balls2.poll());
    balls2.add(new Ball(130, Ball.Color.BLUE));
    System.out.println(balls2.poll());
    System.out.println(balls2.poll());

  }  
}