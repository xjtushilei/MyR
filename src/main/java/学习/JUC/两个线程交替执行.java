package 学习.JUC;

public class 两个线程交替执行 {


    /**
     * @param args
     */
    public Object lock = new Object();


    public static void main(String[] args) {
        两个线程交替执行 a = new 两个线程交替执行();
        Thread1 t1 = a.new Thread1();
        Thread2 t2 = a.new Thread2();
        t1.start();
        t2.start();
    }


    public class Thread1 extends Thread {
        public void run() {
            while (true) {
                synchronized (lock) {
                    lock.notifyAll();
                    System.out.println("Thread1在运行");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public class Thread2 extends Thread {
        public void run() {
            while (true) {
                synchronized (lock) {
                    lock.notifyAll();
                    System.out.println("Thread2在运行");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}