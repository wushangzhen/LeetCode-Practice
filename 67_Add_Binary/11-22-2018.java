class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int res = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            sb.append(res % 2);
            carry = res / 2;
            i--;
            j--;
        }
        while (i >= 0) {
            int res = a.charAt(i) - '0' + carry;
            sb.append(res % 2);
            carry = res / 2;
            i--;
        }
        while (j >= 0) {
            int res = b.charAt(j) - '0' + carry;
            sb.append(res % 2);
            carry = res / 2;
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
