import java.util.Arrays;

public class DemoStringArray {
  public static void main (String[] args) {
    int x = 3;
    int rate = 4;

    int[] arr = new int[3];
    arr[0] = 100_000;
    arr[1] = -2;
    arr[2] = 999;
    // arr[3] = 999;

    // ! print array
    System.out.println(Arrays.toString(arr));

    // reassign 100 into the 2nd box
    arr[1] = 100;
    System.out.println(Arrays.toString(arr)); 

    // String[] -> "Peter", "Steve", "Jenny"
    String[] arrStrings = new String[3]; 
    arrStrings[0] = "Peter";
    arrStrings[1] = "Steve";
    arrStrings[2] = "Jenny";
    System.out.println(Arrays.toString(arrStrings));

    // for loop
    for (int i = 0; i < arrStrings.length; i++) {
      System.out.println(arrStrings[i]);
    }

    double[] prices = new double[4];
    prices[0] = 99.9;
    prices[1] = 10.0;
    prices[2] = 5.4;
    prices[3] = 20.5;

    int[] quantities = new int[4];
    quantities[0] = 3;
    quantities[1] = 10;
    quantities[2] = 5;
    quantities[3] = 4;
    
    // double[] amounts
    double[] amounts = new double[4];
    for (int i = 0; i < amounts.length; i++) {
        amounts[i] = prices[i] * quantities[i];
      }

    // double total amount
    double TotalAmount = 0.0;
    for (int i = 0; i < amounts.length; i++) {
        TotalAmount = TotalAmount + prices[i] * quantities[i];
      }
      System.out.println(TotalAmount);

      char[] chs = new char[] {'b', 'c', 'q'};
      // String + anything -> String
      String result = "";
      for (int i = 0; i < chs.length; i++) {
        result += chs[i];
      }
      System.out.println(result);

      // max
      int[] arr3 = new int[] {10, 100, 4, 200, -3};
      int max = arr3[0];
      for (int i = 0; i < arr3.length; i++) {
        if (max < arr3[i]) {
          max = arr3[i];
        } 
      }
      System.out.println(max);

      // min
      int[] arr4 = new int[] {10, 100, 4, 200, -3};
      int min = arr4[0];
      for (int i = 0; i < arr4.length; i++) {
          if (min > arr4[i]) {
              min = arr4[i];
          }
      }
      System.out.println(min);

      String[] arr5 = new String[] {"Johnny", "Peter", "Jenny", "Tommy"};
      // Count the name strat with J
      int count = 0;
      for (int i = 0; i < arr5.length; i++) {
        if (arr5[i].startsWith("J")) { // charAt(0) = 'J' also ok
          count++;
        }
      }
      System.out.println(count);

      // The total length of all name
      int total = 0;
      for (int i = 0; i < arr5.length; i++) {
        total += arr5[i].length();
      } 
      System.out.println(total);

      // Searching
      // which name containes more than 1 "e"
      for (int i = 0; i < arr5.length; i++) {
        if (arr5[i].indexOf('e') != arr5[i].lastIndexOf('e')) {
          System.out.println(arr5[i]);
        }
      }

      // normal method
      for (int i = 0; i < arr5.length; i++) {
        int countChar = 0;
        for (int j = 0; j < arr5[i].length(); j++) {
          if (arr5[i].charAt(j) == 'e') {
            countChar++;
          }
        }
        if (countChar > 1) {
          System.out.println(arr5[i]);        
        }
      }
  }
}
