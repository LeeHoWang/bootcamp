import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DataStructureExercise2 {
  // Exercise 4 成員變數
  private static Deque<String> backStack = new LinkedList<>();
  private static Deque<String> forwardStack = new LinkedList<>();
  private static String currentPage = null;

  public static void main(String[] args) {
    // ========== Exercise 1: Queue Basic Operations ==========
    System.out.println("=== Exercise 1: Queue Basic Operations ===");
    Queue<Integer> q1 = new LinkedList<>();
    q1.addAll(List.of(5, 10, 15, 20, 25));
    System.out.println("Head (peek): " + q1.peek());
    q1.poll();
    q1.poll();
    System.out.println("Remaining queue: " + q1);
    System.out.println("Size: " + q1.size());
    System.out.println();

    // ========== Exercise 2: Queue Simulation ==========
    System.out.println("=== Exercise 2: Queue Simulation ===");
    Queue<String> customers = new LinkedList<>();
    customers.addAll(List.of("Alice", "Bob", "Charlie", "David"));
    customers.remove();
    customers.remove();
    System.out.println("After serving first two: " + customers);
    customers.addAll(List.of("Eva", "Frank"));
    System.out.println("After adding Eva, Frank: " + customers);
    System.out.println("Processing all customers:");
    processQueue(customers);
    System.out.println();

    // ========== Exercise 3: Palindrome Checker ==========
    System.out.println("=== Exercise 3: Palindrome Checker ===");
    System.out.println("level: " + isPalindrome("level"));
    System.out.println("hello: " + isPalindrome("hello"));
    System.out.println("abccba: " + isPalindrome("abccba"));
    System.out.println();

    // ========== Exercise 4: Browser History Simulation ==========
    System.out.println("=== Exercise 4: Browser History ===");
    goTo("google.com");
    goTo("facebook.com");
    goTo("youtube.com");
    goTo("github.com");
    back();
    back();
    forward();
    goTo("instagram.com");
    System.out.println();

    // ========== Exercise 5: Word Frequency Counter ==========
    System.out.println("=== Exercise 5: Word Frequency Counter ===");
    countWordFrequency("apple banana apple orange banana apple");
    System.out.println();

    // ========== Exercise 6: Student Directory ==========
    System.out.println("=== Exercise 6: Student Directory ===");
    HashMap<Integer, Student> studentMap = new HashMap<>();
    studentMap.put(1, new Student(1, "Alice"));
    studentMap.put(2, new Student(2, "Bob"));
    studentMap.put(3, new Student(3, "Charlie"));
    studentMap.put(4, new Student(4, "David"));

    System.out.println("--- 6b: Search by ID ---");
    Student found = searchStudent(studentMap, 2);
    Student notFound = searchStudent(studentMap, 99);

    System.out.println("--- 6c: Remove by ID ---");
    removeStudent(studentMap, 2);
    removeStudent(studentMap, 99);

    System.out.println("--- 6d: Sorted Names ---");
    printStudentsSorted(studentMap);
    System.out.println();

    // ========== Exercise 7: Inverse Mapping ==========
    System.out.println("=== Exercise 7: Inverse Mapping ===");
    HashMap<String, String> countryMap = new HashMap<>();
    countryMap.put("USA", "Washington");
    countryMap.put("France", "Paris");
    countryMap.put("Japan", "Tokyo");
    countryMap.put("India", "Delhi");

    HashMap<String, String> capitalMap = new HashMap<>();
    for (Map.Entry<String, String> entry : countryMap.entrySet()) {
      capitalMap.put(entry.getValue(), entry.getKey());
    }

    System.out.println("Original: " + countryMap);
    System.out.println("Inversed: " + capitalMap);
    System.out.println();

    // ========== Exercise 8: HashMap with Multiple Values ==========
    System.out.println("=== Exercise 8: HashMap with Multiple Values ===");
    HashMap<String, ArrayList<String>> subjects = new HashMap<>();
    subjects.put("Alice", new ArrayList<>(List.of("Math", "Science")));
    subjects.put("Bob", new ArrayList<>(List.of("History")));
    subjects.put("Charlie", new ArrayList<>(List.of("Math", "English")));

    subjects.get("Bob").add("English");

    System.out.println("All students and subjects:");
    for (Map.Entry<String, ArrayList<String>> entry : subjects.entrySet()) {
      System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
    }

    ArrayList<String> mathStudents = getStudentsTakingMath(subjects);
    System.out.println("Students taking Math: " + mathStudents);
  }

  // ========== Exercise 2e ==========
  public static void processQueue(Queue<String> queue) {
    while (!queue.isEmpty()) {
      System.out.println("  Serving: " + queue.poll());
    }
  }

  // ========== Exercise 3a ==========
  public static boolean isPalindrome(String s) {
    Deque<Character> deque = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      deque.addLast(s.charAt(i));
    }
    while (deque.size() > 1) {
      Character first = deque.pollFirst();
      Character last = deque.pollLast();
      if (first != last) {
        return false;
      }
    }
    return true;
  }

  // ========== Exercise 4 ==========
  public static void goTo(String url) {
    if (currentPage != null) {
      backStack.push(currentPage);
    }
    forwardStack.clear();
    currentPage = url;
    System.out.println("Current: " + currentPage);
  }

  public static void back() {
    if (backStack.isEmpty()) {
      System.out.println("No previous page");
    } else {
      forwardStack.push(currentPage);
      currentPage = backStack.pop();
      System.out.println("Current: " + currentPage);
    }
  }

  public static void forward() {
    if (forwardStack.isEmpty()) {
      System.out.println("No next page");
    } else {
      backStack.push(currentPage);
      currentPage = forwardStack.pop();
      System.out.println("Current: " + currentPage);
    }
  }

  // ========== Exercise 5 ==========
  public static void countWordFrequency(String text) {
    String[] words = text.split(" ");
    HashMap<String, Integer> map = new HashMap<>();

    for (String s : words) {
      if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
    }

    System.out.println("Frequency: " + map);

    String mostFrequentWord = null;
    int highestCount = 0;

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > highestCount) {
        highestCount = entry.getValue();
        mostFrequentWord = entry.getKey();
      }
    }

    System.out.println("Highest frequency: " + mostFrequentWord + " (" + highestCount + " times)");
  }

  // ========== Exercise 6b ==========
  public static Student searchStudent(HashMap<Integer, Student> map, int id) {
    Student result = map.get(id);
    if (result == null) {
      System.out.println("Student with ID " + id + " not found");
      return null;
    } else {
      System.out.println("Found: " + result.getName());
      return result;
    }
  }

  // ========== Exercise 6c ==========
  public static void removeStudent(HashMap<Integer, Student> map, int id) {
    if (map.containsKey(id)) {
      Student removed = map.remove(id);
      System.out.println("Removed: " + removed.getName());
    } else {
      System.out.println("Student with ID " + id + " not found");
    }
  }

  // ========== Exercise 6d ==========
  public static void printStudentsSorted(HashMap<Integer, Student> map) {
    ArrayList<String> names = new ArrayList<>();
    for (Student s : map.values()) {
      names.add(s.getName());
    }
    Collections.sort(names);
    System.out.println("Students: " + names);
  }

  // ========== Exercise 8e ==========
  public static ArrayList<String> getStudentsTakingMath(HashMap<String, ArrayList<String>> map) {
    ArrayList<String> result = new ArrayList<>();
    for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
      if (entry.getValue().contains("Math")) {
        result.add(entry.getKey());
      }
    }
    return result;
  }

  // ========== Student Class ==========
  public static class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Student(id=" + id + ", name=" + name + ")";
    }
  }
}