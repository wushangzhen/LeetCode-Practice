class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] memo = new int[26];
        for (char c : magazine.toCharArray()) {
            memo[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (memo[c - 'a'] == 0) {
                return false;
            }
            memo[c - 'a']--;
        }
        return true;
    }
}
