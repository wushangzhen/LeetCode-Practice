class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        char[] cs = { 'A', 'G', 'C', 'T'};
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String b : bank) {
            set.add(b);
        }
        q.add(start);
        visited.add(start);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String str = q.poll();
                if (str.equals(end)) {
                    return res;
                }
                char[] sc = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {
                    char old = sc[i];
                    for (char c : cs) {
                        sc[i] = c;
                        String ss = String.valueOf(sc);
                        if (set.contains(ss) && !visited.contains(ss)) {
                            q.add(ss);
                            visited.add(ss);
                        }
                    }
                    sc[i] = old;
                } 
            }
            res++;
        }
        return -1;
    }
}
