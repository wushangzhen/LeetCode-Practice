class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        Set<String> set = new HashSet<>();
        for (int[] r : rectangles) {
            x1 = Math.min(r[0], x1);
            x2 = Math.max(r[2], x2);
            y1 = Math.min(r[1], y1);
            y2 = Math.max(r[3], y2);
            area += (r[2] - r[0]) * (r[3] - r[1]);
            String str1 = r[0] + " " + r[1];
            String str2 = r[0] + " " + r[3];
            String str3 = r[2] + " " + r[1];
            String str4 = r[2] + " " + r[3];
            if (!set.add(str1)) {
                set.remove(str1);
            }
            if (!set.add(str2)) {
                set.remove(str2);
            }
            if (!set.add(str3)) {
                set.remove(str3);
            }
            if (!set.add(str4)) {
                set.remove(str4);
            }
        }
        if (set.size() != 4 
            || !set.contains(x1 + " " + y1) 
            || !set.contains(x1 + " " + y2) 
            || !set.contains(x2 + " " + y2) 
            || !set.contains(x2 + " " + y1)) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
        
    }
}
