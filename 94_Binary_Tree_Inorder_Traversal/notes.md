inorder traversal

it is easy to solve it through recursive method

However, if we use iterative method, we have to use stack because it is first in 

last out base.  After we visit a leftchild we have to make a mark for that. 

so that we will not visit it again.

What we have to do is make sure every stack pop, we should have only nodes and 
its right child. push current temp variable into vec
