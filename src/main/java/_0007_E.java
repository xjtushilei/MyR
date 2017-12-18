/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _0007_E {

    public static void main(String[] args) {
        _0007_E test = new _0007_E();
        System.out.println(test.reverse(-1));
        ;
    }

    public int reverse(int x) {
        StringBuilder b = new StringBuilder();
        b.append(x);
        b.reverse();
        try {
            return b.charAt(b.length() - 1) == '-' ? -Integer.valueOf(b.toString().replace("-", "")) : Integer.valueOf(b.toString());
        } catch (Exception e) {
            return 0;
        }


    }
}
