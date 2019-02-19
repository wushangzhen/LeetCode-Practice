class Solution {
    public String convert(String s, int numRows) {
        String[] strs = new String[numRows];
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        Arrays.fill(strs, "");
        int n = s.length();
        char[] sc = s.toCharArray();
        int num = numRows + numRows - 2;
        for (int i = 0; i < n; i++) {
            int remainder = i % num;
            if (remainder < numRows) {
                strs[remainder] += sc[i];
            } else {
                strs[numRows - (remainder - numRows + 2)] += sc[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
