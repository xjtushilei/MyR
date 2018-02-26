package leetcode;

/**
 * @author shilei
 * @Date 2017/12/6.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _0002_M {


    public static void main(String[] args) {
        _0002_M test = new _0002_M();
        ListNode l1 = new ListNode(1);
        //        l1.next = new ListNode(4);
        //        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //        l2.next.next = new ListNode(4);
        //        l2.next.next.next = new ListNode(1);
        ListNode r = test.addTwoNumbers(l1, l2);
        System.out.print(r.val);
        while (r.next != null) {
            r = r.next;
            System.out.print(r.val);
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode next;
        int sum = l1.val + l2.val;
        int gewei = sum % 10;
        int shiwei = sum / 10;
        result = new ListNode(gewei);
        next = result;
        for (; l1.next != null && l2.next != null; ) {
            l1 = l1.next;
            l2 = l2.next;
            sum = l1.val + l2.val + shiwei;
            gewei = sum % 10;
            shiwei = sum / 10;
            next.next = new ListNode(gewei);
            next = next.next;
        }
        if (l1.next == null && l2.next != null) {
            l2 = l2.next;
            sum = l2.val + shiwei;
            gewei = sum % 10;
            shiwei = sum / 10;
            next.next = new ListNode(gewei);
            next = next.next;
            while (l2.next != null) {
                l2 = l2.next;
                sum = l2.val + shiwei;
                gewei = sum % 10;
                shiwei = sum / 10;
                next.next = new ListNode(gewei);
                next = next.next;
            }
        } else if (l2.next == null && l1.next != null) {
            l1 = l1.next;
            sum = l1.val + shiwei;
            gewei = sum % 10;
            shiwei = sum / 10;
            next.next = new ListNode(gewei);
            next = next.next;
            while (l1.next != null) {
                l1 = l1.next;
                sum = l1.val + shiwei;
                gewei = sum % 10;
                shiwei = sum / 10;
                next.next = new ListNode(gewei);
                next = next.next;
            }
        }
        if (sum > 9) {
            next.next = new ListNode(shiwei);
            next = next.next;
        }


        return result;
    }
}
