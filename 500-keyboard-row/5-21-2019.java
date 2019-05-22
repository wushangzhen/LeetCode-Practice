class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> memo = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                memo.put(c, i);
            }
        }
        List<String> res = new ArrayList<>();
        outer: for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            int index = memo.get(word.toUpperCase().charAt(0));
            for (int i = 1; i < word.length(); i++) {
                if (memo.get(word.toUpperCase().charAt(i)) != index) {
                   continue outer; 
                }
            }
            res.add(word);
        }
        return res.toArray(new String[0]);
    }
}
