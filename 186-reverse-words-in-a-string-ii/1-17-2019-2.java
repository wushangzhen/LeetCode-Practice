class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        reverse(0, str.length - 1, str);
        int p1 = 0;
        int p2 = 0;
        int n = str.length;
        while (p2 < n) {
            if (str[p2] == ' ') {
                if (str[p1] != ' ') {
                    reverse(p1, p2 - 1, str);
                }
                p1 = p2;
            } else if (str[p1] == ' ') {
                p1 = p2;
            }
            p2++;
        }
        reverse(p1, p2 - 1, str);
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
