class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Integer, String> map = new HashMap<Integer, String>() { {
                put(2, "abc");
                put(3, "def");
                put(4, "ghi");
                put(5, "jkl");
                put(6, "mno");
                put(7, "pqrs");
                put(8, "tuv");
                put(9, "wxyz");
        }};
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, "", res, map);
        return res;
    }
    void dfs(String digits, int start, String str, List<String> res, Map<Integer, String> map) {
        if (start == digits.length()) {
            res.add(str);
            return;
        }
        int x = digits.charAt(start) - '0';
        String s = map.get(x);
        for (int i = 0; i < s.length(); i++) {
            dfs(digits, start + 1, str + s.charAt(i), res, map);
        }
    }
}
