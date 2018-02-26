package leetcode;

/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _0005_M {
    public static void main(String[] args) {

        _0005_M test = new _0005_M();
        String a = "abaab";
        System.out.println(test.longestPalindrome(a));
    }

    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }
//    private int maxLen = 0;
//    private int start = 0;
//
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//
//        for (int i = 0; i < len - 1; i++) {
//            extendPalindrome(s, i, i);
//            extendPalindrome(s, i, i + 1);
//        }
//        return s.substring(start, maxLen + start);
//    }
//
//    private void extendPalindrome(String s, int j, int k) {
//        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//            j--;
//            k++;
//        }
//        if (maxLen < k - j - 1) {
//            start = j + 1;
//            maxLen = k - j - 1;
//        }
//    }

}
