public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        char[] sc = s.toCharArray();
        int n = sc.length;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (right < n) {
            if (sc[right] == sc[left]) {
                right++;
                count++;
            } else {
                sb.append(sc[left]);
                sb.append(count);
                left = right;
                count = 0;
            }
        }
        
        sb.append(sc[left]);
        sb.append(count);
        String str = sb.toString();
        return str.length() < n ? str : s;
    }
}
