class Solution {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] temp = new int[26];
            for (char c : str.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] != Integer.MAX_VALUE) {
                while (count[i] != 0) {
                    res.add("" + (char)(i + 'a'));
                    count[i]--;
                }
            }
        }
        return res;
    }
}
