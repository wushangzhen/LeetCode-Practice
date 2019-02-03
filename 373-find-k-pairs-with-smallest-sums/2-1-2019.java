class Point {
    int index1;
    int index2;
    int sum;
    public Point(int index1, int index2, int sum) {
        this.index1 = index1;
        this.index2 = index2;
        this.sum = sum;
    }
}
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        Queue<Point> q = new PriorityQueue<>((a, b)->(a.sum - b.sum));
        q.add(new Point(0, 0, nums1[0] + nums2[0]));
        int n = nums1.length;
        int m = nums2.length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while (res.size() < k && !q.isEmpty()) {
            Point temp = q.poll();
            int[] t = new int[]{nums1[temp.index1], nums2[temp.index2]};
            res.add(t);
            if (temp.index1 + 1 < nums1.length && !visited[temp.index1 + 1][temp.index2]) {
                visited[temp.index1 + 1][temp.index2] = true;
                q.add(new Point(temp.index1 + 1, temp.index2, nums1[temp.index1 + 1] + nums2[temp.index2]));
            }
            if (temp.index2 + 1 < nums2.length && !visited[temp.index1][temp.index2 + 1]) {
                visited[temp.index1][temp.index2 + 1] = true;
                q.add(new Point(temp.index1, temp.index2 + 1, nums1[temp.index1] + nums2[temp.index2 + 1]));
            }
        }
        return res.size() <= k ? res : new ArrayList<>();
    }
}
