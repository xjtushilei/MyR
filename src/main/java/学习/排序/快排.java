package 学习.排序;

import java.util.Arrays;

public class 快排 {
    public static void main(String[] args) {
//        int[] list = {34, 3, 53, 2, 23,  7, 14, 10};
//        quicksort(list, 0, list.length - 1);
//        System.out.println(Arrays.toString(list));

//        int[] list2 = {34, 3, 53, 2, 23, 7, 14, 10};
        int[] list2 = {2, 2, 2, 3, 1};
        quicksort(list2, 0, list2.length - 1);
        System.out.println(Arrays.toString(list2));
    }

    public static void quicksort(int[] array, int start, int end) {
        if (start >= end || array == null) {
            return;
        }
        int p = p(array, start, end);
        quicksort(array, start, p - 1);
        quicksort(array, p + 1, end);
    }

    public static int p(int[] a, int low, int high) {
        int index = low;
        int key = a[low];
        while (high > low) {
            while (high > low && a[low] <= key) {
                low++;
            }
            while (high > low && a[high] >= key) {
                high--;
            }
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }

        int temp = a[low];
        a[low] = a[index];
        a[index] = temp;
        return low;
    }

    public static void quick(int[] a, int low, int high) {
        int index = low;
        int index2 = high;
        int key = a[low];
        while (high > low) {
            while (high > low && a[high] >= key) {
                high--;
            }
            while (high > low && a[low] <= key) {
                low++;
            }
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }

        int temp = a[low];
        a[low] = a[index];
        a[index] = temp;
        quick(a, index, low - 1);
        quick(a, low + 1, index2);
    }
}
