public class Solution {
    /**
     * @param n: n
     * @param k: the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int[] f = new int[n];
        int sum = 1;
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            sum = sum * i;
            f[i] = sum; 
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k--;
        for (int i = n; i > 0; i--) {
            int j = k / f[i - 1];
            k = k % f[i - 1];
            sb.append(list.get(j));
            list.remove(j);
        }
        return sb.toString();
    }
}
