class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        reverse(0, str.length - 1, str);
        int p1 = 0;
        int p2 = 0;
        int n = str.length;
        while (p1 < n) {
            while (p1 < n && str[p1] == ' ') {
                p1++;
            }
            if (p1 <= n) {
                p2 = p1;
                while (p2 < n && str[p2] != ' ') {
                    p2++;
                }
                if (p2 <= n) {
                    reverse(p1, p2 - 1, str);
                }
                p1 = p2;
            }
        }
        return;
    }
    void reverse(int start, int end, char[] str) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
