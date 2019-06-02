class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String temp = str1.length() > str2.length() ? str2 : str1;
        String res = "";
        for (int i = 1; i <= temp.length(); i++) {
            String t = temp.substring(0, i);
            if (str1.replaceAll(t, "").equals("") && str2.replaceAll(t, "").equals("")) {
                res = t;
            }
        }
        return res;
    }
}
