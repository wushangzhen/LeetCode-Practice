class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] memo = new int[26];
        for (int i = 0; i < S.length(); i++) {
            memo[S.charAt(i) - 'a'] = i;
        }
        int j = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, memo[S.charAt(i) - 'a']);
            if (j == i) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
        
    }
}
