public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    private int[] father = null;
    List<Integer> list = new ArrayList<Integer>();
    public int find(int x) {
        while (father[x] != x) {
            list.add(x);
            x = father[x];
        }
        for (int l : list) {
            father[l] = x;
        }
        list.clear();
        return x;
    }
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
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
            father[rootB] = rootA;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}
