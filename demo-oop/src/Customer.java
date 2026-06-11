import java.math.BigDecimal;

public class Customer {
  // A customer has many orders
  private Order[] orders;

  public Customer() {
    this.orders = new Order[0];
  }

  public void add(Order newOrder) {
    Order[] newOrders = new Order[this.orders.length + 1];
    for (int i = 0; i < this.orders.length; i++) {
      newOrders[i] = this.orders[i];
    }
    newOrders[newOrders.length - 1] = newOrder;
    this.orders = newOrders;
  }

  public double totalOrderAmount() {
    BigDecimal bd = BigDecimal.ZERO;
    for (int i = 0; i < this.orders.length; i++) {
      bd = bd.add(BigDecimal.valueOf(this.orders[i].totalAmount()));
    }
    return bd.doubleValue();
  }

  public boolean isVip() {
    return this.totalOrderAmount() >= 100_000;
  }

  public static void main(String[] args) {
    Customer c1 = new Customer();
    
    Order o1 = new Order();
    Item apple = new Item(10.9, 2);
    Item iphone = new Item(9000, 20);
    o1.add(apple);
    o1.add(iphone);

    Order o2 = new Order();
    o2.add(new Item(20, 1));

    c1.add(o1);
    c1.add(o2);

    System.out.println(c1.isVip()); // true

    System.out.println(c1.totalOrderAmount()); // 180041.8
    o1.remove(1);
    System.out.println(c1.totalOrderAmount()); // 41.8
    System.out.println(c1.isVip()); // false
  }

}