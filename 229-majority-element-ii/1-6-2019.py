class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        candidate1, count1 = None, 0
        candidate2, count2 = None, 0
        for num in nums:
            if num == candidate1:
                count1 += 1
            elif num == candidate2:
                count2 += 1
            elif count1 == 0:
                candidate1 = num
                count1 += 1
            elif count2 == 0:
                candidate2 = num
                count2 += 1
            else:
                count1 -= 1
                count2 -= 1
        count1, count2 = 0, 0
        for num in nums:
            if candidate1 == num:
                count1 += 1
            if candidate2 == num:
                count2 += 1
        n = len(nums)
        if count1 > n / 3 and count2 > n / 3:
            return [candidate1, candidate2]
        elif count1 > n / 3:
            return [candidate1]
        elif count2 > n / 3:
            return [candidate2]
        else:
            return []
