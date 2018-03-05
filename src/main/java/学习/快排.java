package 学习;

public class 快排 {
    public static void main(String[] args) {
        int[] list = {34, 3, 53, 2, 23, 7, 14, 10};
        quicksort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
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
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] > tmp) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] < tmp) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = tmp;

        return start;
    }
}
