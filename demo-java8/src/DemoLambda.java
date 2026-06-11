import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class DemoLambda {
  public static void main(String[] args) {
    // Lambda Expression
    // 1. Object has no attribute
    // 2. Interface -> Functional Interface (with one method)

    // Java Built-in Functional Interface
    // ! 1. Function, assume String x
    Function<String, Integer> lengthFormula = x -> x.length();
    System.out.println(lengthFormula.apply("hello")); // 5

    BiFunction<String, String, Integer> totallength = (s1, s2) -> s1.length() + s2.length();
    System.out.println(totallength.apply("abc", "world")); // 8

    // ! 2. BiFunction
    // name, age
    BiFunction<String, Integer, Cat> createCat = (name, age) -> new Cat(name, age);
    Cat myCat = createCat.apply("Whiskers", 3);
    System.out.println(myCat); // Cat{name='Whiskers', age=3}

    SuperFunction<Double, Double, Double, Double> volumeFormula = (length, width, height) -> {
      BigDecimal volume = BigDecimal.valueOf(length)
                        .multiply(BigDecimal.valueOf(width))
                        .multiply(BigDecimal.valueOf(height));
      return volume.doubleValue();
    };
    
    System.out.println(volumeFormula.apply(9.0, (double) 4l, 3602.0));

    // ! 3. Predicate 
    Predicate<Integer> elderlyFormula = age -> age > 65;
    System.out.println(elderlyFormula.test(66));

    Predicate<Person> adultFormula = person -> person.getAge() >= 18;
    System.out.println(adultFormula.test(new Person(18)));
    System.out.println(adultFormula.test(new Person(17)));

    // ! 4. BiPredicate -> Two input -> return Boolean
    BiPredicate<Double, Double> overweightFormula = (height, weight) -> {
      BigDecimal heightSquare = BigDecimal.valueOf(height)
                        .multiply(BigDecimal.valueOf(height));
      BigDecimal bmi = BigDecimal.valueOf(weight)
                        .divide(heightSquare, 2, RoundingMode.HALF_DOWN);
      return bmi.doubleValue() > 25.0;  
    };
    System.out.println(overweightFormula.test(1.7, 80.0));
    System.out.println(overweightFormula.test(1.7, 60.0));

    // ! 5. Consumer -> 1 input -> void
    Consumer<DemoLambda.Cat> printCatName = cat -> System.out.println(cat.age);
    printCatName.accept(new Cat("John", 29));

    List<String> names = new ArrayList<>();
    names.add("Mary");
    names.add("Steven");
    for (String name : names) {
      System.out.println(name);
    }

    names.forEach(name -> System.out.println(name)); // same when only print the name

    // ! 6. Supplier -> No Input -> One Output
    Supplier<Integer> markSixGenerator = () -> new Random().nextInt(49) + 1; 
    System.out.println(markSixGenerator.get());

    // ! UnaryOperator, Binary Operator
    // UnaryOperator<T> => Function<T,T>
    UnaryOperator<String> upperCase = s -> s.toUpperCase();
    System.out.println(upperCase.apply("ohio"));
    // BinaryOperator<T> => BiFunction<T, T, T>
    BinaryOperator<Integer> area = (length, width) -> length * width;
    System.out.println(area.apply(3, 4)); 
    
  }
  
  // Custom Functional Interface (3 inputs)
  public static interface SuperFunction<T, U, V, R> {
    R apply(T t, U u, V v);
  }

  // Cat class
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
  }

  // Person class
  public static class Person {
    private int age;

    public Person(int age) {
      this.age = age;
    }

    public int getAge() {
      return this.age;
    }
  }
  


} 