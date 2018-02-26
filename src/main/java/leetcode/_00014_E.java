package leetcode;

/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _00014_E {

    public static void main(String[] args) {
        _00014_E test = new _00014_E();
        System.out.println(test.longestCommonPrefix(new String[]{"a", "a", "a", "ab"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < min) {
                min = str.length();
            }
            if (str.length() == 0) {
                return "";
            }
        }
        String xiangsi = "";
        for (int i = 0; i < min; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) {
                    return strs[j].substring(0, i);
                }
            }
            xiangsi = xiangsi + temp;
        }
        return xiangsi;
    }
}
