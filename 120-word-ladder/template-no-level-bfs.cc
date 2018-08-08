queue<T> que;
unordered_set<T> unSet;

set.insert(start);
que.push(start);
while (!que.empty()) {
    T head = que.front();
    que.pop();
    for (T neighbor : head.neighbor) {
        if (set.find(neighbor) != set.end()) {
            set.insert(neighbor);
            que.push(neighbor);
        }
    }
}
