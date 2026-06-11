public class DemoRecursive {
  public static void main(String[] args) {
     System.out.println(pow(3,9));
     System.out.println(sum(104));
     System.out.println(pow2(11, 3));
     System.out.println(sum3(4, 4, 3));
  }

  public static int sum(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  public static int sum2(int n){
    // base case
    if (n <= 1) 
      return n;
    return n + sum2(n-1);
  }

  public static int pow(int base, int idx) {
    int result = 1;
    for (int i = 0; i < idx - 1; i++) {
      result = result * base;
    }
    return result;
  }

  public static int pow2(int base, int idx){
    // base case
    if (idx <= 1)  // avoided a variable
      return base;
    return base * pow2(base, idx - 1);
  }

  // n = 4 -> 
  // 3 + 9 + 27 + 81 

  public static int sum3(int initial, int current, int n) {
    if (n <= 0)
      return 0;
    return current + sum3(initial, current * initial, n - 1) ;
  }


}

// ! Fibonacci Sequence
