/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    int res;
    public int getImportance(List<Employee> employees, int id) {
        res = 0;
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        for (Employee e : employees) {
            if (e.id == id) {
                dfs(e, map, visited);
            }
        }
        return res;
    }
    void dfs(Employee e, Map<Integer, Employee> map, Set<Integer> visited) {
        if (visited.contains(e.id)) {
            return;
        }
        visited.add(e.id);
        res += e.importance;
        for (int i : e.subordinates) {
            dfs(map.get(i), map, visited);
        }
    }
}
