/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int[] d=new int[1];
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;

        height(root);

        return d[0];    
    }
    int height(TreeNode root)
    {
        if(root==null)
            return 0;

        d[0]=Math.max(d[0],height(root.left)+height(root.right));

        return 1 + Math.max(height(root.left),height(root.right));    
    }
}
