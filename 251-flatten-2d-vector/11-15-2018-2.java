public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> itVec;
    Iterator<Integer> itInt;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        itVec = vec2d.iterator();
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        return itInt.next();
        
    }

    @Override
    public boolean hasNext() {
        while ((itInt == null || !itInt.hasNext()) && itVec.hasNext()) {
            itInt = itVec.next().iterator();
        }
        if ((!itVec.hasNext() && itInt != null && itInt.hasNext()) || itVec.hasNext()) {
            return true;
        }
        return false;
    }
}
