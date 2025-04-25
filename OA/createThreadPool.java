package OA;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class createThreadPool {
    public static void main(String[] args) {
        class Task implements Runnable{
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "业务中");
            }
        }
        Task task = new Task();

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        try{
            for (int i = 0; i < 10; i++) {
                threadPool.execute(task);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            threadPool.shutdown();
        }
    }
}
