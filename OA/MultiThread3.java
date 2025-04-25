package OA;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
callable interface
can get the result of functioning thread
 */
public class MultiThread3 implements Callable<String> {
    public String call(){ //
        return "this is a thread with method 3";
        // Runnable 的 run() 方法没有返回值，call() 方法返回一个结果（这里是字符串）
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft = new FutureTask<>(new MultiThread3());
        Thread t3 = new Thread(ft);
        t3.start();
        String result = ft.get();
        System.out.println(result);
    }

}
