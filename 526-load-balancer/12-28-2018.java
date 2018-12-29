public class LoadBalancer {
    Map<Integer, Integer> val2Index;
    List<Integer> list;
    Random rnd;
    int n;
    public LoadBalancer() {
        // do intialization if necessary
        val2Index = new HashMap<>();
        list = new ArrayList<>();
        rnd = new Random();
        n = 0;
        
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        if (!val2Index.containsKey(server_id)) {
            val2Index.put(server_id, n++);
            list.add(server_id);
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        if (val2Index.containsKey(server_id)) {
            int removeIndex = val2Index.get(server_id);
            int last = list.get(n - 1);
            list.set(removeIndex, last);
            val2Index.put(last, removeIndex);
            val2Index.remove(server_id);
            list.remove(n - 1);
            n--;
        }
        
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return list.get(rnd.nextInt(n));
    }
}
