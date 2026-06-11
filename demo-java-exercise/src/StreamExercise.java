import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise {
  public static void main(String[] args) {
    // 1. Basic Stream Operations
    // Task: Given a list of integers, use a stream to find all the even numbers, square them, and then
    // sort the result in descending order.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Output: [100, 64, 36, 16, 4]
    List<Integer> result = numbers.stream()
      .filter(n -> n % 2 == 0)
      .map(n -> n * n)
      .sorted((a, b) -> b.compareTo(a))
      .collect(Collectors.toList());
    System.out.println(result);

    // 2. Filtering and Collecting
    // Task: Given a list of names, filter the names that start with "A" and collect them into a list.
    List<String> names =
        Arrays.asList("Alice", "Bob", "Annie", "David", "Alex");
    // Output: [Alice, Annie, Alex]
    List<String> aNames = names.stream()
      .filter(name -> name.startsWith("A"))
      .collect(Collectors.toList());
    System.out.println(aNames);

    // 3. Finding Maximum and Minimum
    // Task: Given a list of integers, find the maximum and minimum values using Streams.
    List<Integer> numbers2 = Arrays.asList(10, 20, 5, 30, 15);
    // Output: Max: 30
    // Output: Min: 5
    int max = numbers2.stream().max((a, b) -> a.compareTo(b)).get();
    int min = numbers2.stream().min((a, b) -> a.compareTo(b)).get();
    System.out.println("Max: " + max);
    System.out.println("Min: " + min);

    // 4. Mapping to a List of Lengths
    // Task: Given a list of strings, map each string to its length and collect the lengths into a
    // List<Integer>
    List<String> words = Arrays.asList("apple", "banana", "pear");
    // Output: [5, 6, 4] (List)
    List<Integer> lengths = words.stream()
      .map(word -> word.length())
      .collect(Collectors.toList());
    System.out.println(lengths);

    // 5. Counting Elements
    // Task: Given a list of strings, count how many strings have a length greater than 3.
    List<String> words2 = Arrays.asList("hi", "hello", "world", "java", "stream");
    // Output: 4
    // count() -> terminal operation -> return long
    long count = words2.stream()
      .filter(word -> word.length() > 3)
      .count();
    System.out.println(count);

    // 6. Filtering and Collecting to a Set
    // Task: Given a list of numbers, filter out all numbers greater than 10 and collect them into a
    // Set.
    List<Integer> numbers3 = Arrays.asList(5, 10, 15, 20, 10, 5);
    // Output: [15, 20]
    Set<Integer> filteredSet = numbers3.stream()
      .filter(n -> n > 10)
      .collect(Collectors.toSet());
    System.out.println(filteredSet);

    // 7. Mapping to a Map (Key-Value Pairs)
    // Task: Given a list of students with their names and scores, map them to a Map<String, Integer>,
    // where the key is the student's name and the value is their score.

    // Create Student Class
    // new Student("Alice", 85)
    // new Student("Bob", 75)

    // Output: {Alice=85, Bob=75}

    // Student class
    class Student {
        private String name;
        private int score;
        
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public String getName() {
            return name;
        }
        
        public int getScore() {
            return score;
        }
    }

    // Solution
    List<Student> students = Arrays.asList(
        new Student("Alice", 85),
        new Student("Bob", 75)
    );

    Map<String, Integer> studentMap = students.stream()
            .collect(Collectors.toMap(
            student -> student.getName(),    // Key mapper: get student's name
            student -> student.getScore()    // Value mapper: get student's score
        ));

    System.out.println(studentMap); // Output: {Alice=85, Bob=75}


    // 8. Filtering and Mapping to a List of Objects
    // Task: Given a list of Employee objects, filter out employees with a salary less than 50,000 and
    // map them to a list of their names.

    // Create Employee Class
    // new Employee("John", 65000)
    // new Employee("Jane", 55000)
    // new Employee("Doe", 40000)

    // Output: [John, Jane]
    class Employee {
      private String name;
      private double salary;
      public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
      }
      public String getName() { return name; }
      public double getSalary() { return salary; }
    }
    
    List<Employee> employees = Arrays.asList(
      new Employee("John", 65000),
      new Employee("Jane", 55000),
      new Employee("Doe", 40000)
    );
    
    List<String> highEarners = employees.stream()
      .filter(emp -> emp.getSalary() >= 50000)
      .map(emp -> emp.getName())
      .collect(Collectors.toList());
    System.out.println(highEarners);

    // 9. Grouping and Collecting to a Map (Group by Age)
    // Task: Given a list of people with their names and ages, group them by age and collect the result
    // into a Map<Integer, List<String>> where the key is the age and the value is a list of names.

    // Create Person Class
    // new Person("Alice", 30),
    // new Person("Bob", 25),
    // new Person("Charlie", 30)

    // Output: {30=[Alice, Charlie], 25=[Bob]} (Map)
    class Person {
      private String name;
      private int age;
      public Person(String name, int age) {
        this.name = name;
        this.age = age;
      }
      public String getName() { return name; }
      public int getAge() { return age; }
    }
    
    List<Person> people = Arrays.asList(
      new Person("Alice", 30),
      new Person("Bob", 25),
      new Person("Charlie", 30)
    );
    
    Map<Integer, List<String>> peopleByAge = people.stream()
      .collect(Collectors.groupingBy(
        person -> person.getAge(),
        Collectors.mapping(person -> person.getName(), Collectors.toList())
      ));
    System.out.println(peopleByAge);

    // ! For Loop

    peopleByAge.clear();
    for (Person p : people) {
      List<String> nameList = peopleByAge.get(p.age);
      if (peopleByAge.get(p.age) == null) {
        List<String> newNameList = new ArrayList<>();
        newNameList.add(p.name);
        peopleByAge.put(p.age, newNameList); 
      } else {
        nameList.add(p.name);
        // q9.put(p.age,nameList)
      }
    } 

    // 10. Partitioning and Collecting to a Map (Partition by Gender)
    // Task: Given a list of Staff with their names and genders, partition them into two groups: male
    // and female, and collect the result into a Map<Boolean, List<Person>>.

    // Create Staff Class
    // new Staff("Alice", Gender.Female)
    // new Staff("Bob", Gender.Male)
    // new Staff("Charlie", Gender.Male)

    // Output: {false=[Alice], true=[Bob, Charlie]} (Map)
    enum Gender { Male, Female }
    
    class Staff {
      private String name;
      private Gender gender;
      public Staff(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
      }
      public String getName() { return name; }
      public Gender getGender() { return gender; }
    }
    
    List<Staff> staffs = Arrays.asList(
      new Staff("Alice", Gender.Female),
      new Staff("Bob", Gender.Male),
      new Staff("Charlie", Gender.Male)
    );
    
    Map<Boolean, List<String>> staffByGender = staffs.stream()
      .collect(Collectors.partitioningBy(
        staff -> staff.getGender() == Gender.Male,
        Collectors.mapping(staff -> staff.getName(), Collectors.toList())
      ));
    System.out.println(staffByGender);

    // 11. Filtering, Mapping, and Collecting to a List
    // Task: Given a list of integers, filter out numbers less than 10, multiply the remaining numbers
    // by 2, and collect the result into a List.
    List<Integer> numbers4 = Arrays.asList(5, 15, 20, 7, 30);
    // Output: [30, 40, 60]
    List<Integer> processed = numbers4.stream()
      .filter(n -> n >= 10)
      .map(n -> n * 2)
      .collect(Collectors.toList());
    System.out.println(processed);

    // 12. Mapping to a Custom Object and Collecting to a List
    // Task: Given a list of names and a constant default value, map each name to a Person object (name
    // and default value for age) and collect the result into a list.
    List<String> nameList = Arrays.asList("Alice", "Bob", "Charlie");
    int defaultAge = 30;
    // Output: [Person(name=Alice, age=30), Person(name=Bob, age=30), Person(name=Charlie, age=30)]
    class Person2 {
      private String name;
      private int age;
      public Person2(String name, int age) {
        this.name = name;
        this.age = age;
      }
      public String toString() {
        return "Person(name=" + name + ", age=" + age + ")";
      }
    }
    
    List<Person2> persons = nameList.stream()
      .map(name -> new Person2(name, defaultAge))
      .collect(Collectors.toList());
    System.out.println(persons);

    // 13. Mapping and Collecting to a Deque
    // Task: Given a list of words, map each word to its uppercase form and collect the result into a
    // Deque.
    List<String> words3 = Arrays.asList("hello", "world", "java");
    // Output: [HELLO, WORLD, JAVA] (Deque)
    Deque<String> upperDeque = words3.stream()
      .map(word -> word.toUpperCase())
      .collect(Collectors.toCollection(ArrayDeque::new));
    System.out.println(upperDeque);

    // 14. Transforming and Collecting to an Array
    // Task: Given a list of integers, square each number and collect the result into an array.
    List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4);
    // Output: [1, 4, 9, 16]
    int[] squaredArray = numbers6.stream()
      .mapToInt(n -> n * n)
      .toArray();
    System.out.println(Arrays.toString(squaredArray));

    // 15. Map and Reduce
    // Task: Given a list of products with their prices, use the map and reduce methods to calculate the
    // total price of all products.
    class Product {
      private String name;
      private double price;
      public Product(String name, double price) {
        this.name = name;
        this.price = price;
      }
      public double getPrice() { return price; }
    }
    
    List<Product> products = Arrays.asList(
      new Product("Book", 10),
      new Product("Pen", 5),
      new Product("Notebook", 7)
    );
    // Output: 22
    double totalPrice = products.stream()
      .map(product -> product.getPrice())
      .reduce(0.0, (sum, price) -> sum + price);
    System.out.println((int) totalPrice);

    // 16. Grouping
    // Task: Given a list of employees with their department names, use groupingBy method to group the
    // employees by department.
    class Worker {
      private String name;
      private String department;
      public Worker(String name, String department) {
        this.name = name;
        this.department = department;
      }
      public String getName() { return name; }
      public String getDepartment() { return department; }
    }
    
    List<Worker> workers = Arrays.asList(
      new Worker("Alice", "HR"),
      new Worker("Bob", "IT"),
      new Worker("Charlie", "HR"),
      new Worker("David", "IT")
    );
    // Output: {HR=[Alice, Charlie], IT=[Bob, David]}
    Map<String, List<String>> workersByDept = workers.stream()
      .collect(Collectors.groupingBy(
        worker -> worker.getDepartment(),
        Collectors.mapping(worker -> worker.getName(), Collectors.toList())
      ));
    System.out.println(workersByDept);

    // 17. Parallel Streams
    // Task: Given a list of numbers, use a parallel stream to calculate the sum of all elements.
    List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Output: 55
    int sum = numbers5.parallelStream()
      .reduce(0, (a, b) -> a + b);
    System.out.println(sum);

    // 18. FlatMap
    // Task: Given a list of lists of numbers, flatten them into a single list and filter only the
    // numbers greater than 5.
    List<List<Integer>> listOfIntegers = Arrays.asList( //
        Arrays.asList(1, 2, 3), //
        Arrays.asList(4, 5, 6), //
        Arrays.asList(7, 8, 9) //
    );
    // Output: [6, 7, 8, 9]
    List<Integer> flattened = listOfIntegers.stream()
      .flatMap(list -> list.stream())
      .filter(n -> n > 5)
      .collect(Collectors.toList());
    System.out.println(flattened);

    // 19. Distinct and Sorting
    // Task: Given a list of strings with some duplicates, remove the duplicates and return the result
    // in alphabetical order.
    List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
    // Output: [apple, banana, grape, orange]
    List<String> uniqueSorted = fruits.stream()
      .distinct()
      .sorted()
      .collect(Collectors.toList());
    System.out.println(uniqueSorted);
    
    // 20. Partitioning By
    // Task: Given a list of Childrens with their scores, partition the Childrens into passing and failing
    // groups (pass if score >= 50).
    
    // Create Children Class
    // new Children("Alice", 45)
    // new Children("Bob", 55)
    // new Children("Charlie", 40)
    // new Children("David", 70)
    
    // Output: {false=[Alice, Charlie], true=[Bob, David]}
    class Children {
      private String name;
      private int score;
      public Children(String name, int score) {
        this.name = name;
        this.score = score;
      }
      public String getName() { return name; }
      public int getScore() { return score; }
    }
    
    List<Children> children = Arrays.asList(
      new Children("Alice", 45),
      new Children("Bob", 55),
      new Children("Charlie", 40),
      new Children("David", 70)
    );
    
    Map<Boolean, List<String>> passFail = children.stream()
      .collect(Collectors.partitioningBy(
        child -> child.getScore() >= 50,
        Collectors.mapping(child -> child.getName(), Collectors.toList())
      ));
    System.out.println(passFail);

    // 21. Joining Strings
    // Task: Given a list of words, join them into a single string separated by commas.
    List<String> languages = Arrays.asList("Java", "Python", "Rust", "R", "Go");
    // Output: "Java, Python, Rust, R, Go"
    String joined = languages.stream()
      .collect(Collectors.joining(", "));
    System.out.println("\"" + joined + "\"");

    // 22. Find First and Any
    // Task: Given a list of integers, find the first number that is divisible by 3.
    List<Integer> ages = Arrays.asList(4, 7, 9, 12, 16, 21);
    // Output: 9
    Optional<Integer> firstDivisibleBy3 = ages.stream()
      .filter(n -> n % 3 == 0)
      .findFirst();
    System.out.println(firstDivisibleBy3.get());

    // 23. Limit and Skip
    // Task: Given a list of numbers, skip the first 3 elements and return the next 5 elements.
    List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Output: [4, 5, 6, 7, 8]
    List<Integer> skipped = elements.stream()
      .skip(3)
      .limit(5)
      .collect(Collectors.toList());
    System.out.println(skipped);
    
    // 24. Peek
    // Task: Given a list of integers, double each element and use the peek method to log the
    // intermediate results to the console.
    List<Integer> amounts = Arrays.asList(1, 2, 3, 4);
    // Intermediate output: 2, 4, 6, 8
    // Final Output: [2, 4, 6, 8]
    List<Integer> doubled = amounts.stream()
      .map(n -> n * 2)
      .peek(n -> System.out.print(n + " "))
      .collect(Collectors.toList());
    System.out.println("\n" + doubled);

    // 25. Optional and Streams
    // Task: Given a list of strings, use Streams to find the first string longer than 4 characters.
    // Handle the case where no such string exists using Optional.
    List<String> animals = Arrays.asList("cat", "tiger", "panda", "dog");
    // Output: Optional[tiger]
    Optional<String> longAnimal = animals.stream()
      .filter(animal -> animal.length() > 4)
      .findFirst();
    System.out.println(longAnimal);

    List<String> animals2 = Arrays.asList("cat", "dog", "bird");
    // Output: Optional.empty
    Optional<String> longAnimal2 = animals2.stream()
      .filter(animal -> animal.length() > 4)
      .findFirst();
    System.out.println(longAnimal2);

    // 26. Custom Collector
    // Task: Create a custom collector that collects the elements of a stream and remove all duplicates
    List<Integer> duplicates = Arrays.asList(2, 1, 2, 3, 4, 3, 5, 5, 6);
    // Output: [1, 2, 3, 4, 5, 6] (Set)
    Set<Integer> uniqueSet = duplicates.stream()
      .collect(Collectors.toSet());
    System.out.println(uniqueSet);

    // 27. String Length Calculation
    // Task: Given a list of strings, calculate the total number of characters in all the strings
    // combined.
    List<String> keywords = Arrays.asList("stream", "filter", "map", "sorted", "collect");
    // Output: 28
    int totalChars = keywords.stream()
      .mapToInt(word -> word.length())
      .sum();
    System.out.println(totalChars);
  }
}