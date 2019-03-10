/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        helper(root, map1, map2);
        Set<Integer> set = map2.get(max);
        int[] res = new int[set.size()];
        int index = 0;
        for (int i : set) {
            res[index++] = i;
        }
        return res;
    }
    int helper(TreeNode root, Map<Integer, Integer> map1, Map<Integer, Set<Integer>> map2) {
        if (root == null) {
            return 0;
        }
        int lsum = helper(root.left, map1, map2);
        int rsum = helper(root.right, map1, map2);
        int sum = lsum + rsum + root.val;

        if (map1.containsKey(sum)) {
            map2.get(map1.get(sum)).remove(sum);
            map1.put(sum, map1.get(sum) + 1);
            map2.putIfAbsent(map1.get(sum), new HashSet<>());
            map2.get(map1.get(sum)).add(sum);
        } else {
            map1.put(sum, 1);
            map2.putIfAbsent(map1.get(sum), new HashSet<>());
            map2.get(map1.get(sum)).add(sum);
        }
        max = Math.max(map1.get(sum), max);
        return sum;
    }
}
