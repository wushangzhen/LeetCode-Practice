class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.queue = [v for v in (v1, v2) if v]
        

    def next(self):
        """
        :rtype: int
        """
        v = self.queue.pop(0)
        value = v.pop(0)
        if v:
            self.queue.append(v)
        return value
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.queue) > 0
        

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())
