package OA;

import java.util.concurrent.*;

public class CustomedThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                10,
                20,
                  0L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try{
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> { //传入一个实现了runnable接口的线程
                    //run()
                    System.out.println(Thread.currentThread().getName() + "业务中");
                });
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
