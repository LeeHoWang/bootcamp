// ! Finite Possible Values
// ! Not usually change -> programming change
public enum Color {
  RED('R', "red"), BLUE('B', "blue"), BLACK('K', "black");

  private char value;
  private String description; // red, blue, black

  private Color(char value, String description) {
    this.value = value;
    this.description = description;
  }

  public char getValue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }
}
