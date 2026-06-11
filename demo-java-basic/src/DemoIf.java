public class DemoIf{
  public static void main(String[] args) {
    char ch = 'k';
    if (ch >= 97) {
      System.out.println("ch is a lowercase letter");
    } else {
      System.out.println("ch is not a lowercase letter");
    }

    // and -> 66
    // or -> ||

    if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
      System.out.println("ch is a letter");
    } else {
      System.out.println("ch is not a letter");
    }

    boolean isCapitalLetter = ch >= 65 && ch <= 90;
    boolean isSmallLetter = ch >= 97 && ch <= 122;
    if (isCapitalLetter||isSmallLetter) {
      System.out.println("ch is a letter");
    } else {
      System.out.println("ch is not a letter");
    }

    int score = 85;
    char grade = 'A';
    if (score >= 90) {
      grade = 'A';
    } else if (score >= 80) {
      grade = 'B';
    } else if (score >= 70) {
      grade = 'C';
    } else if (score >= 60) {
      grade = 'D';
    } else {
      grade = 'F';
    }
    System.out.println("Grade: " + grade);
  }
}