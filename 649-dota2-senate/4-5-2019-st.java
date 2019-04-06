class Solution {
    public String predictPartyVictory(String senate) {
        int[] people = new int[2];
        int[] ban = new int[2];
        Queue<Integer> q = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            int x = (c == 'R') ? 1 : 0;
            people[x]++;
            q.add(x);
        } 
        while (people[0] > 0 && people[1] > 0) {
            int x = q.poll();
            if (ban[x] > 0) {
                people[x]--;
                ban[x]--;
            } else {
                ban[x ^ 1]++;
                q.add(x); // 循环的所以要再加进去进行计算
            }
        }
        return people[0] > 0 ? "Dire" : "Radiant";
    }
}
