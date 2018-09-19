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
        Arrays.sort(A);
        for (int query : queries) {
            int start = 0;
            int end = A.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] < query) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (end < 0 || A[end] < query) {
                result.add(end + 1);
            } else if (A[start] >= query) { 
                result.add(start);
            } else {
                result.add(start + 1);
            }
        }
        return result;
    }
}
