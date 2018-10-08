public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        queue.add(list);
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll(); 
            if (path.size() == nums.length) {
                results.add(new ArrayList<Integer>(path));
                continue;
            }
            for (int i = 0; i < nums.length; i++) {
                List<Integer> temp = new ArrayList<>(path);
                if (i != 0 && nums[i] == nums[i - 1] && hash.contains(nums[i - 1])) {
                    continue;
                }
                if (temp.size() == 0) {
                    if (hash.contains(nums[i])) {
                        continue;
                    } else {
                        hash.add(nums[i]);
                    }
                }
                temp.add(nums[i]);
                queue.add(new ArrayList<>(temp));
            }
        }
        return results;
    }
};
