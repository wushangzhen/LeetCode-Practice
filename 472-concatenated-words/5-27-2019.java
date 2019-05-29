class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b)->(a.length() - b.length()));
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], set)) {
                res.add(words[i]);
            }
            set.add(words[i]);
        }
        return res;
    }
    boolean canForm(String t, Set<String> set) {
        if (set.size() == 0) {
            return false;
        }
        int n = t.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (set.contains(t.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
