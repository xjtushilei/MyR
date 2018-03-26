package 做题;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1 m=s   s=2s
 * 2 s=s+m
 */
public class SM两步操作 {
    static List<Integer> 可能的值 = new ArrayList<>();

    public static void main(String[] args) {
        get(16, 1, 1, 0);
        System.out.println(可能的值.parallelStream().min(Comparator.comparingInt(a -> a)).get()); //输出可能的次数中最小的那个
    }

    private static void get(int n, int s, int m, int count) {
        if (s > n) {
            return;
        } else if (s == n) {
            可能的值.add(count);
        }
        get(n, 2 * s, s, count + 1); //执行第1步操作 m=s   s=2s
        get(n, s + m, m, count + 1); //执行第2步操作s=s+m   m不变
    }
}
