package test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class T2 {
    public static void main(String[] args) {
        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
        };
//        Executors
        ThreadPoolExecutor threadPoolExecutor;
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }
}
