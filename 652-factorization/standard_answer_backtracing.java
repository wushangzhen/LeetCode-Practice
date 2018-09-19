public class Solution {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    void helper(List<List<Integer>> result, 
                ArrayList<Integer> item,
                int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
                return;
            }
        }                
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
        if (n >= start) {
            item.add(n);
            helper(result, item, 1, n);
            item.remove(item.size() - 1);
        }
    }
}
