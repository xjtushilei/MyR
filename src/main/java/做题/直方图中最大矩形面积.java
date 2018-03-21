package 做题;

import java.util.Scanner;
import java.util.Stack;

public class 直方图中最大矩形面积 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(largestRectangleArea(a));
    }

    /**
     * 创建一个空栈
     * 从第一个矩形条开始，对每个矩形条的高度height[i] (i的取值范围是[0,n-1])执行下面两步
     * a) 如果栈为空，或height[i]大于等于栈顶元素，那么将矩形条i压入栈中。
     * b)如果输入的矩形条高度小于栈顶元素高度，那么将栈顶元素在输入数组中的索引tp出栈，然后计算矩形面积。矩形的高为height[tp]，而右边界为i，左边界为当前栈顶元素对应的索引，若栈为空，则宽度就是i。
     * 经过计算后，栈非空，然后将栈中元素逐个弹出，并按照步骤2计算矩形面积，并且更新最大值。
     */
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // 最大矩形面积
        int tp; // 栈顶
        int area_with_top;

        int i = 0;
        int n = height.length;
        while (i < n) {
            if (s.empty() || height[s.peek()] <= height[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area, area_with_top);
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        return max_area;
    }
}
