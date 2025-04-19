package OA;

// extend class Thread
public class MultiThread extends Thread{
    @Override
    public void run() {
        System.out.println("this is one thread with method 1");
    }

    public static void main(String[] args) {
        MultiThread t1 = new MultiThread();
        t1.start(); // start 1 thread

        Thread t2 = new Thread(()->{
            System.out.println("this is a thread with method 2");
        });
    }
}
