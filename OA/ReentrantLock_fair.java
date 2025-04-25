package OA;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_fair {

    private static int num = 0;
    private static ReentrantLock fairlock = new ReentrantLock(true);
    public static class T extends Thread {
        public T(String name) {
            super(name);
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++){
                fairlock.lock();
                try{
                    System.out.println(this.getName() + " gets the lock");
                }
                finally {
                    fairlock.unlock();;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        T t2 = new T("t2");
        T t3 = new T("t3");
        t1.start();
//        t1.sleep(1000);
        //Thread.sleep(1000);
        t2.start();
        t3.start();

    }
}
