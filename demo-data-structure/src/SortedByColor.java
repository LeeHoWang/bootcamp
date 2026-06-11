import java.util.Comparator;

public class SortedByColor implements Comparator<Ball>{
  // BLUE -> YELLOW -> RED

  // return b1 (-1)
  // return b2 (1)
  
  @Override
  public int compare(Ball b1, Ball b2) {
    if (b1.getColor() == b2.getColor()) {
      return -1;
    } else {
      if (b1.getColor() == Ball.Color.BLUE) {
        return -1;
      }
      if (b2.getColor() == Ball.Color.BLUE) {
        return 1;
      }
      if (b1.getColor() == Ball.Color.YELLOW) {
        return -1;
      }
      if (b2.getColor() == Ball.Color.YELLOW) {
        return 1;
      }
      return -1;
    }
  }
}
