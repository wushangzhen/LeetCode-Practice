public class Solution {
    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || queries == null || queries.length == 0) {
            return result;
        }
        for (int query : queries) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
               if (A[i] < query) {
                   count++;
               }
            }
            result.add(count);
        }
        return result;
    }
}
