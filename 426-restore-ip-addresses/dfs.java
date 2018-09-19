public class Solution {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        // write your code here
        List<String> result = new ArrayList<String>();
        helper(s, "", 0, 0, result);
        return result;
    }
    public void helper(String s, String str, int start, int part, List<String> result) {
        if (start == s.length() && part == 4) {
            str = str.substring(0, str.length() - 1);
            result.add(str);
            return;
        }
        for (int ch = 1; ch <= 3 && start + ch <= s.length(); ch++) {
            String tempStr = s.substring(start, start + ch);
            if (ch > 1 && tempStr.startsWith("0")) {
               continue; 
            }
            int num = Integer.parseInt(tempStr);
            if (num >= 0 && num < 256 && part <= 3) {
                helper(s, str + tempStr + ".", start + ch, part + 1, result);
            } else {
                return;
            }
        }
    }
}
