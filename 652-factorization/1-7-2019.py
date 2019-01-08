class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        result = []
        self.helper(result, [], n, 2)
        return result
    def helper(self, result, item, n, start):
        if n <= 1:
            if len(item) > 1:
                result.append(item[:])
            return
        import math
        for i in xrange(start, int(math.sqrt(n)) + 1):
            if n % i == 0:
                item.append(i)
                self.helper(result, item, n / i, i)
                item.pop()
        if n >= start:
            item.append(n)
            self.helper(result, item, 1, n)
            item.pop()
