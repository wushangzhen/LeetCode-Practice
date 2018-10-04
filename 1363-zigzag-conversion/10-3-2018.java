public class Solution {
    /**
     * @param s: the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     */
    public String convert(String s, int numRows) {
        // Write your code here
        if (s == null || s.length() == 0 || numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        String[] str = new String[numRows];
        Arrays.fill(str, "");
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int k = numRows * 2 - 2;
            if (i % k < numRows) {
                str[i % k] += sc[i];
            } else {
                str[k - i % k] += sc[i];
            }
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += str[i];
        }
        return result;
    }
}
