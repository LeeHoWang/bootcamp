import java.util.List;
import java.util.ArrayList;

public class Coffee {
  private double price;
  private String name;
  private List<Ingredient> ingredients;


  public Coffee(String name, double price) {
    this.name = name;
    this.price = price;
    this.ingredients = new ArrayList<>();
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

  public boolean isDuplicate(Ingredient ingredient) {
      for (Ingredient ing : ingredients) {
          if (ing.equals(ingredient)) {
              return true;
          }
      }
      return false;
  }

  public void addIngredient(Ingredient ingredient) {
      if (isDuplicate(ingredient)) {
          System.out.println("Duplicate: " + ingredient.getName());
          return;
      }
      this.ingredients.add(ingredient);
  }

  public double getTotalPrice() {
    double totalPrice = this.price;
    for (Ingredient ingredient : ingredients) {
      totalPrice += ingredient.getPrice();
    }
    return totalPrice;
  }

  public static void main(String[] args) {
    Coffee c1 = new Coffee("Americano", 25);
    Ingredient milk = new Ingredient("Milk", 5);
    c1.addIngredient(milk);
    
    Coupon coupon = new Coupon("SAVE10", 0.1);  // 10% off
    
    double price = c1.getTotalPrice();  // 30
    double finalPrice = coupon.applyDiscount(price);  // 27
    System.out.println(finalPrice);
    
    // 第二次用同一張
    double finalPrice2 = coupon.applyDiscount(price);  // Coupon already used!
    System.out.println(finalPrice2);  // 30
}

}
