class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '+' && i + 1 < sc.length && sc[i + 1] == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }
}
