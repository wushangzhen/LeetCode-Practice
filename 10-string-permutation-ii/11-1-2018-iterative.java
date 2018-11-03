public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
     
    // 1 2 5 4 3
    // 12345
    private String nextPer(String str) {
        char[] sc = str.toCharArray();
        int index1 = -1;
        for (int i = sc.length - 1; i >= 0; i--) {
            if (i != sc.length - 1 && sc[i] < sc[i + 1]) {
                index1 = i;
                break;
            }
        }
        if (index1 == -1) {
            reverse(sc, 0);
            return String.valueOf(sc);
        }
        int index2 = 0;
        for (int i = sc.length - 1; i >= 0; i--) {
            if (sc[i] > sc[index1]) {
                index2 = i;
                break;
            }
        }
        swap(index1, index2, sc);
        reverse(sc, index1 + 1);
        return String.valueOf(sc);
    }
    
    void swap(int i, int j, char[] sc) {
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }
    
    void reverse(char[] sc, int index) {
        int left = index;
        int right = sc.length - 1;
        while (left <= right) {
            swap(left, right, sc);
            left++;
            right--;
        }
    }
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        char[] sc = str.toCharArray();
        Arrays.sort(sc);
        String begin = String.valueOf(sc);
        String temp = begin;
        res.add(temp);
        while (!nextPer(temp).equals(begin)) {
            res.add(nextPer(temp));
            temp = nextPer(temp);
        }
        return res;
    }
}
