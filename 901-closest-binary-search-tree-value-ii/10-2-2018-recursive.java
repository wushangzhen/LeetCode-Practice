class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, target, k, result);
        return result; 
    }
    private void inorder(TreeNode node, double target, int k, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, target, k, result);
        if (result.size() < k) {
            result.add(node.val);
        } else {
            if (Math.abs(node.val - target) < Math.abs(result.get(0) - target)) {
                result.remove(0);
                result.add(node.val);
            }
        }
        inorder(node.right, target, k, result);
    }
}
