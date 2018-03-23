package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class t1 {
    public static void main(String[] args) {
        List a = new ArrayList(5);
        a.add(1);
        a.add("2");
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(5);
        System.out.println(a);

        LinkedHashMap l = new LinkedHashMap();
        Arrays.stream("fsaxfsa.fasdf".split("//.")).forEach(s -> {
            System.out.println(s);
        });
        Test test = null;
        test.m();
    }
}

class Test {
    public static void m() {
        System.out.println(1);
    }
}
