class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++; 
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return helper(mp, target, dp);
    }
    int helper(int[][] mp, String target, Map<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0) {
                    for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = helper(mp, s, dp);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(target, ans == Integer.MAX_VALUE? -1 : ans);
        return dp.get(target);
    }
}
