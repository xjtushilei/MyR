package 做题;


import java.util.Scanner;

public class 网易游戏放求得最大值 {
    static int max = -1;
    static int[] 重量;

    // 测试输入： 1 1 1 1 11 12 13 14
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] integerString = scanner.nextLine().split(" ");
        int n = integerString.length / 2;
        int[] 个数 = new int[n];
        重量 = new int[n];
        for (int i = 0; i < n; i++) {
            个数[i] = Integer.valueOf(integerString[i]);
        }
        for (int i = 0; i < n; i++) {
            重量[i] = Integer.valueOf(integerString[n + i]);
        }
        search(个数, 0, 0);
        System.out.println(max);

    }

    public static void search(int[] 个数, int sum, int 当前重量) {
        for (int i = 0; i < 个数.length; i++) {
            if (个数[i] > 0) {
                int sumtemp = sum;
                sum = sum + (当前重量 % 10) * 重量[i];
                if (sum > max) max = sum;
                个数[i]--;
                search(个数, sum, 当前重量 + 重量[i]);
                个数[i]++;
                sum = sumtemp;

            }

        }
    }

    public static void test1() {
        int[] v = {0, 11, 12, 13, 14};
        int[] w = {0, 1, 1, 1, 1};
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
        System.out.println(dp[n][C]);
    }

}
