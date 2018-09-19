/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<MultiTreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    int maxLength;
    int maxUp;
    int maxDown;
    ResultType(int maxLength, int maxUp, int maxDown) {
        this.maxLength = maxLength;
        this.maxUp = maxUp;
        this.maxDown = maxDown;
    }
}
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        ResultType result = helper(root);
        return result.maxLength;
    }
    public ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        ResultType newResult = new ResultType(0, 0, 0);
        int up = 0;
        int down = 0;
        int len = 0;
        for (MultiTreeNode child : root.children) {
            newResult = helper(child);
            if (child != null && child.val - 1 == root.val) {
                down = Math.max(down, newResult.maxDown + 1);
            }
            if (child != null && child.val + 1 == root.val) {
                up = Math.max(up, newResult.maxUp + 1);
            }
            int temp = up + down + 1;
            temp = Math.max(temp, newResult.maxLength);
            len = Math.max(len, temp);
        }
        return new ResultType(len, up, down);
    }
}
