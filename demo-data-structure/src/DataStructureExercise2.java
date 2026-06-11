import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DataStructureExercise2 {
  public static void main(String[] args) {
    // Test the palindrome checker
    System.out.println(isPalindrome("racecar"));    // true
    System.out.println(isPalindrome("hello"));      // false
    System.out.println(isPalindrome("madam"));      // true
    
    // Ex 7 - inverse mapping (capital -> country)
    HashMap<String, String> countryMap = new HashMap<>();
    countryMap.put("USA", "Washington");
    countryMap.put("France", "Paris");
    countryMap.put("Japan", "Tokyo");
    countryMap.put("India", "Delhi");

    HashMap<String, String> capitalMap = new HashMap<>();
    for (Map.Entry<String, String> entry : countryMap.entrySet()) {
      capitalMap.put(entry.getValue(), entry.getKey());
    }
    System.out.println(capitalMap);
  }  // <-- 關閉 main 方法的大括號

  public static boolean isPalindrome(String word) {
    Deque<Character> characters = new LinkedList<>();
    
    // Add each character to the deque
    for (char c : word.toCharArray()) {
      characters.addLast(c);
    }
    
    // Compare using pollFirst() and pollLast()
    while (characters.size()  > 1) {
      char first = characters.pollFirst();  // Retrieves and removes first element
      char last = characters.pollLast();    // Retrieves and removes last element
      
      if (first != last) {
        return false;  // Not a palindrome
      }
    }
    
    return true;  // Is a palindrome
  }  // <-- 關閉 isPalindrome 方法的大括號

}  // <-- 關閉 class 的大括號