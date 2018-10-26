public class Vector2D implements Iterator<Integer> {
    int index1;
    int index2;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        index1 = 0;
        index2 = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        // Write your code here
        if (hasNext()) {
            int res = vec2d.get(index1).get(index2++);
            if (index2 == vec2d.get(index1).size()) {
                index1++;
                index2 = 0;;
            }
            return res;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (index1 < vec2d.size() && (vec2d.get(index1) == null || vec2d.get(index1).size() == 0)) {
            index1++;
        }
        if (index1 >= vec2d.size()) {
            return false;
        } else if (index1 == vec2d.size() - 1 && index2 == vec2d.get(index1).size()) {
            return false;
        }
        return true;
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
