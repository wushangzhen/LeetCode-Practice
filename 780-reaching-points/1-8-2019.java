class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx > ty) {
                if (ty == sy) {
                    if ((tx - sx) % ty == 0) {
                        return true;
                    }
                }
                tx %= ty;
            } else {
                if (tx == sx) {
                    if ((ty - sy) % tx == 0) {
                        return true;
                    }
                }
                ty %= tx;
            }
        }
        return tx == sx && ty == sy;
    }
}
