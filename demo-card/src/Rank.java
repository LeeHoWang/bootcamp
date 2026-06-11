public enum Rank {
  ACE, TWO, THREE, FOUR, FIVE, 
  SIX, SEVEN, EIGHT, NINE, TEN, 
  JACK, QUEEN, KING;

  public static void main(String[] args) {
    System.out.println(Rank.KING.ordinal());
  }

}