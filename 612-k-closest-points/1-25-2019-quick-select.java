class Solution {
    public int[][] kClosest(int[][] points, int K) {
        helper(points, 0, points.length - 1, K - 1);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    void helper(int[][] points, int start, int end, int index) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        int[] pivot = points[mid];
        int l = start;
        int r = end;
        while (l <= r) {
            while (l <= r && compare(pivot, points[l])) {
                l++;
            }
            while (l <= r && compare(points[r], pivot)) {
                r--;
            }
            if (l <= r) {
                swap(points, l , r);
                l++;
                r--;
            }
        }
        if (r >= index) {
            helper(points, start, r, index);
        }
        if (l <= index) {
            helper(points, l, end, index);
        }
        return;
    } 
    void swap(int[][] points, int l, int r) {
        int[] temp = points[l];
        points[l] = points[r];
        points[r] = temp;
    }
    
    boolean compare(int[] point1, int[] point2) {
        return (point1[0] * point1[0] + point1[1] * point1[1] - point2[0] * point2[0] - point2[1] * point2[1]) > 0;
    }
}
