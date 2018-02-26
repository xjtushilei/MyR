package sword2offer;

public class VertifySequenceOfBST {
    public static void main(String[] args) {
        System.out.println(VertifySequenceOfBST.vertify(new int[]{5, 7, 6, 9, 11, 10, 8}, 0, 6));
        System.out.println(VertifySequenceOfBST.vertify(new int[]{7, 4, 6, 5}, 0, 3));

    }

    static boolean vertify(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[end];

        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }


        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > start) {
            left = vertify(sequence, start, i - 1);
        }

        boolean right = true;
        if (i < end) {
            right = vertify(sequence, i, end - 1);
        }

        return left && right;

    }
}
