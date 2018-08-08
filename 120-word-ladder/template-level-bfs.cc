queue<T> que;
unordered_set<T> unSet;

que.push(start);
unSet.insert(start);

while (!que.empty()) {
    int size = que.size();
    for (int i = 0; i < size; i++) {
        T head = que.front();
        que.pop();
        for (T neighbor : head.neighbors) {
            if (unSet.find(neighbor) != unSet.end()) {
                unSet.insert(neighbor);
                que.push(neighbor);
            }
        }
    }
}
