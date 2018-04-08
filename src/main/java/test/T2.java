package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class T2 {
    public static void main(String[] args) {
        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
        };
        Executors a;
        ThreadPoolExecutor threadPoolExecutor;
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        List<Object> objects = new ArrayList<>();
        List<String> objectsss = new ArrayList<>();
        objects.addAll(objectsss);
//        get(objectsss);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);

        List<Integer> list = arrayList.subList(2, 5);
        arrayList.set(1, 1111);
        System.out.println(arrayList);
        System.out.println(list);
    }

    public static void get(List<Object> a) {

    }
}
