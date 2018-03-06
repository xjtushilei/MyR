package 学习.JUC;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 求数组的和
 */
public class MyForkJoinTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = -6196480027075657316L;

    private static final int THRESHOLD = 5000;

    private long[] array;

    private int low;

    private int high;

    public MyForkJoinTask(long[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (high - low <= THRESHOLD) {
            // 小于阈值则直接计算
            for (int i = low; i < high; i++) {
                sum += array[i];
            }
        } else {
            // 1. 一个大任务分割成两个子任务
            int mid = (low + high) >>> 1;
            MyForkJoinTask left = new MyForkJoinTask(array, low, mid);
            MyForkJoinTask right = new MyForkJoinTask(array, mid + 1, high);

            // 2. 分别计算
            left.fork();
            right.fork();

            // 3. 合并结果
            sum = left.join() + right.join();
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long[] array = genArray(100000000);

//        System.out.println(Arrays.toString(array));

        // 1. 创建任务
        MyForkJoinTask sumTask = new MyForkJoinTask(array, 0, array.length - 1);

        long begin = System.currentTimeMillis();

        // 2. 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 3. 提交任务到线程池
        forkJoinPool.submit(sumTask);

        // 4. 获取结果
        Integer result = sumTask.get();

        long end = System.currentTimeMillis();

        System.out.println(String.format("结果 %s 耗时 %sms", result, end - begin));

        begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        end = System.currentTimeMillis();
        System.out.println(String.format("结果 %s 耗时 %sms", sum, end - begin));
    }

    private static long[] genArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }
}