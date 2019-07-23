class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        while (n >= 0 || m >= 0) {
            int x = n >= 0 ? a.charAt(n) - '0' : 0;
            int y = m >= 0 ? b.charAt(m) - '0' : 0;
            int sum = carry + x + y;
            carry = sum / 2;
            sb.insert(0, sum % 2);
            n--;c
            m--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
