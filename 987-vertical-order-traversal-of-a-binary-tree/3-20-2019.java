/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Location {
    int x;
    int y;
    int val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Location> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        Collections.sort(list, new Comparator<Location>() {
            public int compare(Location a, Location b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                if (a.y != b.y) {
                    return a.y - b.y;
                }
                return a.val - b.val;
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < list.size(); i++) {
            if (res.size() == 0 || list.get(i).x != last) {
                res.add(new ArrayList<>());
            } 
            res.get(res.size() - 1).add(list.get(i).val);
            last = list.get(i).x;
        }
        return res;
    }
    private void dfs(TreeNode root, int x, int y, List<Location> list) {
        if (root != null) {
            list.add(new Location(x, y, root.val));
            dfs(root.left, x - 1, y + 1, list);
            dfs(root.right, x + 1, y + 1, list);
        }
    }
    
}
