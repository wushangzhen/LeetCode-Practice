class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1 << (c - 'a'));
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
