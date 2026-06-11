public class DemoMath {
  public static void main(String[] args) {
    // pow()
    System.out.println(Math.pow(2.0, 4)); // 16.0
    
    // PI
    System.out.println(Math.PI); // 3.141592653589793
    
    // sqrt()
    System.out.println("sqrt(10) = " + Math.sqrt(10)); // 3.1622776601683795
    
    // min() - using array and for loop
    int[] numbers = {10, 5, 8, 3, 12, 7};
    int min = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] < min) {
        min = numbers[i];
      }
    }
    System.out.println("Min value: " + min); // 3
    
    // max() - using array and for loop
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }
    System.out.println("Max value: " + max); // 12
    
    // abs()
    System.out.println(Math.abs(-5)); // 5
    System.out.println(Math.abs(5));  // 5
    
    // ceil() floor()
    System.out.println(Math.ceil(2.3));  // 3.0
    System.out.println(Math.floor(2.3)); // 2.0
    System.out.println(Math.ceil(2.7));  // 3.0
    System.out.println(Math.floor(2.7)); // 2.0
    
    // random
    System.out.println(Math.random()); // 0.0 <= x < 1.0
    
    // ! Question, Random 1-49
    double randomNum = Math.floor(Math.random() * 49) + 1;
    System.out.println("Random 1-49: " + randomNum);
    
    // round (nearest integer, 4捨5入)
    System.out.println(Math.round(2.4)); // 2
    System.out.println(Math.round(2.5)); // 3
    System.out.println(Math.round(2.6)); // 3
    
    // round to 1 decimal place
    double num = 2.45;
    double rounded1dp = Math.round(num * 10) / 10.0;
    System.out.println(rounded1dp); // 2.5
  }
}