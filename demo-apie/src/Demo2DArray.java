public class Demo2DArray {
  public static void main(String[] args) {
    // 1D Array
    int[] arr = new int[] {100, 2000, -4, 9}; // 0-3
    int[] arr2 = new int[] {-3, 100, 200, 900}; // 0-3
    // 2D Array
    
    // 100 2000 -4 9
    // -3, 100, 200, 900

    int[][] arr2d = new int[2][4];
    arr2d[0][0] = 100;
    arr2d[0][1] = 2000;
    arr2d[0][2] = -4;
    arr2d[0][3] = 9;
    arr2d[1][0] = -3;
    arr2d[1][1] = 100;
    arr2d[1][2] = 200;
    arr2d[1][3] = 900;

    // Why do we need 2d array?
    // Assume row = 0 -> Archer
    // Assume column = 0 -> Level 1
    
    // arr2d.length -> row length
    // arr2d[i].length -> column length
    for (int i = 0; i < arr2d.length; i++) { // i=0,1
      for (int j = 0; j < arr2d[i].length; j++) { // j=0,1,2,3
        System.out.println(arr2d[i][j]);
      }
    }

  }
}
