public class Calculator {
  private int x;
  private int y;

  // 1 + 3 -> 4
  // ! Static Method: input parameters and return a value, no need to create an instance
  // ! Static Method: Belongs to Class, not object, cannot read "this"
  public static int sum(int x, int y) {
    return x + y;
  }

  public static int subtract(int x, int y) {
    return x - y;
  }

  public Calculator() {
    
  }

  public void SetX(int x) {
    this.x = x;
  }

  public void SetY(int y) {
    this.y = y;
  }


  
  public void add(int x, int y) {
    // ! Instance Method: need to create an instance to call, can access instance variables
    System.out.println(x + y);
  }

  public static void main(String[] args) {
    Calculator calc = new Calculator();
    System.out.println(sum(1, 3)); //3
    System.out.println(subtract(5, 2)); //3
    calc.add(2,3);    
    // ! How to revise the design to be OOP?
    
    
   }
}