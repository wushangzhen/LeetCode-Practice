public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i - 1) == ' ' && s.charAt(i) == ' ') {
                continue;
            }
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        String[] strs = s.split(" ");
        int start = 0;
        int end = strs.length - 1;
        while (start < end) {
            String temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;
            start++;
            end--;
        }
        sb.setLength(0);
        for (String str : strs) {
            sb.append(str);
            sb.append(" ");
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
}
