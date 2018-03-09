package 学习.搜索;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 文件夹的搜索 {
    public static void main(String[] args) {

        System.out.println("宽搜--------------");
        宽搜("pom.xml", "D:\\IdeaProjects").stream().forEach(System.out::println);
        System.out.println("深搜--------------");
        深搜("pom.xml", "D:\\IdeaProjects").stream().forEach(System.out::println);
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
