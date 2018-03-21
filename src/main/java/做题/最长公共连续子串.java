package 做题;

import java.util.Scanner;

public class 最长公共连续子串 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

//        System.out.println(f(1));
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        fff(s1, s2);
//        fff("abcde", "abgde");
    }

    public static void fff(String str1, String str2) {
        int max = 0;
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (i == 0 || j == 0) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }

                if (i > 0 && j > 0 && str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
