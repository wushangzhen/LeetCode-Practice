class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] memo = new int[26];
        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stk = new Stack<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            memo[sc[i] - 'a']--;
            if (visited[sc[i] - 'a']) {
                continue;
            }
            while (!stk.isEmpty() && stk.peek() > sc[i] && memo[stk.peek() - 'a'] > 0) {
                visited[stk.peek() - 'a'] = false;
                stk.pop();
            }
            stk.push(sc[i]);
            visited[sc[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}
