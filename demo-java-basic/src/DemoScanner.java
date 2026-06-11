import java.util.Scanner;

public class DemoScanner {
  public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    System.out.println("Please input a number.");
    int userInput = s1.nextInt();

    System.out.println("User Input =" + userInput);
  }  
}
