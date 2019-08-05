class Solution {
    public List<Integer> partitionLabels(String S) {
        Integer[] memo = new Integer[26];
        int n = S.length();
        for (int i = n - 1; i >= 0; i--) {
            if (memo[S.charAt(i) - 'a'] == null) {
                memo[S.charAt(i) - 'a'] = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            max = Math.max(max, memo[c - 'a']);
            if (max == i) {
                res.add(i - last + 1);
                last = i + 1;
            }
        }
        return res;
    }
}
