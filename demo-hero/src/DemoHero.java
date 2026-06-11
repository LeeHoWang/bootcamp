public class DemoHero {
  public static void main(String[] args) {
    // Hero[]
    Hero[] heros = new Hero[3];
    heros[0] = new Archer();
    heros[1] = new Archer();
    heros[2] = new Archer();

    Hero target = new Archer();

    System.out.println(target.getHp());

    for (Hero hero : heros) {
      hero.attack(target); 
      // ! Hero Class has attack method (Compile time)
      // ! Which attack method is being called (Runtime)
    }

    System.out.println(target.getHp());

  }
}
