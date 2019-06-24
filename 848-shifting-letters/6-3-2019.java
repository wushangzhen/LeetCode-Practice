class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26; 
        }
        for (int i = 0; i < shifts.length; i++) {
            sb.setCharAt(i, (char)(((sb.charAt(i) - 'a' + shifts[i]) % 26) + 'a'));
        }
        return sb.toString();
    }
}
