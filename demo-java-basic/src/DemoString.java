public class DemoString{
  public static void main(String[] args){
    String s = "abc";

    // int, double (Primitive types)

    // String -> (Class, developed by human, high level)
    // Class must have method (工具)
    // ! 1. length -> return the length of the string (return int)

    System.out.println(s.length()); // 3
    s = "hello";
    System.out.println(s.length()); // 5
    
    s = ""; // empty string
    System.out.println(s.length()); // 0
    
    // ! 2. charAt(int index) -> return the character at the given index (return char)
    s = "java";
    System.out.println(s.charAt(0)); // 'j'
    System.out.println(s.charAt(s.length() - 1)); // 'a'

    // ! 3.equals() -> return boolean
    s = "Python";
    System.out.println(s.equals("Python")); // true
    System.out.println("Python".equals(s)); // true

    // ! 4. isEmpty() -> return true if the string is empty, false otherwise
    s = "React";
    System.out.println(s.isEmpty()); // false
    s = "";
    System.out.println(s.isEmpty()); // true

    // ! 5. indexOf(char ch) -> return the index of the first occurrence of the specified character, or -1 if there is no such occurrence
    s = "JavaScript";
    System.out.println(s.indexOf('S')); // 4
    System.out.println(s.indexOf('s')); // 6

    // ! 6. replace(char oldChar, char newChar) -> return a new string resulting from replacing all occurrences of oldChar in this string with newChar
    s = "banana";
    System.out.println(s.replace('a', 'o')); // "bonono"
    
    // these are basic types of methods in String class, there are many more methods available for string manipulation and processing.

    // ! 7.  toUpperCase() / toLowerCase() -> return string
    s = "hello world";
    System.out.println(s.toUpperCase()); // "HELLO WORLD"
    System.out.println(s.toLowerCase()); // "hello world"
    System.out.println(s); // "hello world" (original string is unchanged)

    // ! 8. substring(int beginIndex, int endIndex) -> return a new string that is a substring of this string
    String s4 = "Python";
    System.out.println(s4.substring(0, 5)); // "Python"
    System.out.println(s4.substring(2, 5)); // "tho"
    // System.out.println(s4.substring(10)); 
    // error

    // ! 9. contains -> return boolean
    String s5 = "bootcamp";
    if (s5.contains("oo")) {
      System.out.println("s5 contains \"oo\"");
    } else {
      System.out.println("s5 does not contain \"oo\"");
    }

    if (!s5.contains("xx")) {
      System.out.println("s5 does not contains \"xx\"");
    }

    // ! 10. valueOf (static method) -> return string
    String result = String.valueOf(123);
    System.out.println(result);

    String result2 = String.valueOf(99.99);
    System.out.println(result2);

    String result3 = String.valueOf('c');
    System.out.println(result3);    

    // ! 11. lastIndexOf -> return int
    String s6 = "abcoodefooijk";
    System.out.println(s6.lastIndexOf('o')); // 9
    System.out.println(s6.indexOf('o')); // 3

    // ! 12. trim -> return String (remove the leading and tailing space)
    String s7 = "   Hello world !!! ???  ";
    System.out.println(s7.trim()); // Hello world !!! ???


    // ! 13. isBlank -> boolean
    System.out.println("".isEmpty()); // true
    System.out.println(" ".isEmpty()); // false
    System.out.println("abc".isEmpty()); // false

    System.out.println("".isBlank()); // true
    System.out.println(" ".isBlank()); // true
    System.out.println("abc".isBlank()); // false

    // ! 14. startsWith/ endsWith -> boolean
    System.out.println("Abc".startsWith("A")); // True
  }
}

