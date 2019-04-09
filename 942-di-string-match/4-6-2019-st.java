class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int lo = 0;
        int hi = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') { // 保证当前位最大或者最小值即可，双指针
                ans[i] = lo++;
            } else {
                ans[i] = hi--;
            }
        }
        ans[n] = hi;
        return ans;
    }
}
