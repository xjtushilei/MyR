/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _0009_E {

    public static void main(String[] args) {
        _0009_E test = new _0009_E();
        System.out.println(test.isPalindrome(1));
        ;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
