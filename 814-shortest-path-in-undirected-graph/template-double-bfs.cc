int doubleBFS(UndirecteGraphNode start, UndirecteGraphNode end) {
    if (start == end) {
        return 1;
    }
    queue<UndirecteGraphNode> queStart;
    queue<UndirecteGraphNode> queEnd;
    unordered_set<UndirecteGraphNode> unSetStart;
    unordered_set<UndirecteGraphNode> unSetEnd;
    queStart.push(start);
    queEnd.push(end);
    int step = 0;
    unSetStart.insert(start);
    unSetEnd.insert(end);
    while (!queStart.empty() || !queEnd.empty()) {
        int startSize = queStart.size();
        int endSize = queEnd.size();
        step++;
        for (int i = 0; i < startSize; i++) {
            auto head = queStart.front();
            queStart.pop();
            for (auto neighbor : neighbor of head) {
                if (unSetStart.find(neighbor) != unSetStart.end()) {
                    continue;
                }
                if (unSetEnd.find(neighbor) != unSetEnd.end()) {
                    return step;
                }
                queStart.push(neighbor);
                unSetStart.insert(neighbor);
            }
        }
        step++;
        for (int i = 0; i < endSize; i++) {
            auto head = queEnd.front();
            queEnd.pop();
            for (auto neighbor : neighbors of head) {
                if (!queEnd.find(neighbor) != queEnd.end()) {
                    continue;
                }
                if (!unSetStart.find(neighbor) != queStart.end()) {
                    return step;
                }
                queEnd.push(neighbor);
                unSetEnd.insert(neighbor);
            }
        }
        return -1;
    }
}
