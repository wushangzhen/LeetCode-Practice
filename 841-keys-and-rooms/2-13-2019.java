class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] color = new int[n];
        dfs(0, rooms, color);
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                return false;
            }
        }
        return true;
    }
    void dfs(int start, List<List<Integer>> rooms, int[] color) {
        color[start] = 1;
        List<Integer> room = rooms.get(start);
        for (int i = 0; i < room.size(); i++) {
            if (color[room.get(i)] == 0) {
                dfs(room.get(i), rooms, color);
            }
        }
    }
}
