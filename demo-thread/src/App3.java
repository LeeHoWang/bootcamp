import java.util.HashMap;
import java.util.Map;

public class App3 {
  private Map<Integer, String> map;
  
  public App3() {
    this.map = new HashMap<>(); // ! Linkedlist of entry
  }

  public void put(Integer key, String value){
    this.map.put(key, value);
  }

  public int size(){
    return this.map.size();
  }

  public static void main(String[] args) {
    long before = System.currentTimeMillis();

    App3 app = new App3();

    Runnable task1 = () -> {
      for (int i = 0; i < 1000000; i++){
        app.put(i, "100");
      };
    };

    Runnable task2 = () -> {
      for (int i = 1000; i < 20000000; i++){
        app.put(i, "hello");
      };
    };

    Thread thread1 = new Thread(task1);
    Thread thread2 = new Thread(task2);
    thread1.start();
    thread2.start();
    
    try {
      thread1.join();
      thread2.join();
   } catch (InterruptedException e){

   }


   long after = System.currentTimeMillis();
   System.out.println("Elapsed time=" + (after-before) + "ms");
  //  System.out.println(size);


  }
}
