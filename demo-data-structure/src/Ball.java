public class Ball implements Comparable<Ball> {
    private int value;
    private Color color;

    // ! Rule: Yellow -> BLUE -> RED, return smaller value if same color
    // return -1 -> return this
    // return 1 -> return ball

    public Ball(int value, Color color) {  // Fixed: added color parameter
        this.value = value;
        this.color = color;  // Fixed: assign the parameter, not itself
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Ball(" //
                + "value=" + this.value //
                + ", color=" + this.color //
                + ")";
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Ball ball) {
        if (this.color == ball.getColor()) {
            return this.value < ball.getValue() ? -1 : 1;
        } else {
            // Fixed: removed semicolons after if statements
            if (this.color == Color.YELLOW)
                return -1;
            if (ball.getColor() == Color.YELLOW)
                return 1;  // Fixed: changed from -1 to 1
            if (this.color == Color.BLUE)
                return -1;
            if (ball.getColor() == Color.BLUE)
                return 1;
            return -1;
        }
    }

    public Color getColor() {
        return this.color;
    }

    public enum Color {
        RED,    // ordinal 2 (lowest priority)
        YELLOW, // ordinal 0 (highest priority) 
        BLUE;   // ordinal 1 (middle priority)
    }
}