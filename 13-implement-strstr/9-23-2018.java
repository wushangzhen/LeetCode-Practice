public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (source == null || source.length() == 0 
            && target == null || target.length() == 0) {
            return 0;
        }
        if (source == null || source.length() == 0) {
            return -1;
        }
        if (target == null || target.length() == 0) {
            return 0;
        }
        int n = source.length();
        int m = target.length();
        char[] sc = source.toCharArray();
        char[] tc = target.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (sc[i] != tc[j]) {
                continue;
            }
            while (i + j < n && j < m) {
                if (sc[i + j] != tc[j]) {
                    break;
                }
                j++;
            }
            if (j == m) {
                return i;
            } else {
                j = 0;
            }
        }
        return -1;
            
    }
}
