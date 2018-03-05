package 学习.排序;

import java.util.Arrays;

public class 冒泡 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 8, 9, 0, 4, 5, 1, 6, 8, 7};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void sort(int[] array) {
        int n = array.length;
        boolean flag = true;
        for (int i = 0; i < n - 1 && flag; i++) {
            flag = false;
            for (int j = i + 1; j < n; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
        }
    }
}
