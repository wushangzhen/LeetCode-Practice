public class ClosestIndex {
    public static int find(String str, int index) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int n = str.length();
        Map<Character, List<Integer>> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (!count.containsKey(c)) {
                count.computeIfAbsent(c, a -> new ArrayList<>()).add(i);
            } else {
                count.get(c).add(i);
            }
        }
        return binarySearch(index, count, str);
    }
    int binarySearch(int index, Map<Character, List<Integer>> count, String str) {
        List<Integer> list = count.get(str.charAt(index)); 
        int left = 0;
        int right = list.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == index) {
                return find(mid, list);
            } else if (list.get(mid) < index) {
                start = mid;
            } else {
                end = start;
            }
        }
        if (start == index) {
            return find(start, list);
        } else {
            return find(end, list);
        }
    }
    int find(int index, List<Integer> list) {
        if (index == 0) {
            return list.get(index + 1);
        }
        if (index == list.size() - 1) {
            return list.get(list.size() - 2);
        }
        return (Math.abs(list.get(index - 1) - index) < list.get(index + 1) - index) ? list.get(index - 1) : list.get(index + 1);
    }    
}
