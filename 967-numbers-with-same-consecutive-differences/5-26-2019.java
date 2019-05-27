class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 1; i < N; i++) {
            List<Integer> list2 = new ArrayList<>();
            for (int item : list) {
                int last = item % 10;
                if (item != 0 && last + K <= 9) {
                    list2.add(item * 10 + last + K);
                } 
                if (item != 0 && last - K >= 0 && K > 0) {
                    list2.add(item * 10 + last - K);
                }
            }
            list = list2;
        }
        return list.stream().mapToInt(j->j).toArray();
    }
}
