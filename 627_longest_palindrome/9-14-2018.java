public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (!hashMap.containsKey(sc[i])) {
                hashMap.put(sc[i], 0);
            }
            int value = hashMap.get(sc[i]);
            hashMap.put(sc[i], value + 1);
        }
        int sum = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                sum += entry.getValue();
            } else {
                sum += entry.getValue() / 2 * 2;
                flag = true;
            }
        }
        if (flag) {
            sum++;
        }
        return sum;
    }
}
