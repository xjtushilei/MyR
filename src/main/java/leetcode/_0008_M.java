package leetcode;

/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _0008_M {
    public static void main(String[] args) {
        String a = "-fsdfa+1234fsd234sdfs13";
        _0008_M test = new _0008_M();
        System.out.println(test.myAtoi(a));
    }


    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                    newstr += str.charAt(i);
                } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    newstr += str.charAt(i);
                } else {
                    return 0;
                }
                continue;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                newstr += str.charAt(i);
            } else {
                break;
            }
        }
        if (newstr.length() == 1 && (newstr.equals("-") || newstr.equals("+"))) {
            return 0;
        }
        try {
            return Integer.valueOf(newstr);

        } catch (NumberFormatException e) {
            if (newstr.startsWith("-")) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }

    }

}
