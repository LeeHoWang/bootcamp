import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Team<T extends Hero> {
  // 5 Hero as one team
  private Queue<T> heros;

  // ! Generic may be too flexible for the design.
  // Queue<Hero> already presents a team of different type of hero
  // private Queue<Hero> hero;

  public Team() {
    this.heros = new LinkedList<>();
  }

  public boolean add(T hero) {
    if (this.heros.size() < 5) {
      return this.heros.add(hero);
    }
    return false;
  }

  public T poll() {
    return this.heros.poll();
  }

  public T get(int index) {
    Queue<T> copyQueue = new LinkedList<>(this.heros);
    while (index > 0) {
      copyQueue.poll();
      index--;
    }
    return copyQueue.peek();
  }

  public void swap(int hero1Index, int hero2Index) {
    T[] heroArray = (T[]) heros.toArray(new Hero[heros.size()]);
    T temp = heroArray[hero1Index];
    heroArray[hero1Index] = heroArray[hero2Index];
    heroArray[hero2Index] = temp;
    this.heros = new LinkedList<>(Arrays.asList(heroArray));
  }

  public static void main(String[] args) {
    // method add hero

    // method swap two Hero

    // method poll() -> Hero

    Team<Warrior> team1 = new Team<>();
    team1.add(new Warrior());
    // team1.add(new Archer());
    
    Team<Archer> team2 = new Team<>();
    team2.add(new Archer());
    // team2.add(new Warrior());

    Team<Hero> team3 = new Team<>(); // This
    team3.add(new Archer());
    team3.add(new Warrior()); // index 1
    team3.add(new Warrior());
    team3.add(new Archer()); // index 3
    team3.add(new Warrior());

    team3.swap(1, 3); // second <-> forth
    Hero hero = team3.get(1);

    System.out.println(hero instanceof Archer); // true
    System.out.println(hero instanceof Warrior); // false

    // ! String Object is immutable
    String s = "hello";
    
    System.out.println(s.charAt(0)); // h
    String s2 = s;
    
    // String method (write) -> create a new string
    // ! s2 has no change.
    String s3 = s2.replace('l', 'x');

    // ! StringBuilder is mutable (i.e. replace method)
    StringBuilder sb = new StringBuilder("hello");
    StringBuilder sb2 = sb;
    // StringBuilder
    sb.replace(0, 2, "xx");
    System.out.println(sb); // xxllo
    System.out.println(sb2); // xxllo
  }
}
