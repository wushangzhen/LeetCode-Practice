public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        if (originalString == null || originalString.length() == 0) {
            return originalString;
        }
        int n = originalString.length();
        char[] cs = originalString.toCharArray();
        int count = 1;
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0 && cs[i] != cs[i - 1]) {
                sb.append(cs[prev]);
                sb.append(count);
                count = 1;
                prev = i;
                continue;
            }
            if (i != 0 && cs[i] == cs[i - 1]) {
                count++;
            }
        }
        sb.append(cs[prev]);
        sb.append(count);
        String result = sb.toString();
        if (result.length() >= originalString.length()) {
            return originalString;
        }
        return result;
    }
}
