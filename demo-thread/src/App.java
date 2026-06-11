public class App {
    private int x;

    public synchronized void addOne() {
        this.x++;
    }

    public int getX() {
        return this.x;
    }
 // ! "Run" button -> main thread (CPU + memory allocated) 
 // ! JVM -> main thread -> main method
    public static void main(String[] args) throws InterruptedException{
        System.out.println("start...");

        App app = new App();

        Runnable task1 = new Runnable() {
            @Override
            public void run(){
                for (int i = 0; i < 100000; i++){
                app.addOne();
                }
            }
        };

        Thread worker1 = new Thread(task1);
        worker1.start(); // ! new thread

        Thread worker2 = new Thread(task1);
        worker2.start();

        // Thread.sleep(1000); main thread wait here for 1 second

        worker1.join(); // main thread will stay here, wait until worker1 come back
        worker2.join(); // worker 1 and worker 2 come back...

        System.out.println(app.getX()); 
        // ! Main thread may run this line before worker1 thread
        System.out.println("end...");
    }
}


// ! int x = 3 => x++ ; how it does? => read it is 3, then write it is 4
// ! Thread-safe
// ! Thread -> any write action?