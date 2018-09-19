public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    private int[] father = null;
    int count = 0;
    private int find(int x) {
        List<Integer> list = new ArrayList<>();
        while (father[x] != x) {
            list.add(x);
            x = father[x];
        }
        for (int l : list) {
            father[l] = x;
        }
        return x;
    }
    public ConnectingGraph3(int n) {
        father = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            father[i] = i;
            count++;
        }
    }
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return count;
    }
}
