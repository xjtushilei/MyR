import java.util.HashMap;

/**
 * @author shilei
 * @Date 2017/12/6.
 */
public class _00013_E {

    public static void main(String[] args) {
        _00013_E test = new _00013_E();
        System.out.println(test.romanToInt("MCMXCVI"));
        ;
    }

    public int romanToInt(String s) {
        //        I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。
        /**
         * 在构成数字的时候，有下列规则：

         1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；

         2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；

         3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；

         4、正常使用时，连写的数字重复不得超过三次。
         */
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s.length() < 1) {
            return 0;
        }
        int result = 0;
        int sub = map.get(s.charAt(0));
        int lastv = sub;
        for (int i = 1; i < s.length(); ++i) {
            char curc = s.charAt(i);
            int curv = map.get(curc);
            if (curv == lastv) {
                sub += curv;
            } else if (curv < lastv) {
                result += sub;
                sub = curv;
            } else {
                sub = curv - sub;
            }
            lastv = curv;
        }
        result += sub;
        return result;
    }
}
