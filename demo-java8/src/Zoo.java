// Library -> Attribute Book (library object get book object)
// book -> find library?

public class Zoo {
  private String zooName;
  private Tiger tiger;

  public Zoo(String zooName) {
    this.zooName = zooName;
  }

  public void setTiger(Tiger tiger) {
    this.tiger = tiger;
  }

  public void createTiger(String tigerName) {
    this.tiger = this.new Tiger(tigerName);
  }

  public String getTigerName() {
    return this.tiger.getName();
  }

  // ! Inner Class
  // Runtime -> assoicate with Parent Object
  public class Tiger {
    private String name;

    public Tiger(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }

    // ! Now, Inner Class Object is able to access (read + write) Outer Class Attribute
    public String getZooName() {
      return zooName;
    }

    public void changeZooName(String newZooName) {
      zooName = newZooName;
    }

    @Override
    public String toString() {
      return "Tiger(" //
        + "zoo=" + zooName // ! Able to read Outer Class attribute
        + ",name=" + this.name
        + ")";
    }
  }

  public static void main(String[] args) {
    // 
    Zoo z1 = new Zoo("ABC Zoo");
    z1.createTiger("Mary");
    System.out.println(z1.getTigerName()); // Mary

    // ! Correct Syntax
    Zoo.Tiger t2 = z1.new Tiger("Peter");
    System.out.println(t2.getZooName()); // ABC Zoo
    t2.changeZooName("XXX");
    System.out.println(t2.getZooName()); // XXX


    // ! Wrong way to create Tiger object.
    // Tiger t1 = new Tiger("John");
  }
}
