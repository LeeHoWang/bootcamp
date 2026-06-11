// ! Child Class need to implement Parent's interface & your own interface
// ! For this case, attack() and accelerate
public class Archer extends Hero implements Accelerate {
  // speed -> attribute? level (only archer with speed)
  // accelerate -> speed * 2
  private boolean accelerateMode;

  public Archer() {
    // super();
    super.setHp(Heros.MAX_HP[Heros.ARCHER][0]);
    this.accelerateMode = false;
  }

  @Override
  public void levelUp() {
    super.levelUp();
    super.setHp(Heros.MAX_HP[Heros.ARCHER][super.getLevel() - 1]);
  }

  // ! this vs hero
  @Override
  public void attack(Hero hero) {
    // Which object's status change...
    int myPa = this.getPa();
    hero.deductHp(myPa);
  }

  public int getSpeed() {
    if (this.accelerateMode) {
      return Archers.SPEED[super.getLevel()] * 2;
    } else {
      return Archers.SPEED[super.getLevel()];
    }
  }

  @Override
  public void accelerate() {
    accelerateMode = true;
  }

  public int getPa() {
    double number = Math.random(); // 0 - < 1
    double chance = Heros.CC[Heros.ARCHER][super.getLevel() - 1] / 100.0;
    int extraPa = 0;
    if (number < chance) {
      extraPa = Heros.CD[Heros.ARCHER][super.getLevel() - 1];
    }
    return Heros.PA[Heros.ARCHER][super.getLevel() - 1] + extraPa;
  }

  // Critical Damage
  // level role -> %
  // level role -> + PA

  public static void main(String[] args) {
    Archer a1 = new Archer();
    System.out.println(a1.getLevel()); // 1
    System.out.println(a1.getHp()); // 100


    // max hp, max mp (level, role)
  }
}
