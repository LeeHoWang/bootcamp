public class String1 {
  private char[] chs;

  public String1(String s) {
    this.chs = s.toCharArray();
  }

  public int length() {
    return this.chs.length;
  }

  public char charAt(int index) {
    return this.chs[index];
  }

  // ! Revise iself
  // ! Stringbuilder version
  public String1 replace1(char from, char to) {
    for (int i = 0; i < this.chs.length; i++) {
      if (chs[i] == from) {
        chs[i] = to;
      }
    }
    return this;
  }

  // ! String version
  public String1 replace2(char from, char to) {
    String s = "";
    for (int i = 0; i < this.chs.length; i++) {
      if (chs[i] == from) {
        s += to;
      } else {
        s += chs[i];
      }
    }
    return new String1(s);
  }

  public String toString() {
    return new String(this.chs);
  }

  // ! Static method (charAt)
  public static char charAt(String1 s, int index) {
    return s.charAt(index);
  }

  public static void main(String[] args) {
    String1 s = new String1("hello");
    System.out.println(s.length());
    System.out.println(s.charAt(0)); //h

    System.out.println(s.replace2('l', 'x')); //hexxo
    System.out.println(s); //hello

    System.out.println(s.replace1('h', 'g')); //gello
    System.out.println(s); //hello
  }
}
