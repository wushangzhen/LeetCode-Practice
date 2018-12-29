public class Vector2D implements Iterator<Integer> {
    Iterator<Integer> it1;
    Iterator<List<Integer>> it2;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.it2 = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return it1.next();
    }

    @Override
    public boolean hasNext() {
        while ((it1 == null || !it1.hasNext()) && it2.hasNext()) {
            it1 = it2.next().iterator();
        }
        if ((!it2.hasNext() && it1 != null && it1.hasNext()) || it2.hasNext()) {
            return true;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
