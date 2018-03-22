package 做题;


import java.util.Arrays;

/**
 * 某工厂预计明年有A、B、C、D四个新建项目，每个项目的投资额Wk及其投资后的收益Vk如下表所示，投资总额为30万元，如何选择项目才能使总收益最大？
 * int[] v={0,5,12,8,9};
 * int[] w={0,8,15,10,12};
 */
public class 背包问题01 {
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
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("最大收益:" + dp[n][C]);


        //获取路径
        for (int i = n; i >= 1; i--) {
            if (dp[i][C] == dp[i - 1][C]) {
                path[i] = 0;
            } else {
                path[i] = 1;
                C = C - w[i];
            }
        }
//        path[1]=dp[1][C]>0?1:0;

        System.out.println(Arrays.toString(path));
        for (int i = 1; i <= n; i++) {
            if (path[i] == 1) {
                System.out.print(w[i] + "   价值：");
                System.out.println(v[i]);
            }
        }


    }

}
