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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node temp = stk.pop();
            res.add(0, temp.val);
            for (Node node : temp.children) {
                stk.push(node);
            }
        }
        return res;
    }
}
