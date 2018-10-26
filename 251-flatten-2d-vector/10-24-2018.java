public class Vector2D implements Iterator<Integer> {
    int indexVec;
    int indexElem;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        indexVec = 0;
        indexElem = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int res = vec2d.get(indexVec).get(indexElem++);
            if (indexElem == vec2d.get(indexVec).size()) {
                indexElem = 0;
                indexVec++;
            }
            return res;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (indexVec < vec2d.size() && vec2d.get(indexVec).size() == 0) {
            indexVec++;
        }
        return indexVec < vec2d.size() && indexVec >= 0 && indexElem < vec2d.get(indexVec).size() && indexElem >= 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
