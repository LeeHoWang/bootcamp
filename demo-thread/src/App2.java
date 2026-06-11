import java.util.ArrayList;

public class App2 {
    private ArrayList<String> names;

    public App2() {
        this.names = new ArrayList<>();
    }

    public void add(String name) {
        this.names.add(name);
    }

    public int size() {
      return this.names.size();
    }

    public static void main(String[] args) throws InterruptedException {
        App2 app = new App2();
        
        Runnable task = () -> {
          for (int i = 0; i < 10000; i++){  
          app.add("John");
          }
        };
        
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        
        thread1.start();
        thread2.start();
        
        // 等待兩個執行緒完成
        try { 
          thread1.join();
          thread2.join();
        } catch (InterruptedException e){
        }
        
        // 理論上應該要有 200000 個元素
        System.out.println(app.size());
    }
}