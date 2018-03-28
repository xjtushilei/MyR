package 做题;


import java.util.Arrays;

public class 背包问题_完全背包问题 {
    public static void main(String[] args) {
        int[] v = {0, 5, 12, 8, 9};
        int[] w = {0, 8, 15, 10, 12};
        int[] path = {0, 0, 0, 0, 0};
        int C = 30;
        int n = 4;
        int[][] dp = new int[n + 1][C + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 0; k * w[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * w[i]] + k * v[i]);
                }
            }
        }
        System.out.println("最大收益:" + dp[n][C]);


        //获取路径
        for (int i = n; i >= 1; i--) {
            if (dp[i][C] != dp[i - 1][C]) {
                path[i]++;
                C = C - w[i];
                i++;
            }
        }
//        path[1]=dp[1][C]>0?1:0;

        System.out.println(Arrays.toString(path));
        for (int i = 1; i <= n; i++) {
            if (path[i] == 1) {
                System.out.print(w[i] + "   重量：");
                System.out.println(v[i]);
            }
        }


    }

}
