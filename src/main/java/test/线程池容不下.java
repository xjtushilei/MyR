package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author scriptshi
 * 2018/4/11
 */
public class 线程池容不下 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.DiscardPolicy());
        while (true) {
            System.out.println(pool.getActiveCount());
            System.out.println(pool.getQueue().size());
            pool.execute(() ->
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
