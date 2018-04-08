package 学习.搜索;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 文件夹的搜索 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("宽搜--------------");
        long startTime = System.currentTimeMillis();
        宽搜("pom.xml", "D:\\IdeaProjects").stream().forEach(System.out::println);
        System.out.println("用时:" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n\n\n宽搜_多线程--------------");
        宽搜_多线程("pom.xml", "D:\\IdeaProjects").stream().forEach(System.out::println);
        System.out.println("用时:" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n\n\n深搜--------------");
        深搜("pom.xml", "D:\\IdeaProjects").stream().forEach(System.out::println);
        System.out.println("用时:" + (System.currentTimeMillis() - startTime));

    }

    private static List<String> 宽搜(String name, String filePath) {
        List<String> result = new ArrayList<>();
        LinkedList<File> q = new LinkedList<>();
        q.add(new File(filePath));

        while (!q.isEmpty()) {
            File f = q.poll();
            if (f.isFile()) {
                if (f.getName().equals(name)) {
                    result.add(f.getAbsolutePath());
                }
            } else if (f.isDirectory()) {
                Collections.addAll(q, f.listFiles());
            }
        }
        return result;
    }

    private static List<String> 宽搜_多线程(String name, String filePath) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 20,
                1500L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        List<String> result = new ArrayList<>();
        LinkedBlockingQueue<File> q = new LinkedBlockingQueue<>();
        class work implements Runnable {
            private File file;

            work(File file) {
                this.file = file;
            }

            public void run() {
                if (file.isFile()) {
                    if (file.getName().equals(name)) {
                        result.add(file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    Collections.addAll(q, file.listFiles());
                }
            }
        }

        q.add(new File(filePath));

        while (!q.isEmpty() || pool.getActiveCount() != 0) {
            File f = q.poll();
            if (f != null) {
                pool.execute(new work(f));
            }
        }
        pool.shutdown();
        return result;
    }

    private static List<String> 深搜(String name, String filePath) {
        List<String> result = new ArrayList<>();
        File f = new File(filePath);
        for (File file : f.listFiles()) {
            if (file.isFile()) {
                if (file.getName().equals(name)) {
                    result.add(file.getAbsolutePath());
                }
            } else if (file.isDirectory()) {
                result.addAll(深搜(name, file.getAbsolutePath()));
            }
        }
        return result;
    }
}
