import java.math.BigDecimal;

public class Order {
  // A Order has many item
  private Item[] items;

  // public Order(Item[] items) {
  // this.items = items;
  // }

  public Order() {
    this.items = new Item[0];
  } 
  // ! Encapsulation

  // 
  public void remove(int index) {
    if (index < 0 || index >= this.items.length) {
      return;
    }
    Item[] newItems = new Item[this.items.length - 1];
    int idx = 0;
    for (int i = 0; i < this.items.length; i++) {
      if (i != index) {
        newItems[idx++] = this.items[i];
      }
    }
    this.items = newItems;
  }

  public void removeAll() {
    this.items = new Item[0];
  }

  public void add(Item newItem) {
    Item[] newItems = new Item[this.items.length + 1];
    for (int i = 0; i < this.items.length; i++) {
      newItems[i] = this.items[i];
    }
    newItems[newItems.length - 1] = newItem;
    this.items = newItems;
  }

  // getter, setter

  // ! Presentation (bmi, area)
  public double totalAmount() {
    BigDecimal bd = BigDecimal.ZERO;
    for (int i = 0; i < items.length; i++) {
      bd = bd.add(BigDecimal.valueOf(this.items[i].subtotal()));
    }
    return bd.doubleValue();
  }

  public Item[] getItems() {
    return this.items;
  }

  public static void main(String[] args) {
    // 99.9 x 4
    // 9.5 x 11

    // Item Object
    Item rice = new Item(99.9, 4);
    Item apple = new Item(9.5, 11);

    // Array Object
    Item[] items = new Item[] {rice, apple};

    // Order Object
    // Order o1 = new Order(items);
    // System.out.println(o1.totalAmount());

    // ! Class User
    // User no longer use array. Author create array instead.

    Order o1 = new Order();
    o1.add(apple);
    o1.add(rice);
    System.out.println(o1.totalAmount()); // 504.1

    for (Item item : o1.getItems()) {
      System.out.println(item.getPrice() + " " + item.getQuantity());
    }
    
  }

}