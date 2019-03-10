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
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int left = s.indexOf('(');
        if (left == -1) {
            return new TreeNode(Integer.parseInt(s));
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, left)));
            int right = left;
            int count = 0;
            for (; right < s.length(); right++) {
                if (s.charAt(right) == '(') {
                    count++;
                } else if (s.charAt(right) == ')') {
                    count--;
                }
                if (count == 0) {
                    break;
                }
            }
            root.left = str2tree(s.substring(left + 1, right));
            left = s.indexOf('(', right);
            if (left == -1) {
                return root;
            } else {
                right = left;
                count = 0;
                for (; right < s.length(); right++) {
                    if (s.charAt(right) == '(') {
                        count++;
                    } else if (s.charAt(right) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                root.right = str2tree(s.substring(left + 1, right));
            }
            return root;
        }  
    }
}
