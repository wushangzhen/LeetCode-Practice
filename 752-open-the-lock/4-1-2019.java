class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String start = "0000";
        if (set.contains(start)) {
            return -1;
        }
        visited.add(start);
        q.add(start);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    char[] temp = s.toCharArray();
                    if (temp[j] != '9') {
                        temp[j]++; // has to be temp[j]++ not temp[j] = temp[j] + 1. The second contains implicit narrawing conversion
                    } else {
                        temp[j] = '0';
                    }
                    String temp1 = String.valueOf(temp);
                    temp = s.toCharArray(); // cannot be temp = sc;
                    if (temp[j] != '0') {
                        temp[j]--;
                    } else {
                        temp[j] = '9';
                    }
                    String temp2 = String.valueOf(temp);
                    if (!visited.contains(temp1) && !set.contains(temp1)) {
                        visited.add(temp1);
                        q.add(temp1);
                    }
                    if (!visited.contains(temp2) && !set.contains(temp2)) {
                        visited.add(temp2);
                        q.add(temp2);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
