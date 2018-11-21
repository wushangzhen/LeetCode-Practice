class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new LinkedList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> curList = new LinkedList<>(set);
            for (List<Integer> l : curList) {
                List<Integer> temp = new ArrayList<>(l);
                if (l.size() == 0 || l.get(temp.size() - 1) <= nums[i]) {
                    l.add(nums[i]);
                    set.add(l);
                }
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (List<Integer> list : set) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }
        return ans;
    }
}
