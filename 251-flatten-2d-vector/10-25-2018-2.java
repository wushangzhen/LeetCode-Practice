public class Vector2D implements Iterator<Integer> {
    Iterator<Integer> it1;
    Iterator<List<Integer>> it2;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.vec2d = vec2d;
        it2 = vec2d.iterator();
        
    }

    @Override
    public Integer next() {
        // Write your code here
        //if (hasNext())
            return it1.next();
        //return null;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while ((it1 == null || !it1.hasNext()) && it2.hasNext()) {
            it1 = it2.next().iterator();
        }
        return it1 != null && it1.hasNext();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
