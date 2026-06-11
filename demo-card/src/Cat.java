public class Cat {
  private Gun gun;
  private boolean isDie;
  private boolean isAlive;


  public Cat(Gun gun) {
    this.gun = gun;
    this.isDie = false;
  }

  public void setDie() {
    this.isDie = true;
  }

  public boolean addBullet() {
    return this.gun.addBullet();
  }

    public boolean isAlive() {
        return !this.isDie;  // Alive if NOT dead
    }


  public void shoot(Cat cat) {
    if (this.gun.shoot()) {
      // ! cat.isDie()
      cat.setDie();
      // only the address of the attribute, so we need setting
    }
  }
    public static void main(String[] args) {
      Cat c1 = new Cat(new HandGun());
      Cat c2 = new Cat(new HandGun());
      c1.shoot(c2);

      System.out.println(c1.isAlive());
      System.out.println(c2.isAlive());
      c1.addBullet();
      c1.shoot(c2);
      System.out.println(c1.isAlive());
      System.out.println(c2.isAlive());
    }
  }

