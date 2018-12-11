class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode p;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
public class Test {
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.p == prev) {
                System.out.println(curr.val);
                prev = curr;
                if (curr.left != null) {
                    curr = curr.left;
                } else if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.p;
                }
            } else if (curr.left == prev) {
                prev = curr;
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.p;
                }
            } else if (curr.right == prev) {
                prev = curr;
                curr = curr.p;
            }
        }

    }

}
