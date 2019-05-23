/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        return helper(0, 0, grid.length - 1, grid.length - 1, grid);
    }
    Node helper(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 > r2 || c1 > c2) {
            return null;
        }
        boolean isLeaf = true;
        int val = grid[r1][c1];
        outer: for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break outer;
                }
            }
        }
        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }
        int mid1 = (r1 + r2) / 2;
        int mid2 = (c1 + c2) / 2;
        Node topLeft = helper(r1, c1, mid1, mid2, grid);
        Node topRight = helper(r1, mid2 + 1, mid1, c2, grid);
        Node bottomLeft = helper(mid1 + 1, c1, r2, mid2, grid);
        Node bottomRight = helper(mid1 + 1, mid2 + 1, r2, c2, grid);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
