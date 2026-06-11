import java.util.Stack;

public class DemoStack {
    private Stack<String> names;

    public DemoStack() {
        this.names = new Stack<>();
    }

    public void push(String name) {
        this.names.push(name); // ! synchronized if other code need 
    }

    public int size() {
      return this.names.size();
    }

    public static void main(String[] args) throws InterruptedException {
        DemoStack app = new DemoStack();
        
        Runnable task = () -> {
          for (int i = 0; i < 10000; i++){  
          app.push("John"); // read first, then push
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
// 2026-06-11