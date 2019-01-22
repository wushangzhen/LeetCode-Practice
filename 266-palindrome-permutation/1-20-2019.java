class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] memo = new int[256];
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            memo[sc[i]]++;
        }
        int count = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }
}
