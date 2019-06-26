class Solution {
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    int[] getTable(String s) {
        int n = s.length();
        int[] table = new int[n];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(index)) {
                table[i] = table[i - 1] + 1;
                index++;
            } else {
                index = table[i - 1];
                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    index = table[index - 1];
                }
                if (s.charAt(index) == s.charAt(i)) {
                    index++;
                }
                table[i] = index;
            }
        }
        return table;
    }
}
