根据前序遍历和中序遍历重建二叉树，方法是自顶向下recursive来构建。前序就是 root -> left -> right，中序是 left -> root -> right。所以每次preorder[preLo]就是root。接下来preorder[preLo + 1]就是当前root的left child， 接下来在inorder中找到root的index  - rootAtInorder，则 inorder[rootAtInOrder + 1]就是当前root的right child。最后做递归的时候要注意，求left child时，inHi = rootAtInOrder - 1，求right child时， inLo = rootAtInOrder + 1。  应该还有不少更简便的方法，要好好想一想。


其先序遍历结果是：【4 2 1 3 7 6 9】 
中序遍历结果是：【1 2 3 4 6 7 9】
对先序遍历来说：
先序遍历的每个值表示的结点都是接下来的若干结点的父结点。
比如【4】是这个二叉树的根结点。 
【2】是【1 3】的父结点。 
【1】是 空的父结点，也即使叶子结点。
对中序遍历来说：
根结点一定在中间位置，中间左边是左子树，右边是右子树。 
比如【4】左边是【1 2 3】是根结点的左子树，右边是【6 7 9】是根结点的右子树。 
对于【2】来说，【1】是其左子树，【3】是其右子树。 
…… 
依次类推。
很明显，这是一个递归过程。


