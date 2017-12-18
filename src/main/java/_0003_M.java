
/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _0003_M {
    public static void main(String[] args) {
        String a = "gaaqfeqlqky";
        _0003_M test = new _0003_M();
        System.out.println(test.lengthOfLongestSubstring(a));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = -1;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            temp = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (!temp.toString().contains(s.charAt(j) + "")) {
                    temp.append(s.charAt(j));
                } else {
                    if (n < temp.length()) {
                        n = temp.length();
                    }
                    temp = new StringBuilder(s.charAt(j) + "");
                    j = j + n - 1;
                }
            }
            if (n < temp.length()) {
                n = temp.length();
            }
        }
        if (n < temp.length()) {
            n = temp.length();
        }
        return n;
    }


}
