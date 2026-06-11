public enum Direction {
  EAST(1), SOUTH(2), WEST(-1), NORTH(-2),;

  private int value;

  private Direction(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  // Direction.EAST.oppsite() -> WEST
  public Direction oppsite() {
    for (Direction d : Direction.values()) {
      if (d.getValue() * -1 == this.value) {
        return d;
      }
    }
    return null;
  }
}
