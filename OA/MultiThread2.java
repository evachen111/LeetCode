package OA;

public class MultiThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("this is a thread with method 2");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MultiThread2()); //runnable target
    }
}
