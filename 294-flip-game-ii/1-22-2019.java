class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return helper(s);
    }
    boolean helper(String s) {
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '+' && (i + 1) < sc.length && sc[i + 1] == '+') {
                if (!helper(s.substring(0, i) + "--" + s.substring(i + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
