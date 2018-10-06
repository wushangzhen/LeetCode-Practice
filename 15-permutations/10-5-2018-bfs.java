public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<Integer>());
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            if (list.size() == nums.length) {
                result.add(new ArrayList<Integer>(list));
            }
            for (int i = 0; i < nums.length; i++) {
                List<Integer> listTemp = new ArrayList<>(list);
                if (listTemp.contains(nums[i])) {
                    continue;
                } 
                listTemp.add(nums[i]);
                queue.add(new ArrayList<Integer>(listTemp));
            }
        }
        return result;
    }
}
