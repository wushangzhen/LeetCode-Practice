public class ZigzagIterator {
    Iterator<Integer> p1;
    Iterator<Integer> p2;
    int count = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        p1 = v1.iterator();
        p2 = v2.iterator();
    }

    public int next() {
        if (count % 2 == 0) {
            count++;
            if (p1.hasNext()) {
                return p1.next();
            } else {
                return p2.next();
            } 
        } else {
            count++;
            if (p2.hasNext()) {
                return p2.next();
            } else {
                return p1.next();
            }
        }
    }

    public boolean hasNext() {
        return p1.hasNext() || p2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
