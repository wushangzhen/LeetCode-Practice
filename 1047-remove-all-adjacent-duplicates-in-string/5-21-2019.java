class Solution {
    public String removeDuplicates(String S) {
        char[] stack = S.toCharArray();
        int i = 0;
        for (int j = 0; j < S.length(); j++) {
            if (i > 0 && stack[i - 1] == S.charAt(j)) {
                i--;
            } else {
                stack[i++] = S.charAt(j);
            }
        }
        return new String(stack, 0, i);
    }
}
