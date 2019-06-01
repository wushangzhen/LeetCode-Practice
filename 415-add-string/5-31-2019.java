class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int a = p1 >= 0 ? num1.charAt(p1--) - '0' : 0;
            int b = p2 >= 0 ? num2.charAt(p2--) - '0' : 0;
            int tmp = a + b + carry;
            carry = tmp / 10;
            int digit = tmp % 10;
            sb.insert(0, digit);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
