package recursion;


import java.util.Stack;


/*
* 783. Minimum Distance Between BST Nodes
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2,
also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
* */

//  Definition for a binary tree node.
class Node {
      int val;
      Node left;
      Node right;
      Node(int x) { val = x; }
 }

 //Using iterative in-order traversal
class Solution1 {
    public int minDiffInBST(Node root) {
        int minDiff = Integer.MAX_VALUE;
        Node prev = null;
        Stack<Node> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node node = stack.pop();
                if (prev != null) minDiff = Math.min(minDiff, Math.abs(prev.val - node.val));
                prev = node;
                root = node.right;
            }
        }

        return minDiff;
    }
}
//BTW, here is the recursive solution using Global Variables

/**
 * Definition for a binary tree node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node(int x) { val = x; }
 * }
 */

//using recursive in-order traversal
class Solution2 {
    int minDiff = Integer.MAX_VALUE;
    Node prev = null;
    public int minDiffInBST(Node root) {
        helper(root);
        return minDiff;
    }

    void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null) minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
        prev = root;
        helper(root.right);
    }
}