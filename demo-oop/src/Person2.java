import java.math.BigDecimal;
import java.math.RoundingMode;

public class Person2 {
    // ! 1. Attributes
    private String name;
    private int age;
    private double height;
    private double weight;

    // ! 2. Constructors
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person2(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // ! 3. Getter 方法（你需要加上這些）
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    // ! 4. BMI 計算方法
    public double bmi() {
        if (height <= 0 || weight <= 0) {
            return 0;
        }
        BigDecimal heightSquare = BigDecimal.valueOf(this.height)
                .multiply(BigDecimal.valueOf(this.height));
        
        return BigDecimal.valueOf(this.weight)
                .divide(heightSquare, 2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    // ! 5. main 方法（加上這個才能執行！）
    public static void main(String[] args) {
        // 建立 Person 物件
        Person2 p1 = new Person2("John", 10);
        Person2 p2 = new Person2("Alice", 8, 1.6, 50.0);
        
        // 印出資料
        System.out.println("Name: " + p1.getName());
        System.out.println("Age: " + p1.getAge());
        
        System.out.println("\nName: " + p2.getName());
        System.out.println("Age: " + p2.getAge());
        System.out.println("Height: " + p2.getHeight());
        System.out.println("Weight: " + p2.getWeight());
        System.out.println("BMI: " + p2.bmi());
    }
}