public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> memo = new HashMap<>();
        memo.put('2', "abc");
        memo.put('3', "def");
        memo.put('4', "ghi");
        memo.put('5', "jkl");
        memo.put('6', "mno");
        memo.put('7', "pqrs");
        memo.put('8', "tuv");
        memo.put('9', "wxyz");
        dfs("", 0, digits, res, memo);
        return res;
    }
    void dfs(String str, int start, String digits, 
             List<String> res, Map<Character, String> memo) {
        if (start == digits.length()) {
            res.add(str);
            return;
        }
        String ss = memo.get(digits.charAt(str.length()));
        for (int i = 0; i < ss.length(); i++) {
            dfs(str + ss.charAt(i), start + 1, digits, res, memo);
        }
    }
}
