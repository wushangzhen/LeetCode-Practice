class Solution {
    public int minCostII(int[][] costs) {
        // 维护四个临时变量，最小值，第二小值，和分别对应的颜色。
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int k = costs[0].length;
        int minCost = Integer.MAX_VALUE;
        int minColor = Integer.MAX_VALUE;
        int secondMinCost = Integer.MAX_VALUE;
        int secondMinColor = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (costs[0][i] <= minCost) {
                secondMinCost = minCost;
                minCost = costs[0][i];
                secondMinColor = minColor;
                minColor = i;
            } else if (secondMinCost >= costs[0][i]) {
                secondMinCost = costs[0][i];
                secondMinColor = i;
            }
        }
        for (int i = 1; i < n; i++) {
            int minCostTemp = Integer.MAX_VALUE;
            int minColorTemp = Integer.MAX_VALUE;
            int secondMinColorTemp = Integer.MAX_VALUE;
            int secondMinCostTemp = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (j != minColor) {
                    if (minCostTemp >= minCost + costs[i][j]) {
                        secondMinColorTemp = minColorTemp;
                        minColorTemp = j;
                        secondMinCostTemp = minCostTemp;
                        minCostTemp = minCost + costs[i][j];
                    } else if (secondMinCostTemp >= minCost + costs[i][j]) { //要更新相应的secondmincost，因为虽然可能不会小于最小值，但是可能会小于第二小的值
                        secondMinColorTemp = j;
                        secondMinCostTemp = minCost + costs[i][j];
                    }
                } else {
                    if (minCostTemp >= secondMinCost + costs[i][j]) {
                        secondMinColorTemp = minColorTemp;
                        minColorTemp = j;
                        secondMinCostTemp = minCostTemp;
                        minCostTemp = secondMinCost + costs[i][j];
                    } else if (secondMinCostTemp >= secondMinCost + costs[i][j]) {
                        secondMinColorTemp = j;
                        secondMinCostTemp = secondMinCost + costs[i][j];
                    }
                }
            }
            minCost = minCostTemp;
            minColor = minColorTemp;
            secondMinCost = secondMinCostTemp;
            secondMinColor = secondMinColorTemp;
        }
        return minCost;
    }
}
