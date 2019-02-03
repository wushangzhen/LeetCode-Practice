/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        helper(robot, 0, 0, 0, visited);
    }
    void helper(Robot robot, int x, int y, int curDir, Set<String> visited) {
        String tmp = (String.valueOf(x) + "#" + String.valueOf(y));
        if (visited.contains(tmp)) {
            return;
        }
        robot.clean();
        visited.add(tmp);
        for(int n = 0; n < 4; n++) {
            if (robot.move()) {
                int nx = x;
                int ny = y;
                switch (curDir) {
                    case 0:
                        ny = y - 1;
                        break;
                    case 1:
                        nx = x + 1;
                        break;
                    case 2:
                        ny = y + 1;
                        break;
                    case 3:
                        nx = x - 1;
                        break;
                }
                helper(robot, nx, ny, curDir, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            curDir = (curDir + 1) % 4;
        }
    }
}
