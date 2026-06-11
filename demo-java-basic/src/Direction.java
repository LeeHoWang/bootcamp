public enum Direction {
    EAST(1), SOUTH(2), WEST(-1), NORTH(-2);

    private int value;
        
    private Direction (int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    // Direction.EAST.opposite() -> WEST
    public Direction opposite() { 
      for (Direction d  : Direction.values()) {
        if (d.getValue() * -1 == this.value) {
          return d;
        }
       }
       return null; // should never reach here
      }
    
    public static void main(String[] args) {
        Direction d = Direction.NORTH;
        System.out.println(d.opposite()); // SOUTH
    }
}