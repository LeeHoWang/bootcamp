import java.util.List;
import java.util.Vector;

public class DemoVector {
    private List<String> names;

    public DemoVector() {
        this.names = new Vector<>();
    }

    public void add(String name) {
        this.names.add(name);
    }

    public int size() {
      return this.names.size();
    }

    public static void main(String[] args) throws InterruptedException {
        DemoVector app = new DemoVector();
        
        Runnable task = () -> {
          for (int i = 0; i < 10000; i++){  
          app.add("John");
          }
        };
        
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        
        thread1.start();
        thread2.start();
        
        try { 
          thread1.join();
          thread2.join();
        } catch (InterruptedException e){
        }
        
        System.out.println(app.size());
    }
  
  }
