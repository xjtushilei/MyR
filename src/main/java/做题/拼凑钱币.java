package 做题;

import java.util.Scanner;

public class 拼凑钱币 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        f(n);
//        f(10);
//        f(5);

    }

    //    public static int kind = 0;
//    public static int sum = 0;
//    public static int[] bi = {1, 5, 10, 20, 50, 100};
//
//    public static void f(int n) {
//        if (sum==n){
//            kind++;
//        }
//        for (int i=0;i<bi.length;i++){
//            if (sum+bi[i]>n){
//                return;
//            }
//            sum=sum+bi[i];
//            f(n);
//            sum=sum-bi[i];
//        }
//    }
    public static void f(int n) {
        int[] bi = {1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= bi[i]) {
                    dp[j] = dp[j] + dp[j - bi[i]]; //j值取当前币种和不取当前币种两种情况组合数目之和
                }
            }
        }

        System.out.println(dp[n]);


    }
}
