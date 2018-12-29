public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    int colNum;
    int rowNum;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.colNum = 0;
        this.rowNum = 0;
    }

    @Override
    public Integer next() {
        int res = vec2d.get(colNum).get(rowNum);
        rowNum++;
        if (rowNum == vec2d.get(colNum).size()) {
            rowNum = 0;
            colNum++;
        }
        return res;
        
    }

    @Override
    public boolean hasNext() {
        while (colNum < vec2d.size() && (vec2d.get(colNum) == null || vec2d.get(colNum).size() == 0)) {
            colNum++;
        }
        if (colNum >= vec2d.size()) {
            return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
