package 学习;

class PrintNum extends Thread {
    static int num = 1;
    static Object obj = new Object();

    public void run() {
        while (true) {
            //obj can instead of PrintNum.class
            synchronized (obj) {
                /*当前线程活动期间才能唤醒其他等待线程*/
                if (num <= 100) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":"
                            + num);
                    num++;
                } else {
                    break;
                }
                obj.notify();

                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}

public class 多线程交替加法 {
    public static void main(String[] args) {
        Thread t1 = new PrintNum();
        Thread t2 = new PrintNum();

        t1.setName("thread1");
        t2.setName("thread2");
        t1.setPriority(Thread.MAX_PRIORITY);//10
        t2.setPriority(Thread.MIN_PRIORITY);//1

        t1.start();
        t2.start();
    }
}