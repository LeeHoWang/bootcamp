import java.util.concurrent.atomic.AtomicInteger;

public class DemoThreadSafe {
    private int x;

    private AtomicInteger y = new AtomicInteger(0); // solution -> atomic

    // ! "synchronized" means, lock the method (key)
    // The method can be accessed by one thread at the same time only
    public synchronized void addOne() {
        this.x++;
    } 

    public void increment(){
      this.y.getAndIncrement(); // no need know how it solves?
    } 

    // ! synchronized means it is a multithreads

    public int getX() {
        return this.x;
    }

    public int getY(){
      return this.y.get();
    }

    public static void main(String[] args) {  
        System.out.println("start...");

        DemoThreadSafe app = new DemoThreadSafe();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    app.addOne();
                    app.increment();
                }
            }
        };

        Thread worker1 = new Thread(task1);
        worker1.start();

        Thread worker2 = new Thread(task1);
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }

        System.out.println(app.getX()); // 200_000 (OK), but the performance will be impacted
        System.out.println(app.getY());
        System.out.println("end...");
    }
}