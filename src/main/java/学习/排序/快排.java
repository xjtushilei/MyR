package 学习.排序;

import java.util.Arrays;

public class 快排 {
    public static void main(String[] args) {
//        int[] list = {34, 3, 53, 2, 23,  7, 14, 10};
//        quicksort(list, 0, list.length - 1);
//        System.out.println(Arrays.toString(list));

        int[] list2 = {34, 3, 53, 2, 23, 7, 14, 10};
        quickSort222(list2, 0, list2.length - 1);
        System.out.println(Arrays.toString(list2));
    }

    public static void quicksort(int[] array, int start, int end) {
        if (start >= end || array == null) {
            return;
        }
        int p = partition(array, start, end);
        quicksort(array, start, p - 1);
        quicksort(array, p + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int tmp = array[start];  //数组的第一个作为中轴
        while (start < end) {
            while (start < end && array[end] > tmp) {
                end--;
            }
            array[start] = array[end]; //比中轴小的记录移到低端
            while (start < end && array[start] < tmp) {
                start++;
            }
            array[end] = array[start]; //比中轴大的记录移到高端
        }
        array[start] = tmp; //中轴记录到尾

        return start;
    }

    public static int[] quickSort222(int[] array, int low, int high) {
        if (low < high) {  //递归跳出的条件
            int mid = partition(array, low, high); //划分，得到枢值所在的下表
            quickSort222(array, low, mid - 1);  //依次对两个子表进行递归排序
            quickSort222(array, mid + 1, high);
        }
        return array;
    }

    //快速排序的划分函数
    public static int partition222(int[] array, int low, int high) {
        int pivot = array[low];  //每次取数组中的第一个元素为基准
        while (low < high) {  //跳出循环的条件
            while (low < high && array[high] > pivot) {  //从右边开始找到第一个小于或等于pivot的值
                high--;
            }
            while (low < high && array[low] < pivot) {   //从左边开始找到第一个大于或等于pivot的值
                low++;
            }
            int temp = array[low];   //交换
            array[low] = array[high];
            array[high] = temp;
            if (low < high && array[low] == pivot && array[high] == pivot) {  //特殊情况
                low++;
            }
        }
        return low;
    }
}
