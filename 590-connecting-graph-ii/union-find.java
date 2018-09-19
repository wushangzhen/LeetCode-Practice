
public class ConnectingGraph2 {
    /*
    * @param n: An integer
    */
    private int[] father = null;
    private int[] size = null;
    private int find(int x) {
        List<Integer> list = new ArrayList<>();
        while (father[x] != x) {
            list.add(x);
            x = father[x];
        }
        for (int n : list) {
            father[n] = x;
        }
        return x;
    }
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            father[i] = i;
            size[i] = 1;
            
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int rootA = find(a);
        return size[rootA];
    }
}
