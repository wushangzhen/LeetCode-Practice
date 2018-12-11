import java.util.*;
public class LCA {
    public static String test(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int max = 0;
        char[] sc = s.toCharArray();
        int n = s.length();
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        while (right < n) {
            if (right != 0 && sc[right] - sc[right - 1] == 1) {
                if (max < right - left) {
                    start = left;
                    end = right;
                }
                max = Math.max(right - left, max);
            } else {
                left = right;
            }
            right++;
        }
        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        String str = "abcdefbcdcdefab";
        System.out.println(LCA.test(str));
    }
}
