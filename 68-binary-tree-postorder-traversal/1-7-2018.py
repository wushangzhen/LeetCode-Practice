# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        stack = []
        curNode = root
        while stack or curNode:
            while curNode:
                stack.append(curNode)
                curNode = curNode.left if curNode.left else curNode.right
            curNode = stack.pop()
            result.append(curNode.val)
            if stack and stack[-1].left == curNode:
                curNode = stack[-1].right
            else:
                curNode = None
        return result
