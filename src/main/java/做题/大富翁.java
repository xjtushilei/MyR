package 做题;

import java.util.Scanner;

public class 大富翁 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(f(n));
//        System.out.println(f(1));
    }

    public static int f(int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && n - 4 >= 0 && n - 5 >= 0 && n - 6 >= 0) {
                return f(n - 1) + f(n - 2) + f(n - 3) + f(n - 4) + f(n - 5) + f(n - 6);
            } else if (n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && n - 4 >= 0 && n - 5 >= 0) {
                return f(n - 1) + f(n - 2) + f(n - 3) + f(n - 4) + f(n - 5);
            } else if (n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && n - 4 >= 0) {
                return f(n - 1) + f(n - 2) + f(n - 3) + f(n - 4);
            } else if (n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0) {
                return f(n - 1) + f(n - 2) + f(n - 3);
            } else if (n - 1 >= 0 && n - 2 >= 0) {
                return f(n - 1) + f(n - 2);
            } else {
                return f(n - 1);
            }

        }
    }
}
