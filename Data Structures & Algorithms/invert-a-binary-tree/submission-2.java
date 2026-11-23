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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;

        help(root);

        return root;
    }
    void help(TreeNode root)
    {
        if(root==null)
            return;

        TreeNode temp=root.left;

        root.left=root.right;

        root.right=temp;

        help(root.left);

        help(root.right);
            
        return;
    }
}
