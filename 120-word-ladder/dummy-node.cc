queue<T> que;
que.push(start);
que.push(NULL);
currentLevel = 0;

while (que.size() > 1) {
    T head = que.front();
    if (head == NULL) {
        currentLevel+:
        que.push(NULL);
        continue;
    }
    for (all neighbors of head) {
        que.push(neighbor);
    }
}
