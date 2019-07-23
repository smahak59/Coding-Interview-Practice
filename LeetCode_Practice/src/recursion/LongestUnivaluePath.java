package recursion;
/*687. Longest Univalue Path
        Easy

        1026

        257

        Favorite

        Share
        Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

        The length of path between two nodes is represented by the number of edges between them.



        Example 1:

        Input:

        5
        / \
        4   5
        / \   \
        1   1   5
        Output: 2



        Example 2:

        Input:

        1
        / \
        4   5
        / \   \
        4   4   5
        Output: 2



        Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
*/

 // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        findMaxPathWithRootVal(root);
        return ans;
    }
    public int findMaxPathWithRootVal(TreeNode root){
        if(root == null) return 0;
        int leftMax = findMaxPathWithRootVal(root.left);
        int rightMax = findMaxPathWithRootVal(root.right);

        int leftPath = 0, rightPath = 0;
        if(root.left!=null && root.val == root.left.val)
            leftPath = leftMax+1;
        if(root.right!=null && root.val == root.right.val)
            rightPath = rightMax+1;

        ans = ans>(leftPath+rightPath)?ans:(leftPath+rightPath);
        int maxPath = leftPath>rightPath ? leftPath:rightPath;
        return maxPath;

    }
}
