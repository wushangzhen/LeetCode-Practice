public class Solution {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        int[][] colSum = getColSum(matrix);
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int[] compressed = compress(colSum, i, j);
                List<Integer> list = helper(compressed);
                if (list.size() == 2) {
                    int[][] res = {{j, list.get(0)}, {i - 1, list.get(1)}};
                    return res;
                }
            }
        }
        int[][] res = new int[2][2];
        return res;
    }
    
    int[] compress(int[][] colSum, int i, int j) {
        int[] res = new int[colSum[0].length];
        for (int k = 0; k < colSum[0].length; k++) {
            res[k] = colSum[i][k] - colSum[j][k];
        }
        return res;
    }
    List<Integer> helper(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum));
                res.add(i);
                return res;
            }
            // 如果出现相等的情况就说明我们应该从这个值的后一个节点来取区间
            map.put(sum, i + 1);// 为什么是 + 1
        }
        return res;
    }
    int[][] getColSum(int[][] matrix) {
        int[][] res = new int[matrix.length + 1][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 1; i <= matrix.length; i++) {
                sum += matrix[i - 1][j];
                res[i][j] = sum;
            }
        }
        return res;
    }
}
