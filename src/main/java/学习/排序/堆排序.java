package 学习.排序;

import java.util.Arrays;

/**
 * 　堆排序是一种树形选择排序方法，它的特点是：在排序的过程中，将array[0，...，n-1]看成是一颗完全二叉树的顺序存储结构，利用完全二叉树中双亲节点和孩子结点之间的内在关系，在当前无序区中选择关键字最大（最小）的元素。
 * <p>
 * 1. 若array[0，...，n-1]表示一颗完全二叉树的顺序存储模式，则双亲节点指针和孩子结点指针之间的内在关系如下：
 * <p>
 * 　　任意一节点指针 i：父节点：i==0 ? null : (i-1)/2
 * <p>
 * 　　　　　　　　　　  左孩子：2*i + 1
 * <p>
 * 　　　　　　　　　　  右孩子：2*i + 2
 * <p>
 * 2. 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)
 * <p>
 * 　　　　　　① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；
 * <p>
 * 　　　　　　② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；
 * <p>
 * 3. 建立大根堆：
 * <p>
 * 　　n个节点的完全二叉树array[0，...，n-1]，最后一个节点n-1是第(n-1-1)/2个节点的孩子。对第(n-1-1)/2个节点为根的子树调整，使该子树称为堆。
 * <p>
 * 　　对于大根堆，调整方法为：若【根节点的关键字】小于【左右子女中关键字较大者】，则交换。
 * <p>
 * 　　之后向前依次对各节点（(n-2)/2 - 1）~ 0为根的子树进行调整，看该节点值是否大于其左右子节点的值，若不是，将左右子节点中较大值与之交换，交换后可能会破坏下一级堆，于是继续采用上述方法构建下一级的堆，直到以该节点为根的子树构成堆为止。
 * <p>
 * 　　反复利用上述调整堆的方法建堆，直到根节点。
 * <p>
 * 4.堆排序：（大根堆）
 * <p>
 * 　　①将存放在array[0，...，n-1]中的n个元素建成初始堆；
 * <p>
 * 　　②将堆顶元素与堆底元素进行交换，则序列的最大值即已放到正确的位置；
 * <p>
 * 　　③但此时堆被破坏，将堆顶元素向下调整使其继续保持大根堆的性质，再重复第②③步，直到堆中仅剩下一个元素为止。
 * <p>
 * 堆排序算法的性能分析：
 * <p>
 * 　　空间复杂度:o(1)；
 * <p>
 * 　　时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);
 * <p>
 * 　　稳定性：不稳定
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] array = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        buildMaxHeap(array);
        System.out.println(Arrays.toString(heapSort(array)));
    }

    //构建大根堆：将array看成完全二叉树的顺序存储结构
    private static int[] buildMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
        return array;
    }

    //将元素array[k]自下往上逐步调整树形结构
    private static void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length && array[i] < array[i + 1]) {  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //根节点 >=左右子女中关键字较大者，调整结束（包括没有下属的节点）
                break;
            } else {   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }

    //堆排序
    public static int[] heapSort(int[] array) {
        array = buildMaxHeap(array); //初始建堆，array[0]为第一趟值最大的元素
        for (int i = array.length - 1; i > 1; i--) {
            int temp = array[0];  //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0, i);  //整理，将剩余的元素整理成堆
        }
        return array;
    }
}
