public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        if (arrs == null || arrs.length == 0) {
            return 0;
        }
        int n = arrs.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arrs[i].length == 0) {
                return 0;
            } else {
                if (min > arrs[i].length) {
                    min = arrs[i].length;
                    minIndex = i;
                }
                Set<Integer> set = new HashSet<>();
                for (int x : arrs[i]) {
                    set.add(x);
                }
                list.add(set);
            }
        }
        int count = 0;
        Iterator<Integer> it = list.get(minIndex).iterator();
        while (it.hasNext()) {
            if (checkAll(it.next(), list)) {
                count++;
            }
        }
        return count;
    }
    boolean checkAll(int value, List<Set<Integer>> list) {
        for (Set<Integer> set : list) {
            if (!set.contains(value)) {
                return false;
            }
        }
        return true;
    }
}
