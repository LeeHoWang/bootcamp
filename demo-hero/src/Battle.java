public class Battle<T extends Hero>{
  private T a;
  private T b;

  public Battle(T a, T b){
    this.a = a;
    this.b = b;
  }

  public T fight(T a, T b){
    while (a.getHp() > 0 && b. getHp() > 0) {
      a.deductHp(b.getHp());
      b.deductHp(a.getHp());
    }
    return a.getHp() > 0 ? a : b;
  }



  
}
