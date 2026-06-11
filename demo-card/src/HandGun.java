public class HandGun extends Gun {
  private int Bullet;

  public HandGun() {
    this.Bullet = 0;
  }

  public boolean addBullet(){
    if (this.Bullet < 6) {
      this.Bullet++;
      return true;
    }
    return false;
  }

    public int getBullet(){
      return this.Bullet;
    }

  public boolean shoot() {
    if (this.Bullet > 0) {
      this.Bullet--;
      return true;
    }
    return false;

  }

  public static void main(String[] args) {
    HandGun h1 = new HandGun();
    System.out.println(h1.addBullet());
    System.out.println(h1.shoot());
    System.out.println(h1.getBullet());
  }
}

// ! relationship between object and attribute
// ! who own attribute, who needs to change it
// ! abstract the own domain example