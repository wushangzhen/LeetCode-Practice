class Solution {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int bal = 0;
        for (char c : S.toCharArray()) {
            bal += (c == '(') ? 1 : -1;
            if (bal == -1) {
                bal++;
                ans++;
            }
        }
        return ans + bal;
    }
}
