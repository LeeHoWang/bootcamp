import java.math.BigDecimal;
import java.math.RoundingMode;

public class DemoBigDecimal {
  public static void main(String[] args) {
    System.out.println(0.1 + 0.2); // 0.30000000000000004 (Python, JS)
    System.out.println(0.3 - 0.2); // 0.09999999999999998
    System.out.println(0.2 * 0.4); // 0.08000000000000002
    System.out.println(0.5 / 0.3); // 1.6666666666666667

    // Solution (BigDecimal)
    // +. -, *, /

    // add() -> return BigDecimal
    // BigDeciaml bd1 =new BigDecimal(0.1); // Wrong usage

    BigDecimal bd1 = new BigDecimal("0.1");
    BigDecimal bd2 = BigDecimal.valueOf(0.2); // recommend approach
    BigDecimal result = bd1.add(bd2);

    System.out.println(result.doubleValue()); // 0.3
    System.out.println(result.floatValue()); // 0.3
    System.out.println(result.intValue()); // 0

    // subtract
    double result2 = BigDecimal.valueOf(0.3) //
                    .subtract(BigDecimal.valueOf(0.2)) //
                    .doubleValue(); //

    System.out.println(result2); // 0.1

    // multiply
    double result3 = BigDecimal.valueOf(0.2) //
                    .multiply(BigDecimal.valueOf(0.4)) //
                    .doubleValue(); //

    System.out.println(result3);

    double result8 = BigDecimal.valueOf(2.25)
    .multiply(BigDecimal.valueOf(0.18)) //
    .setScale(2,RoundingMode.HALF_UP) //
    .doubleValue();
    System.out.println("result8 = " + result8);

    // divide
    // 1. round decimal place
    // 2. non-terminating (10/3)
    double result4 = BigDecimal.valueOf(0.3) //
                    .divide(BigDecimal.valueOf(0.1)) //
                    .doubleValue(); 

    System.out.println(result4); // 3.0

    // round
    // 4.5 / 2.0 -> 2.25 -> round 1 dp (2.3)
    // HALF_UP, HALF means 5, 4捨5入
    // HALF DOWN, 5捨6入
    double result5 = BigDecimal.valueOf(4.5) //
        .divide(BigDecimal.valueOf(2.0), 1, RoundingMode.HALF_UP) //
        .doubleValue();
    System.out.println(result5); // 2.3 (2.25 -> 4捨5入)

    double result6 = BigDecimal.valueOf(4.5) //
        .divide(BigDecimal.valueOf(2.0), 1, RoundingMode.HALF_DOWN) //
        .doubleValue();
    System.out.println(result6); // 2.2 (2.25 -> 5捨6入)

    // 10 / 3
    // ! Non-terminating
    // double result7 = BigDecimal.valueOf(10) //
    //     .divide(BigDecimal.valueOf(3)) //
    //     .doubleValue();

    double result7 = BigDecimal.valueOf(10) //
        .divide(BigDecimal.valueOf(3), 3, RoundingMode.HALF_DOWN) //
        .doubleValue();
    System.out.println(result7);
  }
}
