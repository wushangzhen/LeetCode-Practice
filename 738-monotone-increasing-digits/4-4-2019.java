class Solution {
    public int monotoneIncreasingDigits(int N) {
        String ans = "";
        String s = String.valueOf(N);
        int n = s.length();
        search: for (int i = 0; i < n; i++) {
            for (char j = '1'; j <= '9'; j++) {
                if (s.compareTo(ans + repeat(j, n - i)) < 0) {
                    ans += (char)(j - 1);
                    continue search;
                }
            }
            ans += "9";
        }
        return Integer.parseInt(ans);
    }
    String repeat(char c, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
