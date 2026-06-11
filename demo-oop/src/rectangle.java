import java.math.BigDecimal;

public class rectangle {
    private double length;
    private double width;

    public rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // area = length * width
    public double area() {  // 方法名稱是 area（小寫 a）
        return BigDecimal.valueOf(this.length)
            .multiply(BigDecimal.valueOf(this.width))
            .doubleValue();
    }

    public double getlength() {
        return this.length;
    }

    public double getwidth() {
        return this.width;
    }

    public void setlength(double length) {
        this.length = length;
    }

    public void setwidth(double width) {
        this.width = width;
    }

    // main 方法
    public static void main(String[] args) {
        rectangle r1 = new rectangle(5.0, 3.0);
        r1.setwidth(4.0);
        System.out.println(r1.getlength());   // 輸出: 5.0
        System.out.println(r1.getwidth());    // 輸出: 4.0
        System.out.println(r1.area());        // 輸出: 20.0 (改成 area(), 不是 getArea())
    }
}  

