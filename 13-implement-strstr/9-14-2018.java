public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (source.equals(target)) {
            return 0;
        } 
        if (target == null || target.length() == 0) {
            return 0;
        }
        char[] sc = source.toCharArray(); 
        char[] tc = target.toCharArray(); 
        int j = 0;
        for (int i = 0; i < sc.length; i++) {
            for (j = 0; j < tc.length; j++) {
                if ((i + j) >= sc.length || sc[i + j] != tc[j]) {
                    break;
                }
                if (j == tc.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
