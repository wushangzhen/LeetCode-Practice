public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        helper(num, 0, target, new LinkedList<>(), res);
        return res;
    }
    void helper(int[] num, int start, int target, 
        List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (start >= num.length) {
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            helper(num, i + 1, target - num[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
