public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>());
        while (!q.isEmpty()) {
            List<Integer> list = q.poll();
            res.add(new ArrayList<>(list));
            for (int i = 0; i < nums.length; i++) {
                if (list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
                    List<Integer> nextSubset = new ArrayList<>(list);
                    nextSubset.add(nums[i]);
                    q.add(nextSubset);
                }
            }
        }
        return res;
    }
}
