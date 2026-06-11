public enum Currency {
  HKD, USD, CNY;

  public static void main(String[] args) {
    Currency c1 = Currency.HKD;
    System.out.println(c1); // HKD
    System.out.println(c1.name()); // HKD
    System.out.println(c1.ordinal()); // 0
  }
}