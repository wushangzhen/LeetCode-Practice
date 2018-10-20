class TwitterOA1 {

    /*
     * Complete the 'closest' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> closest(String s, List<Integer> queries) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] sc = s.toCharArray();
        int n = sc.length;
        for (i = 0; i < n; i++) {
            if (!map.containsKey(sc[i])) {
                map.computeIfAbsent(sc[i], k -> new ArrayList<>()).add(i);
            } else {
                map.get(sc[i]).add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        int m = queries.size();
        for (int i = 0; i < m; i++) {
            char c = sc[queries.get(i)];
            List<Integer> list = map.get(c);
            if (list.size() == 1) {
                result.add(-1);
            } else {
                result.add(binarySearch(list, queries.get(i)))
            }
        }
        return result;
      }
    int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size();
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == target) {
                return helper(list, mid);
            } else if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    int helper(List<Integer> list, int index) {
        if (index - 1 < 0) {
            return list.get(index + 1);
        }
        if (index + 1 >= list.size()) {
            return list.get(index - 1);
        }
        if (Math.abs(list.get(index - 1) - target) > Math.abs(list.get(index + 1) - target)) {
            return index + 1;
        } 
        return index - 1;
    
    }
}

