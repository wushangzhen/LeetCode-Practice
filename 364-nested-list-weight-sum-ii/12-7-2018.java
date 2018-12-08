/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int depth = 1;
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        for (NestedInteger x : nestedList) {
            depth = Math.max(find(x, 1), depth);
        }
        for (NestedInteger x : nestedList) {
            dfs(x, depth);
        }
        return sum;
    }
    int find(NestedInteger x, int dep) {
        if (x.isInteger()) {
            return dep;
        }
        int max = Integer.MIN_VALUE;
        for (NestedInteger temp : x.getList()) {
            max = Math.max(find(temp, dep + 1), max);
        }
        return max;
    }
    void dfs(NestedInteger x, int depth) {
        if (x.isInteger()) {
            sum += x.getInteger() * depth;
            return;
        }
        for (NestedInteger temp : x.getList()) {
            dfs(temp, depth - 1);
        }
    }
}
