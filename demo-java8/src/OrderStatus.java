import java.util.Arrays;
import java.util.Optional;

public enum OrderStatus {
    PAID(1),
    READY_TO_SHIP(2),
    DELIVERED(3);

    private final int index;  // can be final since immutable

    private OrderStatus(int index) {
        this.index = index;
    }

    public int getIndex() {   // made public
        return this.index;
    }

    public static OrderStatus of(int index) {
      // Array -> Stream
      return Arrays.stream(OrderStatus.values())
            .filter(e -> e.getIndex() == index)
            .findFirst() // return Optional<>
            .orElseThrow(() -> new IllegalArgumentException("Invalid Code."));
    }


    public static void main(String[] args) {
      System.out.println(OrderStatus.of(3));
    }
}