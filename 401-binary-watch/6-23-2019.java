class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] hs = {8, 4, 2, 1};
        int[] ms = {32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = generate(hs, i);
            List<Integer> minutes = generate(ms, num - i);
            for (int hour : hours) {
                if (hour > 11) {
                    continue;
                }
                for (int min : minutes) {
                    if (min > 59) {
                        continue;
                    }
                    String str = hour + ":" + ((min < 10) ? ("0" + min) : min);
                    res.add(str);
                }
            }
        }
        return res;
    }
    List<Integer> generate(int[] arr, int count) {
        List<Integer> res = new ArrayList<>();
        generateHelper(arr, 0, 0, count, res);
        return res;
    }
    void generateHelper(int[] arr, int pos, int sum, int count, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = pos; i < arr.length; i++) {
            generateHelper(arr, i + 1, sum + arr[i], count - 1, res);
        }
    }
}
