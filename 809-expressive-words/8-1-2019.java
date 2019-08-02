class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            if (helper(w, S)) {
                count++;
            }
        }
        return count;
    }
    public boolean helper(String w, String S) {
        int i = 0;
        int j = 0;
        int n = w.length();
        int m = S.length();
        while (i < n && j < m) {
            if (w.charAt(i) != S.charAt(j)) {
                return false;
            }
            int len1 = getLength(i, w);
            int len2 = getLength(j, S);
            if (len2 < 3 && len1 != len2 || len2 >= 3 && len1 > len2) {
                return false;
            }
            i += len1;
            j += len2;
        }
        return i == n && j == m;
    }
    public int getLength(int start, String S) {
        int count = 0;
        char c = S.charAt(start);
        while (start < S.length() && S.charAt(start) == c) {
            count++;
            start++;
        }
        return count;
    }
}
