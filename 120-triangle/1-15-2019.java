class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[i + 1]);
        }
        list.get(0)[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            list.get(i)[0] = list.get(i - 1)[0] + triangle.get(i).get(0);
            list.get(i)[i] = list.get(i - 1)[i - 1] + triangle.get(i).get(i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                list.get(i)[j] = Math.min(list.get(i - 1)[j - 1], list.get(i - 1)[j]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            min = Math.min(list.get(n - 1)[i], min);
        }
        return min;
    }
}
