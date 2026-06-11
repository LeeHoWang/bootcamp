public class Heros {
  public static final int ARCHER = 0;
  public static final int WARRIOR = 1;
  public static final int MAGE = 2;

  // ! role, level
  // Assume max level = 5
  // row 1: Archer, row 2: Warrior, row 3: Mage
  public static final int[][] MAX_HP = new int[][] { //
      {100, 200, 300, 400, 500}, //
      {150, 300, 450, 600, 750}, //
      {80, 160, 240, 320, 400} //
  };

  public static final int[][] PA = new int[][] { //
      {10, 20, 30, 40, 50}, //
      {15, 30, 45, 60, 75}, //
      {5, 10, 15, 20, 25} //
  };

  public static final int[][] CC = new int[][] { //
      {3, 4, 5, 6, 7}, //
      {3, 4, 5, 6, 7}, //
      {3, 4, 5, 6, 7} //
  };

  public static final int[][] CD = new int[][] { //
      {10, 20, 30, 40, 50}, //
      {15, 30, 45, 60, 75}, //
      {5, 10, 15, 20, 25} //
  };


}
