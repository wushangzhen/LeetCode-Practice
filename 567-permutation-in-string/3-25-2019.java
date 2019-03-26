class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        int[] memo = new int[26];
        for (int i = 0; i < sc1.length; i++) {
            memo[sc1[i] - 'a']++;
        }
        int count = sc1.length;
        int n = sc2.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && right - left != sc1.length) {
                if (memo[sc2[right] - 'a'] >= 1) {
                    count--;
                }
                memo[sc2[right++] - 'a']--;
            }
            if (count == 0) {
                return true;
            }
            if (memo[sc2[left] - 'a'] >= 0) {
                count++;
            }
            memo[sc2[left++] - 'a']++;
        }
        return false;  
    }
}
