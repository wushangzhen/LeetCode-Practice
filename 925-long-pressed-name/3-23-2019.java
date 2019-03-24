class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        if (typed.length() < name.length()) {
            return false;
        }
        while (j < typed.length()) {
            if (i < name.length() && typed.charAt(j) == name.charAt(i)) {
                i++;
            } else if (j == 0 || typed.charAt(j - 1) != typed.charAt(j)) {
                return false;
            }
            j++;
        }
        return i == name.length();
    }
}
