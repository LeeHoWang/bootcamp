// ! All Classes can implement interface
public abstract class Hero implements Attackable {
  private int hp;
  private int mp;
  private int level;

  public Hero() {
    this.level = 1;
  }

  // ! Abstract class may have abstract method
  // ! All abstract methods must be implemented/override by child class
  public abstract void attack(Hero hero);

  public void deductHp(int toBeDeducted) {
    if (toBeDeducted >= this.hp) {
      this.hp = 0;
    } else {
      this.hp -= toBeDeducted;
    }
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getHp() {
    return this.hp;
  }

  public void levelUp() {
    this.level++;
  }

  public int getLevel() {
    return this.level;
  }

  public static void main(String[] args) {
    
  }
}
