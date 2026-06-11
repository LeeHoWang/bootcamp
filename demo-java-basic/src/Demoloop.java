package src;
public class Demoloop {
  public static void main(String[] args) {
    int x = 3;

    for (int i = 0; i < 3; i++) {
      System.out.println("hello"); 
      // for loop is do checking the condition before executing the body of the loop
    }
  // Step 1: i = 0
  // Step 2: i < 3 ?
  // Step 3: yes, print "hello"
  // Step 4: i = 1
  // Step 5: i < 3 ?
  // Step 6: yes, print "hello"
  // Step 7: i = 2
  // Step 8: i < 3 ?
  // Step 9: yes, print "hello"
  // Step 10: i = 3
  // Step 11: i < 3 ?
  // Step 12: no, exit the loop

  int y = 3;
  for (int i = 0; i < 3; i++) {
    y = y * 3;
  }
  System.out.println(y); // 81

  for (int i = 0; i < 10; i++) {
    // print only odd number
    if (i % 2 == 1) {
      System.out.println(i);
      }
    }

  for (int i = 0; i < 26; i++) {
    // print a - z, ascii code of a is 97
    // ! learn how to convert int to char
    char c = (char) (97 + i); 
    // if i > 60000, it will overflow and print some weird character
    System.out.println(c);
  }
  
  // String
  // print index, if char value is l or w or o
  String s = "helloworld";
  for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (c == 'l' || c == 'w' || c == 'o') {
      System.out.println(i);
    }
  }

  // 0 - 99, print value divisible by 3 and 7
  for (int i = 0; i < 100; i++) {
    if (i % 3 == 0 && i % 7 == 0) {
      System.out.println(i);
    } 
  }

  // check if "n" exists
  // if yes, print "Character n exists"
  // if no, print "Character n does not exist"
  String s2 = "JavaPythonHtml";
  boolean found = false;
  for (int i = 0; i < s2.length(); i++) {
    if (s2.charAt(i) == 'n') {
      found = true;
      break;
    }
  }
  if (found) {
    System.out.println("Character n exists");
  } else {
    System.out.println("Character n does not exist");
  }




}
}
