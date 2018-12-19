public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        if (str.length() == 0) {
            res.add("");
            return res;
        }
        res.add(str);
        String temp = nextPermutation(str);
        while (!temp.equals(str)) {
            res.add(temp);
            temp = nextPermutation(temp);
        }
        return res;
    }
    // 1 2 5 4 3
    // 1 3 2 4 5
    String nextPermutation(String str) {
        char[] sc = str.toCharArray();
        int n = sc.length;
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
    void swap(int x, int y, char[] sc) {
        char temp = sc[x];
        sc[x] = sc[y];
        sc[y] = temp;
    }
    void reverse(char[] sc, int start) {
        int end = sc.length - 1;
        while (start < end) {
            swap(start, end, sc);
            start++;
            end--;
        }
    }
}
