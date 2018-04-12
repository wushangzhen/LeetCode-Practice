#include <iostream>
#include <queue>
#include <unordered_set>
#include <stack>
//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool findTarget(TreeNode* root, int k) {
  std::unordered_set<int> s;
  std::queue<TreeNode*> que;
  que.push(root);
  TreeNode* temp;
  while (que.size()) {
    temp = que.front();
    que.pop();
    if (temp) {
      if (s.count(k - temp->val)) {
        return true;
      }
      else {
        s.insert(s.end(), temp->val);
      }
      if (temp->left != NULL) {
        que.push(temp->left);
      }
      if (temp->right != NULL) {
        que.push(temp->right);
      }
    }
  }
  return false;
}
bool findTarget1(TreeNode* root, int k) {
       std::unordered_set<int> s;
       std::stack<TreeNode*> q;
        q.push(root);
        TreeNode *temp;
        while(q.size())
        {
            temp = q.top();
            q.pop();
            if(temp){
                if(s.count(k-temp->val)) return true;
                else s.insert(temp->val);
                if(temp->right) q.push(temp->right);
                if(temp->left) q.push(temp->left);
            }
        }
        return false;
    }


int main() {
  TreeNode node0(1);
  TreeNode node1(2);
  TreeNode node2(3);
  TreeNode node3(4);
  node0.left = &node1;
  node1.left = &node2;
  node2.right = &node3;
  std::cout << findTarget(&node0, 5)<< std::endl;
  std::cout << findTarget(&node0, 1)<< std::endl;

}
