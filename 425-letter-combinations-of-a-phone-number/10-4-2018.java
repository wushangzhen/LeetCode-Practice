public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String str = "";
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};
        dfs(result, str, digits, 0, letters);
        return result;
    }
    void dfs(List<String> result, String str, String digit, int index, String[] letters) {
        if (digit.length() == str.length()) {
            result.add(str);
            return;
        }
        int number = digit.charAt(index) - '0';
        for (int i = 0; i < letters[number].length(); i++) {
            dfs(result, str + letters[number].charAt(i), digit, index + 1, letters);
        }
    }
}
