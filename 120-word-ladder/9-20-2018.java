public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || start.length() == 0) {
            return 0;
        }
        if (end == null || end.length() == 0) {
            return 0;
        }
        Set<String> hashSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.add(start);
        hashSet.add(start);
        dict.add(start);
        dict.add(end);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                String temp = queue.poll();
                if (temp.equals(end)) {
                    return count;
                }
                char[] tc = temp.toCharArray();
                for (int i = 0; i < tc.length; i++) {
                    char[] tep = tc.clone();
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (tep[i] == j) {
                            continue;
                        }
                        tep[i] = j;
                        String newStr = new String(tep);
                        if (dict.contains(newStr) && !hashSet.contains(newStr)) {
                            System.out.println(newStr);
                            queue.add(newStr);
                            hashSet.add(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
