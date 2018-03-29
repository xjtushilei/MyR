package 做题;

import java.math.BigInteger;
import java.util.Scanner;

public class 正整数分解使得乘积最大问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 2) System.out.println(1);
        else if (n == 3) System.out.println(2);
        else {
            int 整数3的个数 = n / 3;
            int 整数2的个数 = 0;
            int 除以3的余数 = n % 3;
            if (除以3的余数 == 1) {
                整数3的个数--;
                整数2的个数 = 2;
            } else if (除以3的余数 == 2) {
                整数2的个数 = 1;
            }
            BigInteger bigInteger3 = new BigInteger(String.valueOf(3));
            bigInteger3 = bigInteger3.pow(整数3的个数);
            BigInteger bigInteger2 = new BigInteger(String.valueOf(2));
            bigInteger2 = bigInteger2.pow(整数2的个数);
            System.out.println(bigInteger2.multiply(bigInteger3));
        }
//        t1();
    }


}