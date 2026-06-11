public class Ingredient {
  private String name;
  private double price;

  public Ingredient(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {           // obj 係傳入嚟嘅物件
      if (this == obj) return true;             // 自己同自己比？
      if (!(obj instanceof Ingredient)) return false;  // 唔係 Ingredient？
      
      Ingredient ingredient = (Ingredient) obj;       // 將 obj 轉做 Ingredient，叫佢做 that
      
      return this.name.equals(ingredient.name);       // 自己個名 等於 對方個名？
  }

  public static void main(String[] args) {
    Ingredient milk = new Ingredient("Milk", 5);
    Ingredient sugar = new Ingredient("Sugar", 3);
    System.out.println(milk.getPrice());  // 5
    System.out.println(sugar.getPrice());  // 3
  }

}
