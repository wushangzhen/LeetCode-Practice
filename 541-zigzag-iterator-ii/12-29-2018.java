public class ZigzagIterator2 {
    /*
    * @param vecs: a list of 1d vectors
    */
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        queue = new LinkedList<>();
        for (List<Integer> list : vecs) {
            if (list.iterator().hasNext()) {
                queue.add(list.iterator());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        Iterator<Integer> it = queue.poll();
        int res = it.next();
        if (it.hasNext()) {
            queue.add(it);
        }
        return res;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
