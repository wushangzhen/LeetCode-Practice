class Solution {
    public String makeLargestSpecial(String S) {
        int count = 0;
        int j = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res.add("1" + makeLargestSpecial(S.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}
