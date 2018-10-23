public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code here
        if (source == null || target == null || source == "" || target == "") {
            return "";
        }
        int[] arr = new int[128];
        char[] tc = target.toCharArray();
        for (int i = 0; i < tc.length; i++) {
            arr[tc[i]]++;
        }
        int left = 0, right = 0;
        char[] sc = source.toCharArray();
        int count = target.length();
        int start = -1;
        int len = Integer.MAX_VALUE;
        while (right < sc.length) {
            if (arr[sc[right]] > 0) {
                count--;
            }
            arr[sc[right]]--;
            right++;
            while (count == 0) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                if (arr[sc[left]] == 0) {
                    count++;
                }
                arr[sc[left]]++;
                left++;
            }
        }
        if (start == -1) {
            return "";
        } else {
            return source.substring(start, start + len);
        }
    }
}
