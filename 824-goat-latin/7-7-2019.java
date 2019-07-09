class Solution {
    public String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (check(strs[i])) {
                strs[i] += "ma";
                for (int j = 0; j < i + 1; j++) {
                    strs[i] += "a";
                }
                sb.append(strs[i]);
                sb.append(" ");
            } else {
                String newStr = strs[i].substring(1);
                newStr += strs[i].charAt(0);
                newStr += "ma";
                for (int j = 0; j < i + 1; j++) {
                    newStr += "a";
                }
                sb.append(newStr);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
    boolean check(String str) {
        return str.startsWith("a") || str.startsWith("A") 
            || str.startsWith("i") || str.startsWith("I")
            || str.startsWith("u") || str.startsWith("U")
           || str.startsWith("e") || str.startsWith("E")
           || str.startsWith("o") || str.startsWith("O");
    }
}
