/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        if (root == null) {
            return res;
        }
        stk.push(root);
        while (!stk.isEmpty()) {
            Node temp = stk.pop();
            res.add(temp.val);
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stk.push(temp.children.get(i));
            }
        }
        return res;
    }
}
