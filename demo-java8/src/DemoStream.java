import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStream {
  public static void main(String[] args) {
    
    // ! stream() -> Stream Type
    // ! 1. filter() 
    List<User> users = new ArrayList<>();
    users.add(new User("johnchan"));
    users.add(new User("marychan"));
    users.add(new User("oscarwong"));

    // for + if
    // Find user who last name = chan
    List<User> user2 = new LinkedList<>();
    for (User user : users) {
      if (user.getUsername().contains("chan")) {
        user2.add(user);
      }
    }

    List<User> users3 = users.stream()
        .filter(u -> u.getUsername().contains("chan"))
        .collect(Collectors.toList());
    users3.forEach(u -> System.out.println(u.getUsername()));

    List<User> users4 = users.stream()
        .filter(u -> u.getUsername().contains("o") && u.getUsername().length() > 8)
        .collect(Collectors.toList());
    users4.forEach(u -> System.out.println(u.getUsername()));

    List<Integer> integers = new ArrayList<>(List.of(100, 8, 3, -6, 9, -28));
    // divided by 3 and positive value
    List<Integer> result2 = integers.stream()
        .filter(e -> e > 0)
        .filter(e -> e % 3 == 0)
        .collect(Collectors.toList());

    // ! 2. Stream.class -> map() -> change the type of elements
    // List<User> -> List<String>
    List<String> usernames = users.stream() // Stream<User>
        .map(e -> e.getUsername()) // Stream<String>
        .collect(Collectors.toList()); // List<String>

    // Mary, John, Steven
    // age = 2
    List<String> catNames = new ArrayList<>(List.of("John", "Mary", "Steven"));
    List<Cat> cats = catNames.stream()
        .map(e -> new Cat(e, 2))
        .collect(Collectors.toList());
    System.out.println(cats);

    // Find catNames which length > 4, return list of length 
    List<Integer> nameLength = catNames.stream()
        .filter(e -> e.length() > 4)
        .map(e -> e.length())
        .collect(Collectors.toList());

    System.out.println(nameLength);

    // Find catNames which ends with 'n', return the List of String Uppercase ["JOHN", "STEVEN"]
    List<String> Upper = catNames.stream()
        .filter(e -> e.endsWith("n"))
        .map(e -> e.toUpperCase())
        .collect(Collectors.toList());
    System.out.println(Upper);

    // ==========================================
    // UserProfile 範例
    // ==========================================
    List<UserProfile> userProfiles = new ArrayList<>();

    // UserProfile 1: 2個地址, 生日 1988-1-1 (現在 37+ 歲)
    userProfiles.add(new UserProfile(
        List.of(
            new Address("abc", "def"),
            new Address("ijk", "xyz")
        ),
        "johnlau@gmail.com",
        LocalDate.of(1988, 1, 1)
    ));

    // UserProfile 2: 2個地址, 生日 1990-10-1 (現在 34 歲，小於 37)
    userProfiles.add(new UserProfile(
        List.of(
            new Address("aaa", "bbb"),
            new Address("ccc", "ddd")
        ),
        "marychan@gmail.com",
        LocalDate.of(1990, 10, 1)
    ));

    // UserProfile 3: 1個地址, 生日 2000-12-31 (現在 23 歲)
    userProfiles.add(new UserProfile(
        List.of(
            new Address("ppp", "qqq")
        ),
        "leowong@gmail.com",
        LocalDate.of(2000, 12, 31)
    ));

    // UserProfile 4: 2個地址, 生日 1985-5-5 (現在 39 歲，符合)
    userProfiles.add(new UserProfile(
        List.of(
            new Address("xxx", "yyy"),
            new Address("zzz", "www")
        ),
        "peterchan@gmail.com",
        LocalDate.of(1985, 5, 5)
    ));

    // ==========================================
    // 題目：找出 UserProfile 中：
    // 1. addresses 數量 > 1
    // 2. 年齡 > 37 歲
    // 回傳 List<Address>
    // ==========================================
    
    List<Address> resultAddresses = new ArrayList<Address>();

    int year = LocalDate.now().getYear();
    for (UserProfile profile : userProfiles) {
        // Check address count > 1
        if (profile.addresses != null && profile.addresses.size() > 1) {
            // Check age > 37
            if (calculateAge(profile.dob) > 37) {
                // Add all addresses to result list
                for (Address address : profile.addresses) {
                    resultAddresses.add(address);
                }
            }
        }
    }

    System.out.println("\n=== 符合條件的 Addresses ===");
    for (Address address : resultAddresses) {
        System.out.println(address);
    }

    // 預期輸出：
    // Address{line1='abc', line2='def'}
    // Address{line1='ijk', line2='xyz'}
    // Address{line1='xxx', line2='yyy'}
    // Address{line1='zzz', line2='www'}
  
    // ! 4. Count
    // Find the number of user whose age > 37
    long numberOfUsers = userProfiles.stream()
      .filter(e -> LocalDate.now().getYear() - e.dob.getYear() > 37)
      .count();
    
    // ! 5. distinct/ collect(Collectors.toSet())
    List<String> fruits = new ArrayList<>(List.of("Banana", "Apple", "Lemon", "Kiwi")); // Fixed: was "frutis"
    List<String> newFruits = fruits.stream()
      .distinct()
      .collect(Collectors.toList());
    System.out.println(newFruits);

    Set<String> fruits2 = fruits.stream()
                          .collect(Collectors.toSet());
    System.out.println(fruits2);
    
    fruits.add("Lemon");
    fruits.add("Kiwi");

    List<String> fruits3 = fruits.stream() // Fixed: was "fruits 3"
      .sorted()
      .distinct()
      .collect(Collectors.toList());
    System.out.println(fruits3);

    // ! 6. sorted(Comparator)
    List<String> reversedFruits = fruits.stream()
                                  .sorted((s1, s2) -> s1.compareTo(s2) * -1)
                                  .distinct()
                                  .collect(Collectors.toList());
                    System.out.println(reversedFruits);

    // ! 7. limit, anyMatch, max
    List<String> firstThreeFruits = fruits.stream()
    .sorted()
    .distinct()
    .limit(3L)
    .collect(Collectors.toList());
    System.out.println(firstThreeFruits);

    // 1 + 2 + 3 + 4
    Integer totalfruitLength = fruits.stream()
          .distinct()
          .map(e -> e.length())
          .peek(e -> System.out.println("fruit=" + e)) // ! Debug
          .reduce(0, (total, length) -> total + length);
    System.out.println(totalfruitLength);


    boolean hasApple = fruits.stream()
      .anyMatch(e -> "APPLE".equals(e.toUpperCase()));
    System.out.println(hasApple);

    Optional<String> fruit = fruits.stream()
          .max((a,b) -> a.length() > b.length() ? 1 : -1);
    System.out.println(fruit.get());

    // ! Stream
    Stream<Integer> ages = List.of(100, 3, 40).stream();

    Stream<Double> balances = Stream.of(10.3, 100.5, 1500.5);

    // 2 code need 


  }
  

  // 計算年齡的 helper 方法
  public static int calculateAge(LocalDate birthDate) {
    return Period.between(birthDate, LocalDate.now()).getYears();
  }

  // ==========================================
  // UserProfile 類別（修正版）
  // ==========================================
  public static class UserProfile {
    public List<Address> addresses;
    public String email;
    public LocalDate dob;

    public UserProfile(List<Address> addresses, String email, LocalDate dob) {
      this.addresses = addresses;
      this.email = email;
      this.dob = dob;
    }

    @Override
    public String toString() {
      return "UserProfile{" +
          "addresses=" + addresses +
          ", email='" + email + '\'' +
          ", dob=" + dob +
          '}';
    }
  }

  // ==========================================
  // Address 類別（獨立出來，不是 static inner class）
  // ==========================================
  public static class Address {
    public String line1;
    public String line2;

    public Address(String line1, String line2) {
      this.line1 = line1;
      this.line2 = line2;
    }

    @Override
    public String toString() {
      return "Address{line1='" + line1 + "', line2='" + line2 + "'}";
    }
  }

  // ==========================================
  // Cat 類別
  // ==========================================
  public static class Cat {
    private String name;
    private Integer age;

    public Cat(String name, Integer age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Cat{" +
          "name='" + this.name +
          "', age=" + this.age +
          '}';
    }

    public int getAge() {
      return this.age;
    }

    public String getName() {
      return this.name;
    }
  }
}

// ==========================================
// User 類別（需要補上）
// ==========================================
class User {
  private String username;

  public User(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}