public enum Color {
  RED('R', "Red"), GREEN('G', "Green"), BLUE('B', "Blue"), BLACK('K', "Black"), WHITE('W', "White");

  private char value;
  private String description;

  private Color (char value, String description) {
    this.value = value;
    this.description = description;
  }

  public char getValue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static void main(String[] args) {
    Color c1 = Color.RED;
    System.out.println(c1.getValue()); // R
    c1.setDescription("This is red color");
    System.out.println(c1.getDescription()); // This is red color
  }

}
