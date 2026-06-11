import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Bag {
  private List<Ball> balls;
  private Optional<String> name;

  public Bag() {
    this.balls = new ArrayList<>();
  } 

  public boolean add(Ball ball) {
    return this.balls.add(ball);
  }

  public static class Ball {
    private Color color;
    private int number;

    public Ball(Color color, int number) {
      this.color = color;
      this.number = number;
    }

    public Color getColor() {
      return this.color;
    }

    public int getNumber() {
      return this.number;
    }

    public static enum Color {
      BLUE, RED, BLACK, GREEN
    }

    @Override
    public String toString() {
      return "Ball(" + this.color + ", " + this.number + ")";
    }
  }

  // Before Optional, if not found, 1) return null, 2) throw Exception
  // ! The Only correct way to use Optional
  public Ball getBall(Ball.Color targetColor) {
    for (Ball ball : this.balls) {
      if (ball.getColor() == targetColor) {
        return ball;
      }
    } 
    return null;
  }

  // After Optional, if not found, 3) return Optional<>
  // public Optional<Ball> getBall2(Optional<Ball.Color> targetColor) { // ! Wrong design
  public Optional<Ball> getBall2(Ball.Color targetColor) {
    if (targetColor == null) {
      return Optional.empty();
    }
    for (Ball ball : this.balls) {
      if (ball.getColor() == targetColor) {
        return Optional.of(ball);
      }
    }
    return Optional.empty();
  }

  public static void main(String[] args) {
    Bag bag = new Bag();
    bag.add(new Ball(Ball.Color.BLACK, 13));
    bag.add(new Ball(Ball.Color.RED, 10));
    bag.add(new Ball(Ball.Color.BLACK, 10));

    // 方式1：使用 isPresent() 檢查
    Optional<Ball> oBall = bag.getBall2(Ball.Color.BLACK);
    if (oBall.isPresent()) {
      System.out.println(oBall.get());
    } else {
      System.out.println("Ball not found.");
    }


  }
}