public class Vector2D implements Iterator<Integer> {
    int indexVec;
    int indexElem;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.indexVec = 0;
        this.indexElem = 0;
    }

    @Override
    public Integer next() {
        if (indexElem == vec2d.get(indexVec).size() - 1) {
            int value = vec2d.get(indexVec).get(indexElem);
            indexVec++;
            indexElem = 0;
            return value;
        } else {
            int value = vec2d.get(indexVec).get(indexElem);
            indexElem++;
            return value;
        }
        
    }

    @Override
    public boolean hasNext() {
        while (indexVec < vec2d.size() && (vec2d.get(indexVec) == null || vec2d.get(indexVec).size() == 0)) {
            indexVec++;
        }
        if (indexVec < vec2d.size() && indexElem < vec2d.get(indexVec).size()) {
            return true;
        }
        return false; 
    }
}
