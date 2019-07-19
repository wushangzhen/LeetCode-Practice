class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        int[] table = getTable(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                    i--;
                }
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    int[] getTable(String needle) {
        int n = needle.length();
        int[] table = new int[n];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (needle.charAt(i) == needle.charAt(index)) {
                table[i] = table[i - 1] + 1;
                index++;
            } else {
                index = table[i - 1];
                while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
                    index = table[index - 1];
                }
                if (needle.charAt(index) == needle.charAt(i)) {
                    ++index;
                }
                table[i] = index;
            }
        }
        return table;
    }
}
