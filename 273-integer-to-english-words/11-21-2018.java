class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int k = 0;
        String res = "";
        while (num != 0) {
            if (num % 1000 > 0) // this is important because num % 1000 == 0 is another situation that we should jump to another iteration
                res = helper(num % 1000) + THOUSANDS[k] + " " + res;
            num /= 1000;
            k++;
        }
        return res.trim();
    }
    
    String helper(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
                return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
    
}
