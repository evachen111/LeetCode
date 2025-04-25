package OA;

public class threadYield {
    public static void main(String[] args) {
        class Task1 implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A: "+i);
                }
            }
        }
        class Task2 implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.yield(); //
                    System.out.println("B: "+i);
                }
            }
        }
        Thread t1 = new Thread(new Task2());
        Thread t2 = new Thread(new Task1());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
