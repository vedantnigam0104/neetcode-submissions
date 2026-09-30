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
        help(root);

        return d[0];    
    }
    int help(TreeNode root)
    {
        if(root==null)
            return 0;

        d[0]=Math.max(d[0],help(root.left)+help(root.right));

        return Math.max(help(root.left),help(root.right))+1;    
    }
}
