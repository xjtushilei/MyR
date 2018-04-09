package 学习;

/**
 * @author scriptshi
 * 2018/4/9
 */
public class 生产者消费者模型 {
    public static int count = 10;
    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count <= 0) {
                        count = count + 5;
                        System.out.println("count=count+5");
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count > 0) {
                        count = count - 1;
                        System.out.println("count=count-1");
                    } else {
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        producer.start();
        consumer.start();
    }

}
