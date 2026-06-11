import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {
  public static void main(String[] args) {
    // 1. Checked Exception (Must try to recover) -> risk unavoidable -> find name.pdf in c/abc/folder. 
    // All Built-in Exceptions extend Exception.class -> checked Exception

    // 2. Unchecked Exception (Don't have to recover)
    int[] arr = new int[3]; // 0,1,2
    // System.out.println(arr[3]); // ArrayIndexOutOfBoundsException

    String s = "hello";
    // System.out.println(s.charAt(5)); // StringIndexOutOfBoundsException

    int index = 5;

    // Programming -> check -> avoidable
    // bug -> fix
    if (index < s.length()) {
      s.charAt(index);
    }

    // try -> s.charAt()
    try {
      s.charAt(index);
    } catch (StringIndexOutOfBoundsException ex) {
      // ! Never use try for charAt, because StringIndexOutOfBoundsException is avoidable
    }
    
    String k1 = "hello";
    // 1. avoidable -> check ASCII

    // 2. Recover process
    Integer k2 = null;
    try {
      k2 = Integer.valueOf(k1);
      System.out.println("Completed. k2=" + k2);
    } catch(NumberFormatException ex) { // ! Recover
      System.out.println(ex.getMessage());
      k2 = -1;
    }
    System.out.println("Continue");

    // ! Null Point Exception (NPE)
    // avoidabable -> null checking 
    String name = null;
    boolean isStartwithJ = name != null && name.startsWith("J"); // Null Check // ? what is this format?
    System.out.println(isStartwithJ);

    System.out.println(isValid("leowong@gmail.com"));
    // System.out.println(isValid(null));
  } 

  public static boolean isValid(String email) {
    if (email != null) {
      return email.contains("@");
    }
    throw new IllegalArgumentException("email should not be null"); // unchecked exception
  }

  public int getInteger(String filePath) {
    try{
      Scanner scanner = new Scanner(new File(filePath));
      return Integer.valueOf(scanner.nextLine());
    } catch (FileNotFoundException e) {
      throw new FileServiceException("File Not Found.");
     }
  }

}
// ! bug is should avoid but not avoid