class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = i + 1;
        }
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == 'D') {
                int l = i;
                while (i < sc.length && sc[i] == 'D') {
                    i++;
                }
                reverse(res, l, i);
            }
        }
        return res;
    }
    void reverse(int[] res, int l, int r) {
        while (l < r) {
            int temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            l++;
            r--;
        }
    }
}
